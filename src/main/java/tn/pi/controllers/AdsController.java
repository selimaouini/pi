package tn.pi.controllers;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.pi.entities.Ads;
import tn.pi.entities.AdsView;
import tn.pi.entities.Category;
import tn.pi.entities.Product;
import tn.pi.repositories.AdsRepository;
import tn.pi.repositories.AdsViewRepository;
import tn.pi.services.AdsService;
import tn.pi.services.AdsViewService;

@Controller(value = "AdsController")
@ELBeanName(value = "AdsController")
//@Join(path = "/", to = "/Ads.jsf")
public class AdsController {
	@Autowired
	AdsService AdsService;
	@Autowired
	AdsViewService adsviewservice;
	@Autowired
	AdsRepository adsrepository;
	@Autowired
	AdsViewRepository adsviewrepository;
	@Temporal(TemporalType.DATE)
	private int idAdsView;
	private int idAds;
	private Date DateCreation;
	private String MediaType;
	private String Madia;
	private int nbsignal;
	private double NbVuesMale;
	private double NbVuesfemale;
	private double NbVues;
	@Temporal(TemporalType.DATE)
	private Date beginDate;
	@Temporal(TemporalType.DATE)
	private Date finishDate;
	private String Target;
	private double TargetView_tot;
	public String file ;
	private Product product ;
	private List<Ads> ads;
	private List<AdsView> adsview;
	
	
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
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
	public List<Ads> getAds() {
		ads = AdsService.GetAllAds();
		return ads;
	}
	public void setAds(List<Ads> ads) {
		this.ads = ads;
	}
	
	int id = 40;
	public double getNbVuesMale() {
		NbVuesMale = adsviewservice.NbVuesMale(id);
		return NbVuesMale;
	}
	public void setNbVuesMale(double nbVuesMale) {
		NbVuesMale = nbVuesMale;
	}
	public double getNbVuesfemale() {
		NbVuesfemale = adsviewservice.NbVuesFemale(id);
		return NbVuesfemale;
	}
	public void setNbVuesfemale(double nbVuesfemale) {
		NbVuesfemale = nbVuesfemale;
	}
	public double getNbVues() {
		NbVues= adsviewservice.NbVues(id);
		return NbVues;
	}
	public void setNbVues(double nbVues) {
		NbVues = nbVues;
	}
	public List<AdsView> getAdsview() {
		adsview = adsviewservice.getAllAdsView();
		return adsview;
	}
	public void setAdsview(List<AdsView> adsview) {
		this.adsview = adsview;
	}
	public int getIdAdsView() {
		return idAdsView;
	}
	public void setIdAdsView(int idAdsView) {
		this.idAdsView = idAdsView;
	}
	public int getIdAds() {
		return idAds;
	}
	public void setIdAds(int idAds) {
		this.idAds = idAds;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	int idProduct=14;
	public Ads AddAd(){
		    
		Ads add = new Ads();
		add.setMadia(Madia);
		add.setMediaType(MediaType);
		add.setBeginDate(beginDate);
		add.setFinishDate(finishDate);
		add.setTarget(Target);
		add.setFile(file);
		AdsService.AddAd( add, idProduct);
		return add;
	}
	public int deleteAdd(int idAds){
		
		return AdsService.deleteAdd(idAds);
		}
	
public int SignalAdd(int idAds){
		
		return AdsService.SignalAdd(idAds);
		}

public void displayAds(Ads Ads)
{
this.setDateCreation(Ads.getDateCreation());
this.setFinishDate(Ads.getFinishDate());
this.setMediaType(Ads.getMediaType());
this.setMadia(Ads.getMadia());
this.setNbsignal(Ads.getNbsignal());
this.setTarget(Ads.getTarget());
this.setTargetView_tot(Ads.getTargetView_tot());

}
public void upload(String file) {
    if (file != null) {
        FacesMessage message = new FacesMessage("Successful", file.getBytes() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}

public List<Ads> Productmostviewed(){
	
	return AdsService.Productmostviewed();
	}

public double NbVues(int idAds){
	
	return adsviewservice.NbVues(idAds);
	}
public double NbVuesMale(int idAds){
	
	return adsviewservice.NbVuesMale(idAds);
	}
public double NbVuesFemale(int idAds){
	
	return adsviewservice.NbVuesFemale(idAds);
	}
}
