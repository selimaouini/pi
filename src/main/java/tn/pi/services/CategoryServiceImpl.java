package tn.pi.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pi.entities.Category;
import tn.pi.entities.Product;
import tn.pi.repositories.CategoryRepository;
import tn.pi.repositories.ProductRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
 
	@Autowired
	private CategoryRepository CategoryRepository;
	@Autowired
	private ProductRepository ProductRepository;
	@Override
	public int addCategory(Category c) {
		CategoryRepository.save(c);
		 return c.getIdCategory();
	}

	@Override
	public void deleteCategory(int idCategory) {
		CategoryRepository.deleteById(idCategory);
		
	}

	@Override
	public void updateCategory(Category c, int idCategory) {
		CategoryRepository.updateCategory(c.getName(),idCategory);
		
	}

	@Override
	public List<Category> getAllCategories() {
		return (List<Category>)CategoryRepository.findAll();	}

	@Override
	public Category findCategoryById(int id) {
		return CategoryRepository.findById(id).get();
	}

	@Override
	public Category findCategoryByName(String name) {
		return CategoryRepository.findCategoryByName(name);
	}

	@Override
	public void affecterCategoryProduct(int idp, int idc) {
		Category category = CategoryRepository.findById(idc).get();
        Product product = ProductRepository.findById(idp).get();
		product.setCategory(category);
		ProductRepository.save(product);
		
	}

}
