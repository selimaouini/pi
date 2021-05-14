package tn.pi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.pi.entities.Rating;

@Repository
public interface RatingRepository extends CrudRepository <Rating, Long> {
	 @Query("select r from Rating r JOIN User u JOIN Post p where p.idP = :idP and u.id = :id")
	    Rating getRating(@Param("idP")long idP, @Param("id")long id);
	 
	 
	 
	 @Query(value="select SUM(Rating) FROM Rating where r.Post.idP=:idP",nativeQuery=true)
		public float sumRating(@Param("idP")long idP);
	 
		
		@Query(value="select COUNT(idR) FROM Rating r where r.Post.idP=:idP",nativeQuery=true)
		public float countRating(@Param("idP")long idP);
		
		
		@Query("SELECT r FROM Rating r WHERE r.Post.idP=:idP AND r.User.id=:id ")
		public List<Rating> getRatingByPostAndUser(@Param("idP")long idP,@Param("id")long id);
		
		
		@Query("SELECT AVG(r.stars) FROM Rating r")
		public int getAvgStars();

}
