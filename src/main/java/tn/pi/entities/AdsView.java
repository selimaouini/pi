package tn.pi.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="AdsView")
public class AdsView {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAdsView;
	
	
	@OneToOne
	private Ads ads;
	@ManyToOne
	private User user;
	public int getIdAdsView() {
		return idAdsView;
	}
	public void setIdAdsView(int idAdsView) {
		this.idAdsView = idAdsView;
	}
	public Ads getAds() {
		return ads;
	}
	public void setAds(Ads ads) {
		this.ads = ads;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public AdsView(int idAdsView, Ads ads, User user) {
		super();
		this.idAdsView = idAdsView;
		this.ads = ads;
		this.user = user;
	}
	public AdsView() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AdsView [idAdsView=" + idAdsView + ", ads=" + ads + ", user=" + user + "]";
	}
	
	
}
