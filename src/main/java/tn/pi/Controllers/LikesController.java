package tn.pi.Controllers;

import java.util.List;

import javax.persistence.Column;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.pi.entities.Comment;
import tn.pi.entities.Likes;
import tn.pi.services.LikesService;

@Scope(value = "session")
@Controller(value = "likesController")
@ELBeanName(value = "likesController")
public class LikesController {
	
	@Autowired 
	LikesService likesService; 
	
	
private long idL;
private long idc;
	private boolean liked;

	private boolean disliked;

	private String etat;
	
	private List<Likes> likess;

	
	public List<Likes> getlikess() {	
		likess = likesService.retrieveAllLikes();
	//	likess = likesService. getByComAndUser(long idc,long idu) ;

		return likess;
	}

	public void removelikes(long idL) {
		likesService.deleteLikesById(idL);
	}
	
	
	
	
	
	public boolean isLiked() {
		return liked;
	}

	public void setLiked(boolean liked) {
		this.liked = liked;
	}

	public boolean isDisliked() {
		return disliked;
	}

	public void setDisliked(boolean disliked) {
		this.disliked = disliked;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public List<Likes> getLikess() {
		return likess;
	}

	public void setLikess(List<Likes> likess) {
		this.likess = likess;
	}
	
	

}
