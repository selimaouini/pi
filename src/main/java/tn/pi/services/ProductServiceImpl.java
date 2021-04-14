package tn.pi.services;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pi.entities.Product;
import tn.pi.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepository ProductRepository;
	@Override
	public int addProduct(Product product) {
		product.setCreatedAt(new Date());
		if(product.getBarCode().startsWith("619")){
			product.setPromotionEtat(false);
			ProductRepository.save(product);
			return product.getIdProduct();
		}
		return -1;

	}

	@Override
	public void updateProduct(Product product, int idProduct) {

		Product p = ProductRepository.findById(idProduct).get();
		product.setProductName(p.getProductName());
		product.setCreatedAt(p.getCreatedAt());
		product.setPrice(p.getPrice());
		//product.setTva(p.getTva());
		product.setDescription(p.getDescription());
		
		product.setPicture(p.getPicture());
		product.setWeigth(p.getWeigth());
		product.setNewProduct(p.isNewProduct());
		product.setCreatedAt(new Date());
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

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findProductByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductsByCategory(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> searchProducts(String productName, String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verifyProduct(String barCode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Product findProductByBarCode(String barCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
