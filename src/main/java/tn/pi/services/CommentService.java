package tn.pi.services;

import java.util.List;


import tn.pi.entities.Comment;
import tn.pi.entities.Post;

public interface CommentService {
	
	
	/********Crud********/
	List<Comment> retrieveAllComments();
	List<Comment> retrieveAllCommentsByPost(long idP);
	Comment getCommentById(long idc);
	void addComment(Comment com,long idu, long idP);
	void updateComment(Comment com);
	void deleteComment(String idc);
	
	/********Likes********/
	//void affectCommentToUser(long idu, long idc);
    void likeComment(long idc, long idu,long idL);
    
    /********Mot interdit********/
    String getForbiddenWords();
    void setForbiddenWords(String words);
    
    void motInterdit ();
}

 // void likePost(long postId, long userId, boolean like);



