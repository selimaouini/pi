package tn.pi.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.pi.entities.Product;
import tn.pi.entities.Promotion;
import tn.pi.entities.Rating;
import tn.pi.entities.User;
import tn.pi.repositories.ProductRepository;
import tn.pi.repositories.PromotionRepository;
import tn.pi.repositories.RatingRepository;
import tn.pi.repositories.UserRepository;
@Service
public class RatingServiceImpl implements IRatingService{
	
	@Autowired
	RatingRepository ratPubRep;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ProductRepository pubRepo;

	
	@Override
	public String addRatingPub(int idUser,int idProduct,Rating rat ) {
		
		
		
		User user = userRepo.findById(idUser).orElse(null);
		Product pub =pubRepo.findById(idProduct).orElse(null);
		rat.setProduct(pub);
		rat.setUser(user);
		List<Rating> ratPub= ratPubRep.findRatingPubByPublicationAndUser(idProduct, idUser);
		if(ratPub.size()!=0) {
			rat.setIdrating(ratPub.get(0).getIdrating());
			
						
			updateRatingPub(ratPub.get(0)); 
			return "Rating is updating successfully";
		}

	
		ratPubRep.save(rat);
		
		return "Rating is done successfully";
		
	}
	
	@Override
	public String updateRatingPub(Rating ratPub) {
		// TODO Auto-generated method stub
		ratPubRep.save(ratPub);
		return "successful update";
	}

	@Override
	public float getAvgRat() {
		// TODO Auto-generated method stub
		return ratPubRep.getAvgOfValueRating();
	}

	@Override
	public float getValueRatingByPublicationAndUser(int idProduct, int idUser) {
		List<Rating> ratPub= ratPubRep.findRatingPubByPublicationAndUser(idProduct, idUser);
		if(ratPub.size()!=0) return ratPub.get(0).getNbretoile();
		
		return getAvgRat();
	}
	


}