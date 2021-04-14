package tn.pi.controllers;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;



import tn.pi.entities.Product;
import tn.pi.services.ProductService;
import tn.pi.services.ProductServiceImpl;

@RestController
public class ProductRestController {
	 @Autowired
	 ProductService ProductService;
	 
	 ObjectMapper objectMapper = new ObjectMapper();
		// http://localhost:8081/SpringMVC/servlet/addproduct
		@PostMapping("/addproduct")
		@ResponseBody
		public int addProduct(@RequestBody Product product) {
		
		return ProductService.addProduct(product);
		}

}
