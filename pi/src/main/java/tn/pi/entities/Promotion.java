package tn.pi.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="Promotion")
public class Promotion implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpromotion;
	@Temporal(TemporalType.DATE)
	private Date Startingdate;
	@Temporal(TemporalType.DATE)
	private Date EndingDate;
	private String libelle;
	private String Description;
	private long percentage;
	@ManyToOne
	private Product product;
	public int getIdpromotion() {
		return idpromotion;
	}
	public void setIdpromotion(int idpromotion) {
		this.idpromotion = idpromotion;
	}
	public Date getStartingdate() {
		return Startingdate;
	}
	public void setStartingdate(Date startingdate) {
		Startingdate = startingdate;
	}
	public Date getEndingDate() {
		return EndingDate;
	}
	public void setEndingDate(Date endingDate) {
		EndingDate = endingDate;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public long getPercentage() {
		return percentage;
	}
	public void setPercentage(long percentage) {
		this.percentage = percentage;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Promotion(int idpromotion, Date startingdate, Date endingDate, String libelle, String description,
			long percentage, Product product) {
		super();
		this.idpromotion = idpromotion;
		Startingdate = startingdate;
		EndingDate = endingDate;
		this.libelle = libelle;
		Description = description;
		this.percentage = percentage;
		this.product = product;
	}
	public Promotion() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Promotion [idpromotion=" + idpromotion + ", Startingdate=" + Startingdate + ", EndingDate=" + EndingDate
				+ ", libelle=" + libelle + ", Description=" + Description + ", percentage=" + percentage + ", product="
				+ product + "]";
	}
	
	

}
