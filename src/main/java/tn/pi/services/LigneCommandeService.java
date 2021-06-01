package tn.pi.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import tn.pi.entities.Cart;
import tn.pi.entities.Codepromo;
import tn.pi.entities.Command;
import tn.pi.entities.Etat;
import tn.pi.entities.EtatCart;
import tn.pi.entities.LigneComand;
import tn.pi.entities.Product;
import tn.pi.entities.State;
import tn.pi.entities.Stock;
import tn.pi.entities.User;
import tn.pi.repositories.ICartRepository;
import tn.pi.repositories.ILigneCommandeRepository;
import tn.pi.repositories.IProductRepository;
import tn.pi.repositories.IStockRepository;
import tn.pi.repositories.UserRepository;
import tn.pi.repositories.codepromorep;
@Service
public  class LigneCommandeService implements ILigneCommandeService {

	
	@Autowired
	ILigneCommandeRepository lcrep;
	@Autowired
	ICartRepository cartrep;
	@Autowired
	IProductRepository produitrep;
	@Autowired
	IStockRepository storep;
	@Autowired 
	UserRepository userep;
	@Autowired
	IStockRepository sr;
	@Autowired
	codepromorep crp;
	@Autowired CartService cs;
	private Map<Integer,LigneComand>lcs=new HashMap<Integer,LigneComand>();
	
	@Transactional
	@Override
	public String affecterProductAlc(int productId,int cartId,int quantity ) {
		
		LigneComand lc = new LigneComand();
		User user = userep.findById(1).get();
		Product pro = produitrep.findById(productId).get();
		Cart cart =cartrep.findById(cartId).get();
		Stock s =storep.findByproducts(pro);
	    if(quantity<=pro.getStock().getQuantity()) {
			//double tot1=lcrep.sum(cart);
		if (!ObjectUtils.isEmpty(lc) && !ObjectUtils.isEmpty(pro)) {
		lc.setUser(user);
		lc.setProduit(pro);
		lc.setPrice(pro.getSellPrice());
		lc.setQte(quantity);
		lc.setCart(cart);
		lc.setDate(new Date());
		lc.getProduit().getStock().setQuantity(lc.getProduit().getStock().getQuantity()-quantity);


		lcrep.save(lc);
	//	cartrep.save(cart);
		
	//	lcrep.deleteById(lc.getIdlc());
		return "Ligne de commande ajouté et affecté au panier";
		
		}}
		return "Stock insuffisant";
	
}
	@Transactional
	@Override
	public String affecterpanier(int cartid ) {
		
		
		Cart cart=cartrep.findById(cartid).get();
		double tot1=lcrep.sum(cart);
		cart.setSubtotal(tot1);
	    cart.setEtatcart(EtatCart.abandonedbasket);
	    cart.setNb(this.count(cartid));
	   
	
	    
	    

		
	    cartrep.save(cart);
		
	 //   lcrep.deleteById();
		return "Ligne de commande ajouté et affecté au panier";
		
	
}
	@Transactional
	@Override
	public String affecterpromo(int cartid,int codepromo ) {
		Codepromo cp = crp.getcode(codepromo);
		if ( cp!=null)
		{
		
		Cart cart=cartrep.findById(cartid).get();
		double tot1=lcrep.sum(cart);
		cart.setSubtotal(tot1-cp.getPromotion());
	    cart.setEtatcart(EtatCart.abandonedbasket);
	    cart.setNb(this.count(cartid));
	   
	    
	    cp.setState(State.utilisé);
	    

		
	    cartrep.save(cart);
	    crp.save(cp);
		}
	 //   lcrep.deleteById();
		return "Ligne de commande ajouté et affecté au panier";
		
	
}
	
	@Transactional
	@Override 
	public LigneComand incrementer(int lcid)
	
	{  LigneComand lc=lcrep.findById(lcid).get();
		float x = lc.getProduit().getStock().getQuantity();
		Stock s = lc.getProduit().getStock();
		if (s.getQuantity()>0){
		lc.setQte(lc.getQte()+1);
		
		s.setQuantity(x-1);
		lcrep.save(lc);	
		sr.save(s); }
		
		return null;}
	@Transactional
	@Override 
	public LigneComand decrementer(int lcid)
	
	{
		
		LigneComand lc=lcrep.findById(lcid).get();
		lc.setQte(lc.getQte()-1);
		float x = lc.getProduit().getStock().getQuantity();
		Stock s = lc.getProduit().getStock();
		s.setQuantity(x+1);
		lcrep.save(lc);	
		sr.save(s);
		
		return null;}
	@Override 
	public LigneComand delete(int lcid)
	
	{
		
		lcrep.deleteById(lcid);
		
		
		return null;}

	
	
	@Override
	public List<LigneComand> findLigneCommandByUser(int userid) {
		
		return lcrep.getAllLigneCommandByUser(userid);
	}
	
	@Override
	public LigneComand getbyid(int lcid) {
		
		return lcrep.findById(lcid).get();
	}
	@Override
	public ArrayList<LigneComand> getall() {
		
		return (ArrayList<LigneComand>) lcrep.findAll();
	}
	@Override 
	public int count (int cartid) {
	Cart cart = cartrep.findById(cartid).get();
	lcrep.count();
	return (int) lcrep.count(cart);
	
	}
	

	

}
