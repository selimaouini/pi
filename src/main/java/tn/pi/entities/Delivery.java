package tn.pi.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="T_delivery")
public class Delivery implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	private int id_delivery;
	
	
	@Column (name="Shippingcost")
	private float Shippingcost;
	@Column (name="address")
	private String address;
	
	@Column (name="date_affectation")
	private Date date_affectation;
	
	@Column (name="date_delivery")
	private Date date_delivery;
	@Column (name="city")
	private String city;
	@Column (name="state")
	@Enumerated(EnumType.STRING)
	private DeliveryState state;
	
	@JsonIgnore
	@ManyToOne
	DeliveryMan DeliveryMan;
	
	@JsonIgnore
	@ManyToOne
	Command commande;
	


	public Delivery() {
		super();
	}


	public Delivery(int id_delivery, float shippingcost, String address, Date date_affectation, Date date_delivery,
			String city, DeliveryState state, tn.pi.entities.DeliveryMan deliveryMan, Command commande) {
		super();
		this.id_delivery = id_delivery;
		Shippingcost = shippingcost;
		this.address = address;
		this.date_affectation = date_affectation;
		this.date_delivery = date_delivery;
		this.city = city;
		this.state = state;
		DeliveryMan = deliveryMan;
		this.commande = commande;
		
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


	public DeliveryMan getDeliveryMan() {
		return DeliveryMan;
	}


	public void setDeliveryMan(DeliveryMan deliveryMan) {
		DeliveryMan = deliveryMan;
	}


	public Command getCommande() {
		return commande;
	}


	public void setCommande(Command commande) {
		this.commande = commande;
	}




	@Override
	public String toString() {
		return "Delivery [id_delivery=" + id_delivery + ", Shippingcost=" + Shippingcost + ", address=" + address
				+ ", date_affectation=" + date_affectation + ", date_delivery=" + date_delivery + ", city=" + city
				+ ", state=" + state + ", DeliveryMan=" + DeliveryMan + ", commande=" + commande
				+ "]";
	}


	

	

		}