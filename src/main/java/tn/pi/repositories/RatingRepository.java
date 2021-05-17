package tn.pi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.pi.entities.Rating;
import tn.pi.entities.Product;


public interface RatingRepository extends JpaRepository<Rating, Integer> {
	
	@Query("select e.product from Rating e ")
	public List<Product> evsave();
	
	@Query("select e from Rating e where e.product=:product")
	public Rating findev(@Param("product") Product product);
	
	
	@Query("SELECT rat FROM Rating rat WHERE rat.product.id=:idProduct AND rat.user.id=:idUser ")
	public List<Rating> findRatingPubByPublicationAndUser(@Param("idProduct")int idProduct,@Param("idUser")int idUser);

	@Query("SELECT AVG(rat.nbretoile) FROM Rating rat")
	public int getAvgOfValueRating();



}
