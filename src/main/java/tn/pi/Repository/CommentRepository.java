package tn.pi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.pi.entities.Comment;
import tn.pi.entities.Post;
import tn.pi.entities.User;

public interface CommentRepository extends CrudRepository <Comment, Long> {
	 
/*	 //list of user's comments of the post
	 @Query("SELECT c FROM Comment c JOIN User u WHERE u.idu=:id")
	 public List<Comment> retrieveAllComments (@Param("idu") Long idu);
	 
	 
	  
	 //list of user's comments of the subject
	 @Query("select s from Comment s where s.user=:user")
	 public List<Comment> mylist(@Param("user") User user);
*/
}
