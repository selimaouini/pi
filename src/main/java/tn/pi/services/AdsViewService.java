package tn.pi.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import tn.pi.entities.AdsView;
//import tn.pi.entities.User;
@Service
public interface AdsViewService {

	int AddAdsView(AdsView adsview);
	List<AdsView> getAllAdsView();
	List<AdsView> AdsViewToday();
	void Addview(int AdId, int userId);
	ArrayList finalStats();
	void AffectAdsviewtoAds(int AdId,AdsView adsview);
	double NbVues(int IdAdd);
	double NbVuesMale(int IdAdd);
	double NbVuesFemale(int IdAdd);
	
}
