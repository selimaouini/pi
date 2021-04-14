package tn.pi.services;

import java.util.List;

import tn.pi.entities.Comment;
import tn.pi.entities.Post;

public interface CommentService {
	List<Comment> retrieveAllCommentsByPost();
	Comment addComment(Comment com);
	Comment updateComment(Comment com);
	void deleteComment(String idC);
	void motInterdit ();
}
