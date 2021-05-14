package tn.pi.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity

public class Stock implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idstock;
	@Temporal(TemporalType.DATE)
	private Date DateCreation;
	private float Quantity;
	private String nomp;
	public String getNomp() {
		return nomp;
	}
	public void setNomp(String nomp) {
		this.nomp = nomp;
	}
	@ManyToMany
	private List<Command> commande;
	@ManyToOne
	private Product products;
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdstock() {
		return idstock;
	}
	public void setIdstock(int idstock) {
		this.idstock = idstock;
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
	public List<Command> getCommande() {
		return commande;
	}
	public void setCommande(List<Command> commande) {
		this.commande = commande;
	}
	public Product getProducts() {
		return products;
	}
	public void setProducts(Product products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Stock [idstock=" + idstock + ", DateCreation=" + DateCreation + ", Quantity=" + Quantity + ", nomp="
				+ nomp + ", commande=" + commande + ", products=" + products + "]";
	}
	
	
	
	

}
