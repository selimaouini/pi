package tn.pi.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import tn.pi.entities.Bill;
import tn.pi.entities.Command;
import tn.pi.entities.Product;
import tn.pi.entities.Stock;
import tn.pi.entities.TypeFacture;
import tn.pi.entities.User;
import tn.pi.services.IBillService;
import tn.pi.services.ICommandeService;
import tn.pi.services.IStockService;




@Controller(value = "StockController")
@ELBeanName(value = "StockController")
//@Join(path = "/", to = "/login.jsf")
public class StockController {
	
	@Autowired
	IStockService ss;
	
	private List<Stock> stock;
	private int idstock;
	@Temporal(TemporalType.DATE)
	private Date DateCreation;
	private float Quantity;
    private List<Command> commande;
	private Product products;
	private String nomp;
	
	public String getNomp() {
		return nomp;
	}
	public void setNomp(String nomp) {
		this.nomp = nomp;
	}
	public List<Stock> getStock() {
	stock = ss.getStock();
		return stock;
	}
	public void setStock(List<Stock> stock) {
		this.stock = stock;
	}
	public int getIdstock() {
		return idstock;
	}
	public void setIdstock(int idstock) {
		this.idstock = idstock;
	}
	public Date getDateCreation() {
		return DateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		DateCreation = dateCreation;
	}
	public float getQuantity() {
		return Quantity;
	}
	public void setQuantity(float quantity) {
		Quantity = quantity;
	}
	public List<Command> getCommande() {
		return commande;
	}
	public void setCommande(List<Command> commande) {
		this.commande = commande;
	}
	public Product getProducts() {
		return products;
	}
	public void setProducts(Product products) {
		this.products = products;
	}
	
	public String redirect() {
		String navigateTo = "/pages/admin/epuisé.jsf";
		
		return navigateTo = "/pages/admin/epuisé.jsf";
		 }
	
	
	public String redirect2() {
		String navigateTo = "/pages/admin/demandesdestock.jsf";
		
		return navigateTo = "/pages/admin/demandesdestock_admin.jsf";
		 }
	 public void submit() {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correct", "Correct");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	
}