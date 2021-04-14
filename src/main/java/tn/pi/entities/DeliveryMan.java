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
import javax.persistence.Table;



@Entity
@Table(name="T_deliveryMan")
public class DeliveryMan implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	private long id_deliveryMan;
	
	@Column (name="name")
	private String name;
	@Column (name="workZone")
	private String workZone;
	@Column (name="premium")
	private float premium;
	@Column (name="availibility")
	private boolean availibility;
	@Column (name="nbDelivery")
	private int nbDelivery;
	
	@OneToMany(cascade = CascadeType.REMOVE,fetch=FetchType.EAGER, mappedBy="DeliveryMan")
	private List<Delivery> dep;
	
	public DeliveryMan() {
		super();
	}

	public DeliveryMan(long id_deliveryMan, String name, String workZone, float premium, boolean availibility,
			int nbDelivery) {
		super();
		this.id_deliveryMan = id_deliveryMan;
		this.name = name;
		this.workZone = workZone;
		this.premium = premium;
		this.availibility = availibility;
		this.nbDelivery = nbDelivery;
		
		
	}

	public long getId_deliveryMan() {
		return id_deliveryMan;
	}

	public void setId_deliveryMan(long id_deliveryMan) {
		this.id_deliveryMan = id_deliveryMan;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public boolean isAvailibility() {
		return availibility;
	}

	public void setAvailibility(boolean availibility) {
		this.availibility = availibility;
	}

	public int getNbDelivery() {
		return nbDelivery;
	}

	public void setNbDelivery(int nbDelivery) {
		this.nbDelivery = nbDelivery;
	}

	@Override
	public String toString() {
		return "DeliveryMan [id_deliveryMan=" + id_deliveryMan + ", name=" + name + ", workZone=" + workZone
				+ ", premium=" + premium + ", availibility=" + availibility + ", nbDelivery=" + nbDelivery + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
