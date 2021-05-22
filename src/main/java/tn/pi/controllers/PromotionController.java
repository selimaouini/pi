package tn.pi.controllers;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.pi.entities.Product;
import tn.pi.entities.Promotion;
import tn.pi.entities.Rating;
import tn.pi.services.PromotionService;

@Controller(value = "PromotionController")
@ELBeanName(value = "PromotionController")
@Join(path = "/", to = "/Product.jsf")
public class PromotionController {
	@Autowired
	PromotionService PromotionService;
	
	private String libelle;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	private String desc;
	private float percentage;
	private List<Promotion> promotion;
	private List<Rating> rating;
	private Product product ;
	
	public List<Rating> getRating() {
		return rating;
	}
	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	public List<Promotion> getPromotion() {
		promotion = PromotionService.getAllPromos();
		
		return promotion;
	}
	public void setPromotion(List<Promotion> promotion) {
		this.promotion = promotion;
	}
	public void openNew() {
        this.promotion = (List<Promotion>) new Promotion();
    }
	
	
	
	int idProduct=134;
	public Promotion addPromos(){
		Promotion prom = new Promotion();
		
		prom.setLibelle(libelle);
		prom.setStartDate(startDate);
		prom.setEndDate(endDate);
		prom.setDescription(desc);
		prom.setPercentage(percentage);
		PromotionService.addPromos(prom , idProduct);
		return prom;
	}
	public int deletePromotion(int idPromotion){
		
		return PromotionService.deletePromos(idPromotion);
	}
	public void displayPromotion(Promotion Promotion)
	{
	this.setLibelle(Promotion.getLibelle());
	this.setStartDate(Promotion.getStartDate());
	this.setEndDate(Promotion.getEndDate());
	this.setDesc(Promotion.getDescription());
	this.setPercentage(Promotion.getPercentage());
	
	
	}
	
	
	
}
