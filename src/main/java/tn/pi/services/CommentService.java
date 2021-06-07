package tn.pi.services;

import java.util.List;

import tn.pi.entities.Comment;
import tn.pi.entities.Post;
import tn.pi.entities.Theme;

public interface CommentService {
	/******** JSF ********/
	 public String save();
	 public Comment getComment();
	 public String delete(long idc);
	 public String modifier(Comment com, String description);
	 public void loadData();
	 public List<Comment> getComments();
	 public String saveModif();
	

	/******** Crud ********/
	List<Comment> retrieveAllComments();

	List<Comment> retrieveAllCommentsByPost(long idP);

	Comment getCommentById(long idc);

	void addComment(Comment com, long id, long idP);

	void updateComment(Comment com);

	void deleteComment(String idc);
	
	/******** Affectation ********/
	Comment affectCommentToPost(long idP, long idc);

	/******** Get ********/
	List<Comment> getAllCommentsByPostId(long idP);

	long NombresCommentsByPost(long idP);

	/******** Likes ********/
	 public void likeComment(long idc, long id, boolean liked); //done
	 public void dislikeComment(long idc, long id, boolean disliked); //done

	/******** Mot interdit ********/
	void deleteForbiddenWords();

}
