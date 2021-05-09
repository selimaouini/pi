package tn.esprit.spring.entities.Rayon;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class Rayon implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Idrayon;
	private String nom_rayon;
	
	
	//@Enumerated(EnumType.STRING)
	private Type_rayon type_rayon;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Idrayon")
	@JsonIgnore
	private List<Produit> produits;

	

	

	

	public Long getIdrayon() {
		return Idrayon;
	}

	public void setIdrayon(Long idrayon) {
		Idrayon = idrayon;
	}

	

	public String getNom_rayon() {
		return nom_rayon;
	}

	public void setNom_rayon(String nom_rayon) {
		this.nom_rayon = nom_rayon;
	}

	public Type_rayon getType_rayon() {
		return type_rayon;
	}

	public void setType_rayon(Type_rayon type_rayon) {
		this.type_rayon = type_rayon;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Rayon(String nom_rayon, Type_rayon type_rayon) {
		super();
		this.nom_rayon = nom_rayon;
		this.type_rayon = type_rayon;
	}

	public Rayon() {
		super();
	}

	
	
	
	
	
	
}
