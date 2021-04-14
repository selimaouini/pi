package tn.pi.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.pi.Repository.PostRepository;
import tn.pi.Repository.RatingRepository;
import tn.pi.entities.Post;
import tn.pi.entities.Rating;

@Service
public class RatingServiceImpl implements RatingService {
	@Autowired 
	RatingRepository ratingRepository; 
	
	private static final Logger log = LogManager.getLogger(RatingServiceImpl.class);


	@Override
	public List<Post> retrieveAllPosts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post addRating(Rating rat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post updateRate(Rating rat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPostByRate(String idP) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void affecteRateToPost(int idR, int idP) {
		// TODO Auto-generated method stub
		
	}

}
