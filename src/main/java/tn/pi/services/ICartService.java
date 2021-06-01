package tn.pi.services;

import java.util.Date;
import java.util.List;

import tn.pi.entities.Cart;
import tn.pi.entities.Codepromo;
import tn.pi.entities.Product;




public interface ICartService {

	
	
	public Cart getCartById(int cartId);
	public void deleteCartById(int cartId);
	public double getTotalcart(int cartId);
	public Cart viderpanier(int cartId);
	public List<Cart> getpanierByUser(int userid);
	public Codepromo getcode(int codepromo);
  
	
}
