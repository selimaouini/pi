package tn.pi.services;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.pi.entities.Ads;
import tn.pi.entities.Category;
import tn.pi.entities.Product;
import tn.pi.entities.Promotion;
import tn.pi.entities.Rating;
import tn.pi.repositories.ProductRepository;
import tn.pi.repositories.PromotionRepository;
import tn.pi.repositories.RatingRepository;
@Service
public class PromotionServiceImpl implements PromotionService{
	@Autowired
	PromotionRepository iPromotionRepository;
    @Autowired
    ProductRepository iProductRepository;
    @Autowired
	RatingRepository var3;
    
    /******************Creating add method that insert Promotion into database*************/
    @Override
    public String addPromos(Promotion promotion,int prodId) {
		// TODO Auto-generated method stub
		Product product =iProductRepository.findById(prodId).get();
		product.setPromotionEtat(true);
		promotion.setProduct(product);
		//Promotion promotion = iPromotionRepository.findById(idpromotion).get();
		promotion.getProduct().setPricepromotion(promotion.getProduct().getPrice()-(promotion.getProduct().getPrice()*promotion.getPercentage()/100));
		iProductRepository.save(product);
		iPromotionRepository.save(promotion);
		return "the PROMOTION is added and the product is assigned successfully with a discount ";
	}
   
	
	/******************Creating update method that upgrade promotion from database*************/
    
	@Override
	public void updatePromos(Promotion p, int idProduct) {
		Product product = iProductRepository.findById(idProduct).get();
		p.setProduct(product);
		iPromotionRepository.save(p);
		
		
		
		
	}
	/******************Creating deleting method that remove promotion by id from database*************/

	@Override
	public int deletePromos(int idPromotion) {
		Promotion promos = iPromotionRepository.findById(idPromotion).get();
		iPromotionRepository.delete(promos);
		return idPromotion;
	}
	
	/***************Creating getByid method that retrieve promotions detail from database***********/
	
	@Override
	public Promotion getPromosById(int idPromotion) {
		Promotion prom = iPromotionRepository.findById(idPromotion).get();
		return prom;
		
	}
  /*******************creating getAll method that retrieve all promotions  from database*************/
	@Override
	public List<Promotion> getAllPromos() {
		List<Promotion>promotions = new ArrayList<>();
		iPromotionRepository.findAll().forEach(p -> promotions.add(p));
		return promotions;
	}
	/***************Creating getByDate method that retrieve promotions detail from database***********/
 /*   @Override
	public List<Promotion> getPromosByDate() {
		List<Promotion> promotions = iPromotionRepository.getCurrentPromotions();
		List<Promotion>currentPromotions = new ArrayList<>();
	    for(Promotion p : promotions){
			
			currentPromotions.add(p);
		}
		return currentPromotions;
	}
	*/
    /********************************Affected ProductPromotion *****************************************/
	@Override
	public void affecterProductPromotion(int idproduct,int idpromotion) {
		Product product = iProductRepository.findById(idproduct).get();
		Promotion promotion = iPromotionRepository.findById(idpromotion).get();
	        promotion.setProduct(product);
	        iPromotionRepository.save(promotion);

	}
	
@Override
	public String discountProductPromotion(int idpromotion ) {
	Promotion promotion = iPromotionRepository.findById(idpromotion).get();
	promotion.getProduct().setPricepromotion(promotion.getProduct().getPrice()-(promotion.getProduct().getPrice()*promotion.getPercentage()/100));
	iProductRepository.save(promotion.getProduct());
	return " promotion Done";
		
	}

	@Override
	public List<Promotion> getPromosByDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void proposePromos(Promotion p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int addPromos(Promotion p) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Rating addEv(Rating e, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
			 	
				
	}
