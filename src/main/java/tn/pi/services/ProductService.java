package tn.pi.services;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import tn.pi.entities.Product;
public interface ProductService {
	//public String addProduct( int idCategory);
   // public void updateProduct (Product product,int idCategory);
    public void AddorupdateProduct (Product product,int idCategory);
    public int deleteProduct(int idProduct);
    public List<Product> getAllProducts();
    public Product getProductById(int id);
    public Product findProductByName(String name);
    public List<Product> getProductsByCategory(String categoryName);
    public List<Product> searchProducts(String productName,String categoryName);
    public boolean verifyProduct(String barCode);
    public Product findProductByBarCode(String barCode);
//	Product findProductByBarCode(int idCategory, Product prod);
	Product addProduct(Product prod,int idCategory);
	List<Product> filterProductByCategory(String categoryName);
	public Product findProductByCategoryId(int id);
	Product findProductByIdCategory(int id);
	Product findProductById(int id);
	String ExpiredProduct(int idProduct);
	//String addProduct();
	public void updateProduct(int idProduct,Product prod);
	
	
	
}
