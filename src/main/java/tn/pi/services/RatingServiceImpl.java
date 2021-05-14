package tn.pi.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.pi.Repository.PostRepository;
import tn.pi.Repository.RatingRepository;
import tn.pi.Repository.UserRepository;
import tn.pi.entities.Comment;
import tn.pi.entities.Post;
import tn.pi.entities.Rating;
import tn.pi.entities.User;

@Service
public class RatingServiceImpl implements RatingService {
	@Autowired 
	RatingRepository ratingRepository; 
	@Autowired 
	PostRepository postRepository;
	@Autowired 
	UserRepository userRepository;
	
	private static final Logger log = LogManager.getLogger(RatingServiceImpl.class);
	
	/******** JSF ********/

	@Override
	public long addOrUpdateRating(Rating rating) {
		ratingRepository.save(rating);
		return rating.getIdR();
	}

	/******** Crud ********/
	@Override
	public List<Rating> retrieveAllRatings() {
		List<Rating> ratings = (List<Rating>) ratingRepository.findAll();
		for (Rating rating : ratings) {
			log.info("rating :" + rating);
		}
		return ratings;
	}

	
	//tekhdem
	@Override
		public String rate( long id, long idP,int stars) {
		Rating rat = new Rating();
		User user = userRepository.findById(id).orElse(null);
	    Post post = postRepository.findById(idP).orElse(null);
	    rat.setPost(post);
	    rat.setUser(user);
		List<Rating> ratPost= ratingRepository.getRatingByPostAndUser(idP, id);
		if(ratPost.size()!=0) {
			rat.setIdR(ratPost.get(0).getIdR());
			 rat.setStars(stars);
			 ratPost.get(0).setStars(stars);			
			updateRating(ratPost.get(0)); 
			return "Rating is updating successfully";
		}

		rat.setStars(stars);
		ratingRepository.save(rat);
		
		return "Rating is done successfully";
		
		
		
	//	User user = userRepository.findById(id).get();
	    /*    if (user !=null && rat!=null) {
	        	rat.setStars(stars);
	            ratingRepository.save(rat);
	        }
	        else {*/
	       /*     Post post = postRepository.findById(idP).orElse(null);
	            if (post!=null && user!=null) {
	                rat = new Rating();
	                rat.setStars(stars);
	                rat.setPost(post);
	                rat.setUser(user);
	                ratingRepository.save(rat);*/
	           // }
	     //   }
	    }
	
	
	@Override
	public String updateRating(Rating rat) {
		 ratingRepository.save(rat);
		return "successful update";
	}
	@Override
	public void addrate(Rating rat, long idP, Integer buttonState) {
	/*	Post p = postRepository.findById(idP).get();
	//	Rating r = ratingRepository.findById(idR).get();
        if (buttonState.equals(0)) {
            rat.setStars(rat.getStars() - 1);
        } else if (buttonState.equals(1)) {
            rat.setStars(rat.getStars() + 1);
        }
        RatingRepository.save(rat);*/
		
	}


	/*
	 * 
	 * public void addRatingByPubId(Rating rat,int idclient, Integer rating, int idpub ) {
		publication pub = pubrep.findById(idpub).get();
		Client client=clientrep.findById(idclient).get();
		rat.setPublication(pub);
		rat.setClient(client);
        rat.setRating(rating);
		ratrep.save(rat);
		
	}
	 */

	
	/******** GetBy ********/
	
	@Override
	public Post getPostByRate(String idP) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void affecteRateToPost(int idR, int idP) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public float getAvgRat() {
		return ratingRepository.getAvgStars();
	}

	@Override
	public float getValueRatingByPostAndUser(long idP, long id) {
		List<Rating> rat= ratingRepository.getRatingByPostAndUser(idP, id);
		if(rat.size()!=0) return rat.get(0).getStars();
		return getAvgRat();
	}

	
}
