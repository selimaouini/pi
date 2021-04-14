package tn.pi.services;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import tn.pi.entities.Ads;
import tn.pi.entities.AdsView;

@Service
public interface AdsService {

	void AddAd(Ads ads);
	void Mod_SDate(int AdsID,Date new_SDate);
	void Mod_FDate(int AdsId,Date new_FDate);
	List<Ads> GetAllAds();
	List<Ads> GetAdsByFDate(Date FDate);
	List<Ads> GetAdsBySDate(Date SDate);
	List<AdsView> previousStats(int prodId);
	String ModTargetView_tot(int AdsId,int vCount);
}
