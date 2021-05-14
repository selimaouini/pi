package tn.pi.services;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.pi.entities.Cart;
import tn.pi.entities.Command;
import tn.pi.entities.EtatCart;
import tn.pi.entities.LigneComand;
import tn.pi.entities.ModePayement;
//import tn.pi.entities.Pays;
import tn.pi.entities.User;
import tn.pi.repositories.ICartRepository;
import tn.pi.repositories.ICommandRepository;
import tn.pi.repositories.UserRepository;



@Service
public class CartService implements ICartService {
	@Autowired
	ICartRepository cartrep;
	
	@Override
	public Cart getCartById(int idcart) {
		cartrep.findById(idcart);
		return cartrep.findById(idcart).orElse(null);
	}

	@Override
	public void deleteCartById(int cartId) {
		Cart cart = cartrep.findById(cartId).get();
		cartrep.delete(cart);}

	@Override
	public double getTotalcart(int cartId) {
		Cart cart = cartrep.findById(cartId).get();
		
		  double total=cartrep.gettotalcart(cartId);
		    cart.setSubtotal(total);    
			
			cartrep.save(cart);
			return total;
	}



	@Override
	public Cart viderpanier(int cartId) {
		Cart cart = cartrep.findById(cartId).get();
		cart.setEtatcart(EtatCart.canceled);
		cart.setNb(0);
		cart.setSubtotal(0);
		cartrep.save(cart);
		return cartrep.save(cart);
		
		
	}
	
	
	@Override
	public List<Cart> getpanierByUser(int userid) {
		
		return cartrep.getpanierByUser(userid);
	}
	

	


}


