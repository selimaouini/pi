package tn.pi.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.pi.entities.Ads;
import tn.pi.entities.Product;

@Repository
public interface AdsRepository extends CrudRepository<Ads,Integer>{

	List<Ads> getAdsByStartDate(Date SDate);
	List<Ads> getAdsByFinishDate(Date FDate);
	List<Ads> getAdsByproduct(Product prod);
}
