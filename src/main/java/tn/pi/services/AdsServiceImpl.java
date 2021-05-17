package tn.pi.services;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tn.pi.exception.MyFileNotFoundException;


import antlr.StringUtils;
import tn.pi.entities.Ads;
import tn.pi.entities.AdsView;
import tn.pi.entities.Product;
import tn.pi.repositories.AdsRepository;
import tn.pi.repositories.AdsViewRepository;
import tn.pi.repositories.ProductRepository;

@Service
public class AdsServiceImpl implements AdsService{
	@Autowired
	AdsRepository adsrepository;
	
	
	@Autowired
	ProductRepository productrepository;
	@Autowired
	AdsViewRepository adsviewrepository;

	@Autowired
	AdsService adsservice;

	
	 public void upload(String file) {
	        if (file != null) {
	            FacesMessage message = new FacesMessage("Successful", file.getBytes() + " is uploaded.");
	            FacesContext.getCurrentInstance().addMessage(null, message);
	        }
	    }
	
	public String AddAd(Ads ads,int prodId) {
		// TODO Auto-generated method stub
		Product product = productrepository.findById(prodId).get();
		ads.setDateCreation(new Date());
		ads.setProduct(product);
		product.setAds(ads);
		adsrepository.save(ads);
		productrepository.save(product);
		return "the add is added and the product is assigned successfully";
	}
	
	
	@Override
	public int deleteAdd(int idAdd) {
		Ads add = adsrepository.findById(idAdd).get();
		adsrepository.delete(add);
		return idAdd;
	}
	//SIGNAL ADD
	@Override
	public int SignalAdd(int idAdd) {
		Ads add = adsrepository.findById(idAdd).get();
		add.setNbsignal(add.getNbsignal()+1);
		adsrepository.save(add);
		if(add.getNbsignal()>=4)
		{
			adsservice.deleteAdd(add.getIdAds());
		}
		
		return idAdd;
	}
	
	
	@Override
	public List<Ads> GetAllAds() {
		// TODO Auto-generated method stub
		return (List<Ads>) adsrepository.findAll();
		
		
	}

	

	@Override
	public List<AdsView> previousStats(int prodId) {
		List list=new ArrayList();
		Product prod=productrepository.findById(prodId).orElse(null);
		List<Ads> ads=adsrepository.getAdsByproduct(prod);
		
		for(Ads ad : ads){
			adsviewrepository.getAdsViewByAds(ad);
			list.add(adsviewrepository.getAdsViewByAds(ad));
		}

		return list;
			
	}

	@Override
	public String ModTargetView_tot(int AdsId, int vCount) {
		Ads ad=adsrepository.findById(AdsId).orElse(null);
		ad.setTargetView_tot(vCount);
		adsrepository.save(ad);
		return "Success";
		
	}

	@Override
	public List<Ads> Productmostviewed() {
		return adsrepository.selectAll();
	}

	
	@Override
	public void AddAd(Ads ads) {
		// TODO Auto-generated method stub
		
	}


	 

	
	
		
		

}
