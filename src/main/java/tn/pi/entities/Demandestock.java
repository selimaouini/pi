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

public class Demandestock implements Serializable{
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
	private catalog catalog;
	
	
	
	@ManyToOne
	private Stock Stock;
	

	public catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(catalog catalog) {
		this.catalog = catalog;
	}

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
	public Stock getStock() {
		return Stock;
	}
	public void setStock(Stock stock) {
		Stock = stock;
	}
	
	public Etatdemande getEtatdemande() {
		return etatdemande;
	}
	public void setEtatdemande(Etatdemande etatdemande) {
		this.etatdemande = etatdemande;
	}
	public Demandestock(int idstock, Date dateCreation, float quantity, Etatdemande etatdemande, Stock stock) {
		super();
		this.idds= idstock;
		DateCreation = dateCreation;
		Quantity = quantity;
		this.etatdemande = etatdemande;
		Stock = stock;
	}
	public Demandestock() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public Demandestock(int idds, Date dateCreation, float quantity, Etatdemande etatdemande, String nomp,
			tn.pi.entities.Stock stock) {
		super();
		this.idds = idds;
		DateCreation = dateCreation;
		Quantity = quantity;
		this.etatdemande = etatdemande;
		this.nomp = nomp;
		Stock = stock;
	}
    
	public Demandestock(float quantity) {
		super();
		Quantity = quantity;
	}
	

	public Demandestock(int idds, float quantity) {
		super();
		this.idds = idds;
		Quantity = quantity;
	}

	public String getNomp() {
		return nomp;
	}

	public Demandestock(int idds, tn.pi.entities.Stock stock) {
		super();
		this.idds = idds;
		Stock = stock;
	}

	public void setNomp(String nomp) {
		this.nomp = nomp;
	}

	public Demandestock(int idds, Date dateCreation, float quantity, Etatdemande etatdemande, String nomp,
			tn.pi.entities.catalog catalog, tn.pi.entities.Stock stock) {
		super();
		this.idds = idds;
		DateCreation = dateCreation;
		Quantity = quantity;
		this.etatdemande = etatdemande;
		this.nomp = nomp;
		this.catalog = catalog;
		Stock = stock;
	}

	@Override
	public String toString() {
		return "Demandestock [idds=" + idds + ", DateCreation=" + DateCreation + ", Quantity=" + Quantity
				+ ", etatdemande=" + etatdemande + ", nomp=" + nomp + ", catalog=" + catalog + ", Stock=" + Stock + "]";
	}

	
	
	
	

}
