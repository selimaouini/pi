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
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import tn.pi.entities.Bill;
import tn.pi.entities.Command;
import tn.pi.entities.Demandestock;
import tn.pi.entities.Etatdemande;
import tn.pi.entities.Product;
import tn.pi.entities.Stock;
import tn.pi.entities.TypeFacture;
import tn.pi.entities.User;
import tn.pi.repositories.IProductRepository;
import tn.pi.repositories.Idemandestockrepository;
import tn.pi.services.IBillService;
import tn.pi.services.ICommandeService;
import tn.pi.services.IStockService;
import tn.pi.services.IdemandestockService;

import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;

@Controller(value = "demandestockcontroller")
@ELBeanName(value = "demandestockcontroller")
//@Join(path = "/", to = "/login.jsf")
public class demandestockcontroller {
	
	@Autowired
	IdemandestockService ds;
	@Autowired Idemandestockrepository dem;
	@Autowired
	IProductRepository pro;
	
	private List<Demandestock> demandestock;
	private int idds;
	@Temporal(TemporalType.DATE)
	private Date DateCreation;
	private float Quantity;
	@Enumerated(EnumType.STRING)
	private  Etatdemande etatdemande;
	private Stock Stock;
	private String nomp;
	
	public List<Demandestock> getDemandestock() {
		demandestock = ds.getdemande();
		return demandestock;
	}
	public void setDemandestock(List<Demandestock> demandestock) {
		this.demandestock = demandestock;
	}
	public int getIdds() {
		return idds;
	}
	
	
	public String getNomp() {
		return nomp;
	}
	public void setNomp(String nomp) {
		this.nomp = nomp;
	}
	public void setIdds(int idds) {
		this.idds = idds;
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
	public Etatdemande getEtatdemande() {
		return etatdemande;
	}
	public void setEtatdemande(Etatdemande etatdemande) {
		this.etatdemande = etatdemande;
	}
	public Stock getStock() {
		return Stock;
	}
	public void setStock(Stock stock) {
		Stock = stock;
	}
	  
	public void removedemande(int demId)
	{
	ds.deletedemande(demId);
	  
	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message", "Demande annulé");

    PrimeFaces.current().dialog().showMessageDynamic(message);
	}
	
	public void validerdemande(int demId)
	{
	
		
	{ds.validerdemande(demId);  
	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message", "Demande validé");

    PrimeFaces.current().dialog().showMessageDynamic(message);
	
	
	}
	

			}
	
	
	
	public void refuser(int demId)
	{
	
		
	{ds.refuserdemande(demId);  
	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message", "Demande Refusé");

    PrimeFaces.current().dialog().showMessageDynamic(message);
	
	
	}
	}
	
	public Demandestock demander(){
		Demandestock dst = new Demandestock();
	
		
	
		dst.setQuantity(Quantity);
		ds.DemanderStock(dst);
		return ds.DemanderStock(dst);
		
	}
		
		
		
	public String redirect() {
		String navigateTo = "/pages/admin/stock.jsf";
		
		return navigateTo = "/pages/admin/stock.jsf";
		 }
	
}