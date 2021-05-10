package tn.pi.services;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import antlr.StringUtils;
import freemarker.template.TemplateException;
import tn.pi.entities.Ads;
import tn.pi.entities.Category;
import tn.pi.entities.Product;
import tn.pi.repository.ProductRepository;
import tn.pi.repository.PromotionRepository;
import tn.pi.repository.CategoryRepository;
import tn.pi.repository.AdsRepository;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepository ProductRepository;
	@Autowired
	CategoryRepository CategoryRepository;
	@Autowired
	AdsRepository AdsRepository;
	@Autowired
	ProductService ProductService;
	@Autowired
	EmailService  emailService;
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
						emailService.sendMailMultipart("mohamedselim.aouini@esprit.tn","Expired products","HEY");
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
		ProductRepository.filterProductByCategory(categoryName);
		return null;
		
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

	@Transactional
	@Override
	public Product addProduct(Product prod, int idCategory) {
		
		/// prod.setCategoryname(category.getname);
		Category category = CategoryRepository.findById(idCategory).get();
		prod.setCategory(category);
	    
			   
		        prod.setCreatedAt(new Date());
				ProductRepository.save(prod);
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



	
	



	




	

	
}
