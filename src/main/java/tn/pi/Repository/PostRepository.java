package tn.pi.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.pi.entities.Post;


public interface PostRepository extends CrudRepository <Post, Long> {

	
	
	
	 @Query("SELECT p FROM Post p WHERE p.title=: title")
		Post getPostByTitle (@Param ("title")  String title) ;
		
	 @Query("SELECT p FROM Post p WHERE p.theme=: theme")
		Post getPostByTheme (@Param ("theme")  String theme) ;
	 
	 
	 
	 
	/* @Query("SELECT p FROM Post p WHERE p.postUser.id=: idu")
     public	Post getPostByUser (@Param ("idu")  long idu) ;*/
	 
	 @Query("SELECT p FROM Post p order by p.dateCreation ASC")
	 public List <Post> retrievePostsByDateAsc(@Param ("dateCreation") Date dateCreation);
	 
	 @Query("SELECT p FROM Post p order by p.dateCreation DESC")
	 public List <Post> retrievePostsByDateDesc(@Param ("dateCreation") Date dateCreation);
	 
	 
	 
	 
	/* 
	 * 
	@Query("SELECT p FROM Post p WHERE p.theme LIKE '%' || :theme || '%' ")
	 List<Post> getPostByTheme (@Param ("theme") String theme) ;
	 * 
	 * 
	 * 
	 *   @Query("SELECT p FROM Post p WHERE p.title LIKE '%' || :title || '%' ")
	  public List<Post> getPostByTitle (@Param("title") String title);
	 *  
	 *  
   
    
    @Query("SELECT p FROM Post p WHERE s.title LIKE '%' || :title || '%' ")
	  public List<Post> getPostByTitle2 (@Param("title") String title);
	 * 
	 */
}
