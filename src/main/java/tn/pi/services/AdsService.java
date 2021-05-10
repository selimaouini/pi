package tn.pi.services;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import tn.pi.entities.Ads;
import tn.pi.entities.AdsView;

@Service
public interface AdsService {

    void AddAd(Ads ads);
	
	List<Ads> GetAllAds();
	
	List<AdsView> previousStats(int prodId);
	String ModTargetView_tot(int AdsId,int vCount);
    String AddAd(Ads ads, int prodId);
	int deleteAdd(int idAdd);
	int SignalAdd(int idAdd);
	List<Ads> Productmostviewed();

	

	
}
