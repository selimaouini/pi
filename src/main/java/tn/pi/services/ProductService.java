package tn.pi.services;
import java.util.List;
import tn.pi.entities.Product;
public interface ProductService {
	public int addProduct(Product product);
    public void updateProduct (Product product, int idProduct);
    public int deleteProduct(int idProduct);
    public List<Product> getAllProducts();
    public Product getProductById(int id);
    public Product findProductByName(String name);
    public List<Product> getProductsByCategory(String categoryName);
    public List<Product> searchProducts(String productName,String categoryName);
    public boolean verifyProduct(String barCode);
    public Product findProductByBarCode(String barCode);
}
