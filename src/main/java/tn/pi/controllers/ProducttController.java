package tn.pi.controllers;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.PrimeFaces;
import org.primefaces.component.export.ExcelOptions;
import org.primefaces.component.export.PDFOptions;
import org.primefaces.component.export.PDFOrientationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import tn.pi.entities.Cart;
import tn.pi.entities.Codepromo;
import tn.pi.entities.Etatdemande;
import tn.pi.entities.LigneComand;
//import tn.esprit.spring.entities.Employe;
import tn.pi.entities.Product;
import tn.pi.entities.State;
import tn.pi.entities.User;
import tn.pi.repositories.ILigneCommandeRepository;
import tn.pi.repositories.IProductRepository;
import tn.pi.services.CartService;
import tn.pi.services.ILigneCommandeService;
import tn.pi.services.ProductService;


@Controller(value = "ProducttController")
@ELBeanName(value = "ProducttController")
//@Join(path = "/", to = "/Product.jsf")

public class ProducttController {
@Autowired
ProductService ProductService;
@Autowired 
CartService cs;
@Autowired
ILigneCommandeService ls;
@Autowired
ILigneCommandeRepository lcrep;
@Autowired
IProductRepository PR;
private String productName;
//private String picture;
private String description;

private float price;
private float pricepromotion;
private String barCode;
@Temporal(TemporalType.DATE)
private Date createdAt;
private int mostViewed;
private List<Product> product;
private int idProduct;
private int idlc;
private int qte;
@DateTimeFormat(pattern="dd-MM-yyyy")
@Temporal(TemporalType.DATE)
private Date date;
private Cart cart;
private Product produit;
private User user;
public int codepromo;


public int getCodepromo() {
	return codepromo;
}
public void setCodepromo(int codepromo) {
	this.codepromo = codepromo;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public float getPricepromotion() {
	return pricepromotion;
}
public void setPricepromotion(float pricepromotion) {
	this.pricepromotion = pricepromotion;
}
public String getBarCode() {
	return barCode;
}
public void setBarCode(String barCode) {
	this.barCode = barCode;
}
public Date getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}
public int getMostViewed() {
	return mostViewed;
}
public void setMostViewed(int mostViewed) {
	this.mostViewed = mostViewed;
}

public int getIdProduct() {
	return idProduct;
}
public void setIdProduct(int idProduct) {
	this.idProduct = idProduct;
}
public List<LigneComand> ligneComand;






public int getIdlc() {
	return idlc;
}
public void setIdlc(int idlc) {
	this.idlc = idlc;
}
public int getQte() {
	return qte;
}
public void setQte(int qte) {
	this.qte = qte;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public Cart getCart() {
	return cart;
}
public void setCart(Cart cart) {
	this.cart = cart;
}
public Product getProduit() {
	return produit;
}
public void setProduit(Product produit) {
	this.produit = produit;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public List<LigneComand> getLigneComand() {
	
	
	ligneComand=ls.findLigneCommandByUser(1);
	return ligneComand;
}
public void setLigneComand(List<LigneComand> ligneComand) {
	this.ligneComand = ligneComand;
}
public List<Product> getProduct() {
	product = ProductService.getAllProducts();
	return product;
}
public void setProduct(List<Product> product) {
	product = product;
}


public String ajouterlc(int productId )

	
	
{  
	int cartId=1;
	int quantity=1;
	if (PR.findById(productId).get().getStock().getQuantity()==0)
	
	{
	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message", "Stock Epuisé");

    PrimeFaces.current().dialog().showMessageDynamic(message);
    
	
	
	}
	else 
	{
		ls.affecterProductAlc( productId, cartId, quantity );
		
		}
	String navigateTo = "/pages/admin/produit.jsf";
	return navigateTo ;
	}

public String  validerpromo(int codepromo)

{  
	Codepromo cpro = cs.getcode(codepromo);
	if (cpro.getState()==State.utilisé){
		FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message", "Code deja utilisé");

	PrimeFaces.current().dialog().showMessageDynamic(message1);
	}
	else if  (cs.getcode(codepromo)==null){
		FacesMessage message2 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message", "Code erroné");

	PrimeFaces.current().dialog().showMessageDynamic(message2);
	}
	else  if  (cpro.getState()==State.valide){
		
	int cartId= 1;
    ls.affecterpromo(cartId,codepromo) ;
	String navigateTo = "/pages/admin/panier.jsf";
	
	return navigateTo = "/pages/admin/panier.jsf";}
	return "ok";}

public String  validerpanier()
{  
	int cartId= 1;
    ls.affecterpanier(cartId) ;
	String navigateTo = "/pages/admin/panier.jsf";
	
	return navigateTo = "/pages/admin/panier.jsf";}


public void incrementer(int lcid){

if (lcrep.findById(lcid).get().getProduit().getStock().getQuantity()==0)
	
{
FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message", "Stock Epuisé");

PrimeFaces.current().dialog().showMessageDynamic(message);
}
else
{ ls.incrementer(lcid) ;}}

public void decrementer(int lcid )
{ if (lcrep.findById(lcid).get().getQte()==1)
	ls.delete(lcid) ;
else  ls.decrementer(lcid);}

public void delete(int lcid )
{ ls.delete(lcid) ;}



}