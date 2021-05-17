package tn.pi.controllers;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import tn.pi.entities.Claim;
import tn.pi.entities.Command;
import tn.pi.entities.Delivery;
import tn.pi.entities.DeliveryMan;
import tn.pi.entities.DeliveryState;
import tn.pi.repositories.*;
import tn.pi.services.deliveryServices;
@Controller(value = "DeliveryController")
@ELBeanName(value = "DeliveryController")
public class DeliveryController {

	
	
	@Autowired
	deliveryServices deliveryServices;
	
	@Autowired
	ICommandRepository commandRepository;
	
	
	private List<Delivery> delivery;
	private int id_delivery;
	private float Shippingcost;
	private String address;
	private Date date_affectation;
	private Date date_delivery;
	private String city;
	@Enumerated(EnumType.STRING)
	private DeliveryState state;
	private Claim claim;
	DeliveryMan DeliveryMan;
	public deliveryServices getDeliveryServices() {
		return deliveryServices;
	}
	public void setDeliveryServices(deliveryServices deliveryServices) {
		this.deliveryServices = deliveryServices;
	}
	public List<Delivery> getDelivery() {
		delivery=deliveryServices.retrieveAlldeliveries();
		return delivery;
	}
	public void setDelivery(List<Delivery> delivery) {
		this.delivery = delivery;
	}
	public int getId_delivery() {
		return id_delivery;
	}
	public void setId_delivery(int id_delivery) {
		this.id_delivery = id_delivery;
	}
	public float getShippingcost() {
		return Shippingcost;
	}
	public void setShippingcost(float shippingcost) {
		Shippingcost = shippingcost;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDate_affectation() {
		return date_affectation;
	}
	public void setDate_affectation(Date date_affectation) {
		this.date_affectation = date_affectation;
	}
	public Date getDate_delivery() {
		return date_delivery;
	}
	public void setDate_delivery(Date date_delivery) {
		this.date_delivery = date_delivery;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public DeliveryState getState() {
		return state;
	}
	public void setState(DeliveryState state) {
		this.state = state;
	}
	public Claim getClaim() {
		return claim;
	}
	public void setClaim(Claim claim) {
		this.claim = claim;
	}
	public DeliveryMan getDeliveryMan() {
		return DeliveryMan;
	}
	public void setDeliveryMan(DeliveryMan deliveryMan) {
		DeliveryMan = deliveryMan;
	}
	
	public void deleteDelivery(int id){
		deliveryServices.deleteDelivery( id);
		addMessage(FacesMessage.SEVERITY_INFO, "Success", "Delivery deleted");
	}
		public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
		     FacesContext.getCurrentInstance().
		             addMessage(null, new FacesMessage(severity, summary, detail));
		}
	
	public void updateStateDeliveryToAffected(int id_delivery){
	    deliveryServices.updateStateDeliveryToAffected(id_delivery);
	
	}
	public Delivery addNewDeliveryByCommand(int idCommand){
		Command dm =commandRepository.findById(idCommand).get();
		Delivery deliv =new Delivery();
		deliv.setCommande(dm);
		deliv.setCity(city);
		deliv.setAddress(address);
		return deliv;
		
		
	}
	
	
}
