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
@Table(name="Ads")
public class Ads implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAds;
	@Temporal(TemporalType.DATE)
	private Date DateCreation;
	private String MediaType;
	private String Madia;
	private int nbsignal;
	@Temporal(TemporalType.DATE)
	private Date beginDate;
	@Temporal(TemporalType.DATE)
	private Date finishDate;
	private String Target;
	private double TargetView_tot;
	@ManyToOne
	private Product product;
	public int getIdAds() {
		return idAds;
	}
	public Date getDateCreation() {
		return DateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		DateCreation = dateCreation;
	}
	public String getMediaType() {
		return MediaType;
	}
	public void setMediaType(String mediaType) {
		MediaType = mediaType;
	}
	public String getMadia() {
		return Madia;
	}
	public void setMadia(String madia) {
		Madia = madia;
	}
	public int getNbsignal() {
		return nbsignal;
	}
	public void setNbsignal(int nbsignal) {
		this.nbsignal = nbsignal;
	}
	
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	public String getTarget() {
		return Target;
	}
	public void setTarget(String target) {
		Target = target;
	}
	public double getTargetView_tot() {
		return TargetView_tot;
	}
	public void setTargetView_tot(double targetView_tot) {
		TargetView_tot = targetView_tot;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public void setIdAds(int idAds) {
		this.idAds = idAds;
	}
	public Ads(int idAds, Date dateCreation, String mediaType, String madia, int nbsignal, Date beginDate,
			Date finishDate, String target, int targetView_tot, Product product) {
		super();
		this.idAds = idAds;
		DateCreation = dateCreation;
		MediaType = mediaType;
		Madia = madia;
		this.nbsignal = nbsignal;
		this.beginDate = beginDate;
		this.finishDate = finishDate;
		Target = target;
		TargetView_tot = targetView_tot;
		this.product = product;
	}
	public Ads(Date dateCreation, String mediaType, String madia, int nbsignal, Date beginDate,
			Date finishDate, String target, int targetView_tot, Product product) {
		super();
		DateCreation = dateCreation;
		MediaType = mediaType;
		Madia = madia;
		this.nbsignal = nbsignal;
		this.beginDate = beginDate;
		this.finishDate = finishDate;
		Target = target;
		TargetView_tot = targetView_tot;
		this.product = product;
	}
	public Ads() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Ads [idAds=" + idAds + ", DateCreation=" + DateCreation + ", MediaType=" + MediaType + ", Madia="
				+ Madia + ", nbsignal=" + nbsignal + ", beginDate=" + beginDate + ", finishDate=" + finishDate
				+ ", Target=" + Target + ", TargetView_tot=" + TargetView_tot + ", product=" + product + "]";
	}
	
	
	
	
}
