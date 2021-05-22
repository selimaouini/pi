package tn.pi.services;
import java.io.InputStream;
import java.util.List;
import tn.pi.entities.Category;
public interface CategoryService {
	public int  addCategory(Category c);
	public void deleteCategory(int idCategory);
	public void updateCategory(Category c,int idCategory);
	public List<Category> getAllCategories();
	public Category findCategoryById(int id);
	public Category findCategoryByName(String name);
	public void affecterCategoryProduct(int idp,int idc);
	
}

