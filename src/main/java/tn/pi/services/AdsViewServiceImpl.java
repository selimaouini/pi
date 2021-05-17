package tn.pi.services;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.pi.entities.Ads;
import tn.pi.entities.AdsView;
import tn.pi.entities.Category;
import tn.pi.entities.User;
//import tn.pi.entities.User;
import tn.pi.repositories.AdsRepository;
import tn.pi.repositories.AdsViewRepository;
import tn.pi.repositories.ProductRepository;
//import tn.pi.repositories.UserRepository;
import tn.pi.repositories.UserRepository;

@Service
public class AdsViewServiceImpl implements AdsViewService {

	@Autowired
	AdsViewRepository adsviewrepository;
	@Autowired
	AdsViewService AdsViewService;
	
	@Autowired
	ProductRepository productrepository;
	
	@Autowired
	UserRepository userrepository;
	
	@Autowired
	AdsRepository adsrepository;

	@Override
	public int AddAdsView(int idadd) {
		AdsView adsview = new AdsView();
		int iduser=1;
		User u = userrepository.findById(iduser).get();
		Ads a = adsrepository.findById(idadd).get();
		adsview.setAds(a);
		adsview.setUser(u);
		adsviewrepository.save(adsview);
		a.setNbVues(AdsViewService.NbVues(adsview.getAds().getIdAds()));
	    a.setNbVuesMale(AdsViewService.NbVuesMale(adsview.getAds().getIdAds()));
		a.setNbVuesfemale(AdsViewService.NbVuesFemale(adsview.getAds().getIdAds()));
		adsrepository.save(a);
		return adsview.getIdAdsView();
	}

	@Override
	public List<AdsView> getAllAdsView() {
		// TODO Auto-generated method stub
		return (List<AdsView>)adsviewrepository.findAll();
	}

	@Override
	@Scheduled(cron="0 0 * * * ?")
	public List<AdsView> AdsViewToday() {
		return (List<AdsView>) adsviewrepository.findAll();		
	}

	@Override
	public double NbVues(int IdAdd ) {
		
			Ads ads =adsrepository.findById(IdAdd).get();
			ads.setNbVues(0);
			double x = adsviewrepository.count(ads);
			ads.setTargetView_tot(x);
			adsrepository.save(ads);
			return adsviewrepository.count(ads);
			
		}
	
	@Override
	public double NbVuesMale(int IdAdd ) {
		
			Ads ads =adsrepository.findById(IdAdd).get();
			ads.setNbVuesMale(0);
			adsviewrepository.countGM(ads);
			return adsviewrepository.countGM(ads);
		}
	
	@Override
	public double NbVuesFemale(int IdAdd ) {
		
			Ads ads =adsrepository.findById(IdAdd).get();
			ads.setNbVuesfemale(0);
			adsviewrepository.countGF(ads);
			return adsviewrepository.countGF(ads);
		}
	
	/*@Override
	public void Addview(int AdId, int userId) {
		// TODO Auto-generated method stub
		Ads ad=adsrepository.findById(AdId).orElse(null);
		if(ad!=null){
			AdsView adview=adsviewrepository.getAdsViewByAds(ad);
			adview.setTotal_Num(adview.getTotal_Num()+1);
			if(adview!=null){	
				User user=userrepository.findById(userId).orElse(null);
				List<Integer> ageList=adview.getAge();
				ageList.add(user.getAge());;
				adview.setAge(ageList);
				if(user.getGendre()=="homme"){		
					adview.setTotal_man(adview.getTotal_man()+1);
					}
				else{
					adview.setTotal_man(adview.getTotal_Woman()+1);
					}
				}
			adsviewrepository.save(adview);
			}
		}
		*/
	
/*	@Scheduled(cron="0 0 * * * ?")
	@Override
	public ArrayList finalStats() {	
		ArrayList eval=new ArrayList();
		List<Ads> ads=(List<Ads>) adsrepository.findAll();
		for(Ads ad : ads){
		System.out.println(eval);
		if(ad.getFinishDate().toString().matches(LocalDate.now().toString())){
		System.out.println("yes");
		AdsView adview=(AdsView) adsviewrepository.getAdsViewByAds(ad);
		if((ad!=null)&&(adview !=null)){
			
			int tar=ad.getTargetView_tot();
			float real= adview.getTotal_Num();
			List<Integer> ages=adview.getAge();
			double avg=ages.stream().mapToInt(val -> val).average().orElse(0.0);
			
			eval.add(tar);
			eval.add(real);
			eval.add(avg);
			float per=(real%tar);
			eval.add(per);
			if(per>=80){
				eval.add("Successful Ad");
			} else {
				eval.add("The ad has failed");
			}
		}
		}
		};
		return eval;
	}
*/
	@Override
	public void AffectAdsviewtoAds(int AdId,AdsView adsview) {
		Ads ad=adsrepository.findById(AdId).orElse(null);
		adsview.setAds(ad);
		adsviewrepository.save(adsview);		
	}

	@Override
	public void Addview(int AdId, int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList finalStats() {
		// TODO Auto-generated method stub
		return null;
	}
}
