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
import javax.transaction.Transactional;

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
import tn.pi.entities.Demandestock;
import tn.pi.entities.Etatdemande;
import tn.pi.entities.LigneComand;
//import tn.esprit.spring.entities.Employe;
import tn.pi.entities.Product;
import tn.pi.entities.User;
import tn.pi.entities.catalog;
import tn.pi.repositories.ILigneCommandeRepository;
import tn.pi.repositories.IProductRepository;
import tn.pi.services.ILigneCommandeService;
import tn.pi.services.ProductService;
import tn.pi.services.catalogservice;


@Controller(value = "catalogcontroller")
@ELBeanName(value = "catalogcontroller")
//@Join(path = "/", to = "/Product.jsf")

public class catalogcontroller {
@Autowired
ProductService ProductService;
@Autowired
ILigneCommandeService ls;
@Autowired
ILigneCommandeRepository lcrep;
@Autowired 
catalogcontroller cc;
@Autowired
IProductRepository PR;
@Autowired 
catalogservice cs;


private int id;
private String name;
private String pic;
private float price;
private String barCode;
private int  stock;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPic() {
	return pic;
}
public void setPic(String pic) {
	this.pic = pic;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public String getBarCode() {
	return barCode;
}
public void setBarCode(String barCode) {
	this.barCode = barCode;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}

private List<catalog> cat;

public List<catalog> getCat() {
	cat= cs.getcatalogs();
	return cat;
}
public void setCat(List<catalog> cat) {
	this.cat = cat;
}

public catalog proposer(){
	catalog dst = new catalog();
    
	dst.setName(name);
	dst.setBarCode(barCode);
	dst.setPrice(price);
	dst.setStock(stock);
	cs.addProduct(dst);
	return cs.addProduct(dst);
	
}
	public String delete(int id)
	{ 
		cs.deletecatalogById(id);
		return null ;
	}
	public Demandestock demander(int id)
	{  
		cs.DemanderStock(id);
		return cs.DemanderStock(id);
	}

}