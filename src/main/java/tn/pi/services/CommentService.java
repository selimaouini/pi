package tn.pi.services;

import java.util.List;


import tn.pi.entities.Comment;
import tn.pi.entities.Post;

public interface CommentService {
	List<Comment> retrieveAllComments();
	List<Comment> retrieveAllCommentsByPost(long idP);
	Comment addComment(Comment com);
	Comment updateComment(Comment com);
	void deleteComment(String idc);
	void motInterdit ();
	void affectCommentToUser(long idu, long idc);
}
