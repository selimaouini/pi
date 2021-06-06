package tn.pi.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import tn.pi.entities.Bill;
import tn.pi.entities.BillPDFExporter;
import tn.pi.entities.Command;
import tn.pi.entities.LigneComand;
import tn.pi.entities.User;
import tn.pi.repositories.ICartRepository;
import tn.pi.repositories.ILigneCommandeRepository;
import tn.pi.repositories.UserRepository;
import tn.pi.services.IBillService;
import javax.servlet.http.HttpServletResponse;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.PositiveOrZero;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lowagie.text.DocumentException;

import tn.pi.entities.Bill;
import tn.pi.entities.BillPDFExporter;
import tn.pi.entities.Cart;
import tn.pi.entities.Command;
import tn.pi.entities.EtatCart;
import tn.pi.entities.Etatdemande;
import tn.pi.entities.LigneComand;
//import tn.esprit.spring.entities.Employe;
import tn.pi.entities.Product;
import tn.pi.entities.Stock;
import tn.pi.entities.User;
import tn.pi.services.IBillService;
import tn.pi.services.ICartService;
import tn.pi.services.ICommandeService;
import tn.pi.services.ILigneCommandeService;
import tn.pi.services.IUserService;
import tn.pi.services.ProductService;


@Controller(value = "CartController")
@ELBeanName(value = "CartController")
//@Join(path = "/", to = "/Product.jsf")

public class CartController {
@Autowired
ICartService cs;
@Autowired
ILigneCommandeService ls;
@Autowired
ICartRepository cr;
@Autowired
ICommandeService coms;
@Autowired 
UserRepository usrep;

@Autowired
IBillService bilserv;
@Autowired
ILigneCommandeService lignserv;
@Autowired
IUserService userserv;
@Autowired
CartController cc;
@Autowired 
UserController uc;
private int nb;




public int getNb() {
	return nb;
}
public void setNb(int nb) {
	this.nb = nb;
}



private List<Cart> cart;
private int idcart;
private double subtotal;
private String currency;
@Enumerated(EnumType.STRING)
private EtatCart etatcart;

private User user;
private Command command;
List<Stock>stocks;


public List<Cart> getCart() {
	cart = cs.getpanierByUser(uc.getIdUserC());
	return cart;
}
public void setCart(List<Cart> cart) {
	this.cart = cart;
}
public int getIdcart() {
	return idcart;
}
public void setIdcart(int idcart) {
	this.idcart = idcart;
}
public double getSubtotal() {
	return subtotal;
}
public void setSubtotal(double subtotal) {
	this.subtotal = subtotal;
}
public String getCurrency() {
	return currency;
}
public void setCurrency(String currency) {
	this.currency = currency;
}
public EtatCart getEtatcart() {
	return etatcart;
}
public void setEtatcart(EtatCart etatcart) {
	this.etatcart = etatcart;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Command getCommand() {
	return command;
}
public void setCommand(Command command) {
	this.command = command;
}
public List<Stock> getStocks() {
	return stocks;
}
public void setStocks(List<Stock> stocks) {
	this.stocks = stocks;
}


public String save(int cartId)
{
	
	coms.saveCommande(cartId);


		String navigateTo = "/pages/admin/pay.jsf";
		return navigateTo;
	

}

int idpanier=1;
public Cart annuler() {
	cs.viderpanier(idpanier);
	return cs.viderpanier(idpanier);
}
public void paymentbyfidelite(int cartId)

{
	User u = usrep.findById(uc.getIdUserC()).get();
	Cart c = cr.findById(cartId).get();
	if (u.getPointconverti()<c.getSubtotal()){
	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message", "Solde isuffisant");
	PrimeFaces.current().dialog().showMessageDynamic(message);
	}
	else 
	{
	coms.paymentbyfidelite( cartId);
	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message", "paiement effectué");
	PrimeFaces.current().dialog().showMessageDynamic(message);}   }}


