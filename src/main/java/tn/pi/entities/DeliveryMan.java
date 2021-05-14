package tn.pi.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="T_deliveryMan")
public class DeliveryMan implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	private int id_deliveryMan;
	@Column (name="firstName")
	private String firstName;
	@Column (name="lastName")
	private String lastName;
	@Column (name="work_zone")
	private String workZone;
	@Column (name="premium")
	private float premium;
	@Column (name="availability")
	private boolean availability;
	@Column (name="nbDelivery")
	private int nbDelivery;
	@Column (name="tel")
	private String tel;
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.REMOVE,fetch=FetchType.EAGER, mappedBy="DeliveryMan")
	private List<Delivery> deliveries;
	
	public DeliveryMan() {
		super();
	}
	public DeliveryMan(int id_deliveryMan, String firstName, String lastName, String workZone, float premium,
			boolean availability, int nbDelivery, String tel, List<Delivery> deliveries, tn.pi.entities.User user) {
		super();
		this.id_deliveryMan = id_deliveryMan;
		this.firstName = firstName;
		this.lastName = lastName;
		this.workZone = workZone;
		this.premium = premium;
		this.availability = availability;
		this.nbDelivery = nbDelivery;
		this.tel = tel;
		this.deliveries = deliveries;
		
	}
	public int getId_deliveryMan() {
		return id_deliveryMan;
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
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	public int getNbDelivery() {
		return nbDelivery;
	}
	public void setNbDelivery(int nbDelivery) {
		this.nbDelivery = nbDelivery;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public List<Delivery> getDeliveries() {
		return deliveries;
	}
	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}
	
	
	public DeliveryMan(int id_deliveryMan, String firstName, String lastName, String workZone, String tel) {
		super();
		this.id_deliveryMan = id_deliveryMan;
		this.firstName = firstName;
		this.lastName = lastName;
		this.workZone = workZone;
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "DeliveryMan [id_deliveryMan=" + id_deliveryMan + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", workZone=" + workZone + ", premium=" + premium + ", availability=" + availability + ", nbDelivery="
				+ nbDelivery + ", tel=" + tel + ", deliveries=" + deliveries + "]";
	}
	
	
	

			}