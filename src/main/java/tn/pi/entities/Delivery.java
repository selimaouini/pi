package tn.pi.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="T_delivery")
public class Delivery implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	private long id_delivery;
	
	@Column (name="description")
	private String description;
	@Column (name="Shippingcost")
	private float Shippingcost;
	@Column (name="address")
	private String address;
	@Column (name="city")
	private String city;
	@Column (name="state")
	private String state;
	
	@ManyToOne
	DeliveryMan DeliveryMan;
	
	public Delivery() {
		super();
	}
	
	 Delivery(long id_delivery, String description, float shippingcost, String address, String city,
			String state) {
		super();
		this.id_delivery = id_delivery;
		this.description = description;
		this.Shippingcost = shippingcost;
		this.address = address;
		this.city = city;
		this.state = state;
	}

	public long getId_delivery() {
		return id_delivery;
	}

	public void setId_delivery(long id_delivery) {
		this.id_delivery = id_delivery;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Delivery [id_delivery=" + id_delivery + ", description=" + description + ", Shippingcost="
				+ Shippingcost + ", address=" + address + ", city=" + city + ", state=" + state + "]";
	}
	 

}
	
	
	

