package tn.pi.restControllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.pi.entities.Cart;
import tn.pi.entities.Command;
import tn.pi.entities.Etat;
import tn.pi.entities.LigneComand;
import tn.pi.entities.Product;
import tn.pi.services.ILigneCommandeService;

@RestController
public class RestControlLigneCommand {
	@Autowired
	ILigneCommandeService lcserv;

	//ajouter produit au panier
	@PutMapping(value = "/addproducttocart/product/{idproduit}/cart/{idcart}/qte/{qte}") 
	public String   affecterProductAlc(@PathVariable("idproduit")int productId,@PathVariable("idcart")int cartId ,@PathVariable("qte")int quantity) {
		return lcserv.affecterProductAlc(productId, cartId, quantity);
	}


		@GetMapping(value = "/getbyid/{idusr}") 
		public List<LigneComand> findLigneCommandByUser(@PathVariable("idusr") int id) {
			return lcserv.findLigneCommandByUser(id);
		}
		//http://localhost:8081/SpringMVC/servlet/getbyid/{idlc}
		@GetMapping(value = "/getbyidlc/{idlc}") 
		public LigneComand getbyid(@PathVariable("idlc") int lcid) {
			return lcserv.getbyid(lcid);
		}
		//http://localhost:8081/SpringMVC/servlet/getall
		@GetMapping(value = "/getall") 	

		public List<LigneComand> getall() {
			return lcserv.getall();
		}
		
		
	}
	
