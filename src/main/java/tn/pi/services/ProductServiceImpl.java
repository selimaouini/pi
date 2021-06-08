package tn.pi.services;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import antlr.StringUtils;
import freemarker.template.TemplateException;
import tn.pi.entities.Ads;
import tn.pi.entities.Category;
import tn.pi.entities.Demandechange;
import tn.pi.entities.Etatdemande;
import tn.pi.entities.Product;
import tn.pi.entities.Promotion;
import tn.pi.entities.Rating;
import tn.pi.entities.Stock;
import tn.pi.repositories.ProductRepository;
import tn.pi.repositories.PromotionRepository;
import tn.pi.repositories.RatingRepository;
import tn.pi.repositories.demechangerep;
import tn.pi.repositories.CategoryRepository;
import tn.pi.repositories.IStockRepository;
import tn.pi.repositories.AdsRepository;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepository ProductRepository;
	@Autowired
	CategoryRepository CategoryRepository;
	@Autowired
	IStockRepository sr;
	@Autowired
	AdsRepository AdsRepository;
	@Autowired
	ProductService ProductService;
	@Autowired
	EmailService  emailService;
	@Autowired
	RatingRepository var3;
	@Autowired demandeechangeservice ds;
	@Autowired
	demechangerep dcr;
	/************************************VerifyProduct**************************************/
	@Override
	public boolean verifyProduct(String barCode) {
		    {
				System.out.println(barCode); 
				if (barCode.trim().startsWith("619")) {
					return true;
				} else
					return false;
			}
		   
	}
	
	/************************************ExpiredProduct**************************************/
	@Override
	public String ExpiredProduct(int idProduct) {
		
		        Product product = ProductRepository.findById(idProduct).get();
		        if(new Date().compareTo(product.getDateexpiration())>0){
		        	product.setExpired(true);
		        	ProductRepository.save(product);
		        
		        }
		       
		        try {
					try {
						emailService.sendMailMultipart("mohamedselim.aouini@esprit.tn","Expired products");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (TemplateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
	
		        
		       
				return "CHECK YOUR PRODUCT";
				
	}
	
	
	

	@Override
	public Product findProductById(int id) {
		return ProductRepository.findById(id).get();
	} 
	
	
	@Override
	public void updateProduct(int idProduct, Product prod) {
		Product product = ProductRepository.findById(idProduct).get();
		//Category category = CategoryRepository.findById(3).get();
		//product.setCategory(category);	
		ProductRepository.save(product);
		
	}

	@Override
	public int deleteProduct(int idProduct) {
		Product product = ProductRepository.findById(idProduct).get();
		ProductRepository.delete(product);
		return idProduct;
	}

	@Override
	public List<Product> getAllProducts() {
		return (List<Product>)ProductRepository.findAll();
	}

	  /**************Creating getByid method that retrieve product detail from database************/
		@Override
		public Product getProductById(int id) {
			int countView;
			Product p = ProductRepository.findById(id).get();
			if(p == null) return null;
			p.setMostViewed(p.getMostViewed()+1);
		    countView = ProductRepository.updateViewCountProduct(p.getMostViewed()-1,p.getIdProduct());
				countView++;
				return p;

			}
	/******************Creating getAll product by name method from database ********************/
	@Override
	public Product findProductByName(String name) {
		return ProductRepository.findProductByName(name);
	}

	/******************Creating getAll product by CategoryID method from database ********************/
	@Override
	public Product findProductByIdCategory(int id) {
		return (Product) ProductRepository.findProductByIdCategory(id);
	}
	/***************Creating getAll product by category method from database **************/
	@Override
	public List<Product>filterProductByCategory(String categoryName) {
		return ProductRepository.filterProductByCategory(categoryName);
		 
		
	}
	
	
	/****************Search product by Name and categoryName*********************/
	@Override
	public List<Product> searchProducts(String productName, String categoryName) {
		List<Product> products=(List<Product>) ProductRepository.findAll();
		boolean containsProd=true;
		boolean containsCat=true;
		List<Product> result=  new ArrayList<>();
		if ((productName==null)||(productName=="")) containsProd=false;
		if ((categoryName==null)||(categoryName=="")) containsCat=false;
		//if (!containsProd && !containsCat) return result;
		int nbProducts=products.size();	
		Product product=new Product();	
		if(!containsProd) {
			for(int i=0 ; i< nbProducts ; i++) {
				product = products.get(i);
				
				containsCat = true;
				
				if(product.getCategory().getName() == null) {
					containsCat =false;
					return null;
				}
				else {
					containsCat = product.getCategory().getName().contains(categoryName);
				}
				if(containsCat ==true) {
					
					result.add(product);
				}
		}
	
	}
		else 
			for(int i=0 ; i< nbProducts ; i++) {
				product = products.get(i);
				containsProd = true;
				
				if(product.getProductName() == null) {
					containsProd =false;
				}
				else {
					containsProd = product.getProductName().contains(productName);
				}
				if(containsProd ==true) {
					result.add(product);
				}
		}
		
	
		return result;
	}
	
	

	



	@Override
	public Product findProductByBarCode(String barCode) {
		// TODO Auto-generated method stub
		return null;
	}

	


	@Override
	public List<Product> getProductsByCategory(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Product findProductByCategoryId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	int idAds=38;
	@Transactional
	@Override
	
	public Product addProduct(Product prod) {
		
		/// prod.setCategoryname(category.getname);
		

		
	
	    
			   
		        prod.setCreatedAt(new Date());
		        Stock s = new Stock();
		        s.setDateCreation(new Date());
		        s.setProducts(prod);
		        s.setNomp(prod.getProductName());
		        s.setQuantity(30);
		        Category cat = new Category();
		        cat.setName(prod.getCateg());
		    	prod.setCategory(cat);
		        ProductRepository.save(prod);
		        sr.save(s);
		        CategoryRepository.save(cat);
		        
		        
		        return prod;
			
	}

	@Override
	public void AddorupdateProduct(Product product, int idCategory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String ExpiredProduct() {
		// TODO Auto-generated method stub
		return null;
	}



	
	@Override
	public Rating addEv(Rating e, Integer id) {
		
			
		Product c = ProductRepository.findById(id).get();
			
			List<Product> my = var3.evsave();
			if(my.contains(c)) {
				Rating v = var3.findev(c);
				
				v.setNbretoile(v.getNbretoile()+e.getNbretoile());
					
				var3.save(v);
				return v ;		
		}
			else {
				e.setProduct(c);
				var3.save(e);
				return e;
				
				
			}
		}



	@Override 
	 public Product getepuisé() {
		 return ProductRepository.expireddelete(new Date());
	 }

	@Transactional
	@Override
	@Scheduled(cron="* 05 * * * ?")
	public Product Expireddel() {
		
	Product prod =  ProductService.getepuisé();
	 if (prod !=null) {
		 if (ds.Catalog(prod.getProductName())!=null){
		Demandechange dc = new Demandechange();
			dc.setDateCreation(new Date());
			dc.setQuantity(prod.getStock().getQuantity());
			dc.setEtatdemande(Etatdemande.encours);
			dc.setNomp(prod.getProductName());
			Date dd = prod.getDateexpiration();
			dcr.save(dc);
			LocalDateTime dateaffect = dd.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			LocalDateTime tomorrow = dateaffect.plusDays(1);
			Date d= java.util.Date.from(tomorrow.atZone(ZoneId.systemDefault()).toInstant());
			prod.setDateexpiration(d);
			try {
				emailService.sendMail("Mohamedselim.aouini@esprit.tn", "Produit expiré ", "Le produit  "+prod.getProductName() + " est expiré , une demande d'échange a été envoyée");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
			
			ProductRepository.save(prod); } 
		 else  if (prod !=null) {
			 ProductRepository.deleteById(prod.getIdProduct());
			     
		
			 try {
				emailService.sendMail("Mohamedselim.aouini@esprit.tn", "Produit expiré ", "Le produit  "+prod.getProductName() + "est indisponible et suprimé automatiquement");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
	//	 ProductService.deleteProduct(ProductService.getepuisé().getIdProduct());
			 }}
	return prod;
	
			
		}

public Product sendmail()
{
	try {
		emailService.sendMailMultipart("mohamedselim.aouini@esprit.tn","Expired products");
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (TemplateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;


}
	

	
}
