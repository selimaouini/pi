package tn.pi.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.pi.entities.Cart;

import tn.pi.entities.Product;
import tn.pi.entities.catalog;
import tn.pi.services.ICartService;
import tn.pi.services.catalogservice;




@RestController
public class RestControlcatalog {
	

	@Autowired
	catalogservice cv;
	

 // http://localhost:8081/SpringMVC/servlet/addOrUpdateCart
	   	@PostMapping("/addcatalog")
	   	@ResponseBody
	 		public catalog addProduct(@RequestBody catalog catalog) {
	   		
	   		
	   			return cv.addProduct(catalog); 
	   	}    

}