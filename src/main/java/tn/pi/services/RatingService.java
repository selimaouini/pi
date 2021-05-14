package tn.pi.services;

import java.util.List;

import tn.pi.entities.Post;
import tn.pi.entities.Rating;

public interface RatingService {
	
	/******** JSF ********/
	public long addOrUpdateRating(Rating rating) ;
	
	
	/****** Crud ******/
	List<Rating> retrieveAllRatings();

	public String rate( long id, long idP,int stars);//done

	public void addrate(Rating rat,long idP, Integer buttonState);

	
	public String updateRating(Rating rat);

	/******** Get By ********/
	public float getValueRatingByPostAndUser(long idP, long id);
	public float getAvgRat();
	Post getPostByRate(String idP); // the most rated post
	// Post getRateByUser(int idR ,int idC);

	void affecteRateToPost(int idR, int idP);

}
