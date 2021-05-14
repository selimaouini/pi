package tn.pi.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.pi.entities.Comment;
import tn.pi.entities.Post;
import tn.pi.entities.User;

@Repository
public interface CommentRepository extends CrudRepository <Comment, Long> {
	
	@Query("SELECT count(*) as nbr FROM Comment")
	int getNombresComment();
	
	@Query("SELECT COUNT(*) FROM Comment c WHERE  c.Post.idP=:idP ")
	public long getNombrecommentsByPost();
	
	@Modifying
    @Transactional
    @Query("DELETE from Comment c where c.description='***'")
    public void deleteForbiddenWords();
	
	
	@Query("SELECT c FROM Comment c WHERE c.Post.idP=:idP")
	List<Comment> getAllByPostId(@Param("idP") long idP);

/*		@Query("select count (*) from Likes l  where l.comment.idc=:idc and l.etat = 'dislike' ")

    
    
 * 
 *  //list of user's comments of the post
	 @Query("SELECT c FROM Comment c JOIN User u WHERE u.id=:id")
	 public List<Comment> retrieveAllComments (@Param("id") Long id);
	 
	 
	  
	 //list of user's comments of the subject
	 @Query("select s from Comment s where s.user=:user")
	 public List<Comment> mylist(@Param("user") User user);
	 
*/
}
