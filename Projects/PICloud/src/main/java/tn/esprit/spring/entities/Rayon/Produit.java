package tn.esprit.spring.entities.Rayon;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties
public class Produit implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomProduit;
	
	private Long barcode;


	/*
	@JsonIgnore
	@OneToMany(mappedBy="Idproduit",cascade=CascadeType.ALL)
	private Set<ImageProduit> Images;
	@OneToMany(mappedBy="produit")
	@JsonIgnore
	private Set<LigneCommande> ligneCommande;  
	@OneToMany(cascade=CascadeType.ALL,mappedBy="idProduit")
	private Set<Stock> Stocks;                      */
	
	@ManyToOne(cascade=CascadeType.ALL)
	Rayon Idrayon;
	


	public Produit() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}



	public Long getBarcode() {
		return barcode;
	}

	public void setBarcode(Long barcode) {
		this.barcode = barcode;
	}

	public Rayon getIdrayon() {
		return Idrayon;
	}

	public void setIdrayon(Rayon idrayon) {
		Idrayon = idrayon;
	}
	


	public Produit(Long id, String nomProduit) {
		super();
		this.id = id;
		this.nomProduit = nomProduit;
	
	}

	public Produit(String nomProduit) {
		super();
		this.nomProduit = nomProduit;
	}


	public Produit(String nomProduit, Long barcode) {
		super();
		this.nomProduit = nomProduit;

		this.barcode = barcode;
	}



	public Boolean BarcodeIsvalid(long barcode){
		long c =10000000000L;
		long b=barcode/c;
		if(b==619){
			return true;
		}
		return false;
	}
	


}
