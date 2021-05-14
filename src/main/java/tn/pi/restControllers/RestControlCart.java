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
import tn.pi.services.ICartService;




@RestController
public class RestControlCart {
	@Autowired
	ICartService cartsev;
	
	
	// URL : http://localhost:8081/SpringMVC/servlet/getcartByIduser/{idcart}
    @GetMapping(value = "/getcartById/{idcart}")
    @ResponseBody
    public Cart getCartById(@PathVariable("idcart")int idcart) {
    	return cartsev.getCartById(idcart);
	}
 // http://localhost:8081/SpringMVC/servlet/addOrUpdateCart
	   	@PostMapping("/addOrUpdateCart")
	   	@ResponseBody
	 		public Cart addOrUpdateCart(@RequestBody Cart cart) {
	   		
	   		
	   			return cart;
	   	}    

	    @GetMapping(value = "/getTotalcart/{idc}")
	    public double getTotalcart(@PathVariable("idc")int cartId) {
	    	return cartsev.getTotalcart(cartId);
	    }
	    
	    
	    @GetMapping(value = "/getcartbyuser/{idu}")
	    public List<Cart> getcartByIduser(@PathVariable("idu")int userId) {
	    	return cartsev.getpanierByUser(userId);
	    }
}