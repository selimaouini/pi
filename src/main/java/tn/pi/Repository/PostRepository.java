package tn.pi.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.pi.entities.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

	@Query("SELECT p FROM Post p JOIN User u WHERE u.id =: id")
	public List<Post> getPostByUserId(@Param("id") Long id);

	@Query("SELECT p FROM Post p order by p.dateCreation asc")
	public List<Post> getAllPostsOrderByDateByDateAsc();
	

	@Query("select p from Post p order by p.dateCreation desc")
	List<Post> getAllPostsOrderedByDate();

	@Query("SELECT p from Post p join User u on p.User.id = u.id  where p.title like %:word% or p.theme like %:word% or u.firstName like %:word% ")
	public List<Post> searchPost(@Param("word") String word);

	@Query(value = "SELECT p.title from Post p INNER JOIN Comment c ON p.idP = c.idP group by title order by count(*) desc limit 5", nativeQuery = true)
	//@Query("SELECT p.title from Post p JOIN Comment c where c.idc=idc GROUP BY title ORDER BY count(*) desc limit 3")
	List<String> getPostMostCommented();

	@Query("SELECT p FROM Post p WHERE p.title=:title")
	public List<Post> findByTitle(@Param("title") String title);

	@Modifying
	@Transactional
    @Query(value="delete from Post  where DATEDIFF(CURRENT_TIMESTAMP,dateCreation)>=10 and Rating.Stars=0",nativeQuery=true)
	// @Query("delete from Post  where DATEDIFF(CURRENT_TIMESTAMP,dateCreation)>=10 and Rating.Stars=0")
	public void deleteSansInteraction();
	
	
	
	@Query("SELECT DISTINCT p FROM Post p where p.etat='waiting' ORDER BY p.dateCreation DESC")
	public List<Post> findAllbyEtatWaiting();
	

	@Query("SELECT DISTINCT p FROM Post p where p.etat='accepted' ORDER BY p.dateCreation DESC")
	public List<Post> findAllbyEtataccepted();
	
	/*	@Query("SELECT p FROM Post p order by p.dateCreation ASC")
	public List<Post> retrievePostsByDateAsc(@Param("dateCreation") LocalDateTime dateCreation);
	 * 
	 * 
	 * @Query(value="select COUNT(idR) FROM Rating r where r.Post.idP=:idP",nativeQuery=true)
		public float countRating(@Param("idP")long idP);
		
	 * 
	 * 	@Modifying
	@Query("update Delivery d set d.rate = :rate where d.idDelivery = :id")
	@Transactional
	void updateRate( @Param(value = "id") int id, @Param(value = "rate") int rate);
	 */
}
