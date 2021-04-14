package tn.pi.services;

import java.util.List;

import tn.pi.entities.Likes;


public interface LikesService {
	List<Likes> retrieveAllLikees();
	Likes addLikee(Likes lik);
//	void unlike (String idP);

}
