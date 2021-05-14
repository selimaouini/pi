package tn.pi.services;

import java.util.List;

import tn.pi.entities.Likes;


public interface LikesService {
	/******** JSF ********/
	public long addOrUpdateLikes(Likes likes);

	void deleteLikesById(long idL);

	/****** Crud ******/
	List<Likes> retrieveAllLikes();//done
	public void deleteLike(String idL) ;//done
	public void deleteDislike(String idL);
	
	/******** Get By ********/
	Likes getLikeById(long idL); //done
	public int  getAllNbrLikesByCom(long idc); //done
	public int   getAllNbrDislikeByCom(long idc); //done
	List<Likes> getAllLikesByCom(String etat);
	public Likes getByComAndUser(long idc, long id); //done




	


}
