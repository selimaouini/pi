package tn.pi.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity

public class Demandechange implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idds;
	@Temporal(TemporalType.DATE)
	private Date DateCreation;
	private float Quantity;
	@Enumerated(EnumType.STRING)
	private  Etatdemande etatdemande;
	private String nomp;
	
	
	
	
	
	
	@ManyToOne
	private Product Product;
	

	

	public int getIdds() {
		return idds;
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
	
	
	public Product getProduct() {
		return Product;
	}

	public void setProduct(Product product) {
		Product = product;
	}

	public Demandechange(int idstock, Date dateCreation, float quantity, Etatdemande etatdemande, Stock stock) {
		super();
		this.idds= idstock;
		DateCreation = dateCreation;
		Quantity = quantity;
		this.etatdemande = etatdemande;
		
	}
	public Demandechange() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public Demandechange(int idds, Date dateCreation, float quantity, Etatdemande etatdemande, String nomp,
			tn.pi.entities.Stock stock) {
		super();
		this.idds = idds;
		DateCreation = dateCreation;
		Quantity = quantity;
		this.etatdemande = etatdemande;
		this.nomp = nomp;
	
	}
    
	public Demandechange(float quantity) {
		super();
		Quantity = quantity;
	}
	

	public Demandechange(int idds, float quantity) {
		super();
		this.idds = idds;
		Quantity = quantity;
	}

	public String getNomp() {
		return nomp;
	}

	
	public void setNomp(String nomp) {
		this.nomp = nomp;
	}

	public Demandechange(int idds, Date dateCreation, float quantity, Etatdemande etatdemande, String nomp,
			tn.pi.entities.catalog catalog, tn.pi.entities.Stock stock) {
		super();
		this.idds = idds;
		DateCreation = dateCreation;
		Quantity = quantity;
		this.etatdemande = etatdemande;
		this.nomp = nomp;
	
	}

	public Demandechange(int idds, Date dateCreation, float quantity, Etatdemande etatdemande, String nomp,
			tn.pi.entities.Product product) {
		super();
		this.idds = idds;
		DateCreation = dateCreation;
		Quantity = quantity;
		this.etatdemande = etatdemande;
		this.nomp = nomp;
		Product = product;
	}

	@Override
	public String toString() {
		return "Demandechange [idds=" + idds + ", DateCreation=" + DateCreation + ", Quantity=" + Quantity
				+ ", etatdemande=" + etatdemande + ", nomp=" + nomp + ", Product=" + Product + "]";
	}

	
	
	
	

}
