package tn.pi.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.pi.entities.Ads;
import tn.pi.entities.Product;

@Repository
public interface AdsRepository extends CrudRepository<Ads,Integer>{

	
	List<Ads> getAdsByproduct(Product prod);
	@Query("select c FROM Ads c ORDER BY c.TargetView_tot DESC")
	public List<Ads> selectAll();



}
