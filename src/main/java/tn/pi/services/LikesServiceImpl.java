package tn.pi.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.pi.Repository.CommentRepository;
import tn.pi.Repository.LikesRepository;
import tn.pi.entities.Likes;

@Service
public class LikesServiceImpl implements  LikesService{
	@Autowired 
	LikesRepository likesRepository; 
	
	private static final Logger log = LogManager.getLogger(LikesServiceImpl.class);

	@Override
	public List<Likes> retrieveAllLikees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Likes addLikee(Likes lik) {
		// TODO Auto-generated method stub
		return null;
	}

}
	