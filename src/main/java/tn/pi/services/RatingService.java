package tn.pi.services;

import java.util.List;

import tn.pi.entities.Post;
import tn.pi.entities.Rating;

public interface RatingService {
	List<Post> retrieveAllPosts();
	Post addRating(Rating rat);
	Post updateRate(Rating rat);
	Post getPostByRate(String idP);  //the most rated post 
//	Post getRateByUser(int idR ,int idC);
	void affecteRateToPost(int idR, int idP);

}
