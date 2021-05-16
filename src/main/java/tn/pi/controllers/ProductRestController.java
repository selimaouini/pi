package tn.pi.controllers;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import tn.pi.config.FileUploadUtil;
import tn.pi.entities.Ads;
import tn.pi.entities.Product;
import tn.pi.services.ProductService;
import tn.pi.services.ProductServiceImpl;

@RestController
public class ProductRestController {
	 @Autowired
	 ProductService ProductService;
	 
	
	
	 ObjectMapper objectMapper = new ObjectMapper();
	
		/* 
		// http://localhost:8081/SpringMVC/servlet/addproduct/
		@PostMapping("/addproduct")
		@ResponseBody
		
		public Product addProduct(@RequestBody Product prod){
		return ProductService.addProduct(prod);
		}
		
		*/
		
		//creating a get mapping that retrieves all the product detail from the database   
				@GetMapping("/product/get-all-product")
				@ResponseBody
				public List<Product>  getAllProduct() {
					List<Product> product = new ArrayList<>();
					for(Product p : ProductService.getAllProducts()) {
						product.add(p);
					}
					return product;
				}

				/*
				//creating put mapping that updates the product detail  
				 @PutMapping("/product/update-product/{idCategory}")
				 @ResponseBody
					public ResponseEntity<String> updateProduct(
						@RequestBody Product product,@PathVariable ("idCategory") int idCategory ) {
					    ProductService.updateProduct(product,idCategory);
					    return new ResponseEntity<String>("Product updated successfully",HttpStatus.OK);
						
					}
				 */
				//creating put mapping that EXPIREd the product detail  
				 @PutMapping("/product/expiredproduct/{idproduct}")
				 @ResponseBody
					public ResponseEntity<String> ExpiredProduct(
						@RequestBody Product product,@PathVariable ("idproduct") int idproduct ) {
					    ProductService.ExpiredProduct(idproduct);
					    return new ResponseEntity<String>("Product check",HttpStatus.OK);
						
					}
				 //creating a delete mapping that delete data from database
					@DeleteMapping("/product/delete-product/{idProduct}")
					@ResponseBody
					public ResponseEntity<String>  deleteProduct(
						@RequestBody Product product,@PathVariable("idProduct")int idProduct) {
						ProductService.deleteProduct(idProduct);
					    return new ResponseEntity<String>("Category deleted successfully",HttpStatus.ACCEPTED);
						
					}
					
					//creating a get mapping that retrieves a specific product
					@GetMapping("/product/get-productbyId/{idp}")
					@ResponseBody
					public Product getProductById(@PathVariable("idp")int idp) {
						
						return ProductService.getProductById(idp);
					}
					
					//creating get mapping that getProductByName   
			        @GetMapping("/product/retrieve-Product-ByName/{name}")
					public Product findProductByName(@PathVariable String name) {
						Product product= ProductService.findProductByName(name);
						return product;
						}
			        
			        
			      //creating get mapping that getProductByName   
			        @GetMapping("/product/retrieve-Product-ByCategoryName/{name}")
					public  List<Product> findProductByCategoryName(@PathVariable String name) {
			        	 List<Product> product= ProductService.filterProductByCategory(name);
						return product;
						}
			     
					
					 //creating a get mapping that retrieves a specific product by idcategory
					@GetMapping("/product/get-productbyCategoryid/{categoryid}")
					@ResponseBody
					public List<Product> findProductByCategoryId(@PathVariable("categoryid")int id) {
						
						return (List<Product>) ProductService.findProductByCategoryId(id);
					}
					
					//Verify 
					@GetMapping("/product/get-productbyBarCode/{barCode}")
					@ResponseBody
					public ResponseEntity<String> verifyProductByBarCode(@PathVariable("barCode")String barrecode) {
						if(ProductService.verifyProduct(barrecode)== true) 
						    return new ResponseEntity<String>("Product valid",HttpStatus.ACCEPTED);
						else 
							return new ResponseEntity<String>("Product invalid",HttpStatus.NOT_ACCEPTABLE);
					}
					
					//Search product 
			        @GetMapping("/product/searchProducts/{prod}/{cat}")
					@ResponseBody
					public List<Product>searchProducts(@PathVariable("prod")String prod,@PathVariable("cat")String cat) {
			        	List<Product>products = ProductService.searchProducts(prod, cat);
			        	return products;
			        }
					
			        
			      //creating 
					@GetMapping("/product/getexpiredprod")
					@ResponseBody
					public Product getExpiredprod() {
						
						return ProductService.getepuisé();
					}	
					
					
					//creating 
					@PostMapping("/product/sendmail")
					@ResponseBody
					public Product sendmail() {
						
						return ProductService.sendmail();
					}	
					
}
