package tn.pi.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import tn.pi.entities.DeliveryMan;
import tn.pi.entities.User;
import tn.pi.repositories.deliveryManRepository;
import tn.pi.services.deliveryManServices;

@Named
@RequestScoped
@Controller(value = "DeliveryManController")
@ELBeanName(value = "DeliveryManController")
public class DeliveryManController {
	
	@Autowired
	deliveryManServices deliveryManServices;
	@Autowired
	deliveryManRepository DeliveryManRepository;

	
	private List<DeliveryMan> deliveryMan;
	private int idToUpdate;
	private int id_deliveryMan;
	private String firstName;
	private String lastName;
	private boolean availability;
	private String tel;
	private String workZone;
	private float premium;
	private int nbDelivery;
	private User User;
	
	
	public deliveryManServices getDeliveryManServices() {
		return deliveryManServices;
	}


	public void setDeliveryManServices(deliveryManServices deliveryManServices) {
		this.deliveryManServices = deliveryManServices;
	}


	public List<DeliveryMan> getDeliveryMan() {
	deliveryMan=deliveryManServices.retrieveAlleDliveryMen();
		return deliveryMan;
	}


	public void setDeliveryMan(List<DeliveryMan> deliveryMan) {
		this.deliveryMan = deliveryMan;
	}


	public long getId_deliveryMan() {
		return id_deliveryMan;
	}


	public int getIdToUpdate() {
		return idToUpdate;
	}


	public void setIdToUpdate(int idToUpdate) {
		this.idToUpdate = idToUpdate;
	}


	public void setId_deliveryMan(int id_deliveryMan) {
		this.id_deliveryMan = id_deliveryMan;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public boolean isAvailability() {
		return availability;
	}


	public void setAvailability(boolean availability) {
		this.availability = availability;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getWorkZone() {
		return workZone;
	}


	public void setWorkZone(String workZone) {
		this.workZone = workZone;
	}


	public float getPremium() {
		return premium;
	}


	public void setPremium(float premium) {
		this.premium = premium;
	}


	public int getNbDelivery() {
		return nbDelivery;
	}


	public void setNbDelivery(int nbDelivery) {
		this.nbDelivery = nbDelivery;
	}




	public User getUser() {
		return User;
	}


	public void setUser(User user) {
		User = user;
	}


	public String addDeliveryMan(){
		DeliveryMan DeliveryMan=new DeliveryMan();
		DeliveryMan.setFirstName(firstName);
		DeliveryMan.setLastName(lastName);
		DeliveryMan.setTel(tel);
		DeliveryMan.setWorkZone(workZone);
		deliveryManServices.addDeliveryMan(DeliveryMan);
		addMessage(FacesMessage.SEVERITY_INFO, "Success", "Delivery Man is added successfuly");
	 	return "/pages/admin/DevMen.xhtml?faces-redirect=true";
	}
	
	public DeliveryMan updateAvailibilityToFalse(int id){
		DeliveryMan deliverymen =deliveryManServices.updateAvailibilityToFalse(id);
		addMessage(FacesMessage.SEVERITY_INFO, "INFO!!", "Delivery Man is no more availibale");
		return deliverymen;
		
	}
	
	public DeliveryMan updateAvailibilityToTrue(int id){
		DeliveryMan deliverymen =deliveryManServices.updateAvailibilityToTrue(id);
		addMessage(FacesMessage.SEVERITY_INFO, " INFO!!", "delivery Man is now availibale");
		return deliverymen;
		
		}
	


public void deleteDeliveryMan(int id){
	deliveryManServices.deleteDeliveryMan(id);
	addMessage(FacesMessage.SEVERITY_INFO, "Success", "Delivery Man deleted");
	
}


   
 public void displaydeliveryMan(DeliveryMan dev){
	this.setFirstName(dev.getFirstName());
	this.setLastName(dev.getLastName());
	this.setTel(dev.getTel());
	this.setWorkZone(dev.getWorkZone());
	this.setIdToUpdate(dev.getId_deliveryMan());
	}
 
 public String selectDeliveryMan(int id){ 
	DeliveryMan dev= DeliveryManRepository.findById(id).get();
	displaydeliveryMan(dev);
 	return "/pages/admin/updateDevMan.xhtml?faces-redirect=true";
 }	
 

 public void updateDeliveryMen(){
    deliveryManServices.addDeliveryMan(new DeliveryMan(idToUpdate,firstName,lastName,workZone,tel));
	addMessage(FacesMessage.SEVERITY_INFO, "Success", "Delivery Man updated successfuly");
	}
 
 public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
     FacesContext.getCurrentInstance().
             addMessage(null, new FacesMessage(severity, summary, detail));
}
}
