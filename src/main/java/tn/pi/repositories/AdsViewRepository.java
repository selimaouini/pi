package tn.pi.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.pi.entities.Ads;
import tn.pi.entities.AdsView;
@Repository
public interface AdsViewRepository extends CrudRepository<AdsView,Integer>{

	AdsView getAdsViewByAds(Ads ads);
	
	@Query("select count(c) from AdsView c where c.ads=:y ")
	public long count(@Param("y") Ads ads);

	@Query("select count(c) from AdsView c where c.ads=:y and c.user.gender='male' ")
	public long countGM(@Param("y") Ads ads);
	
	@Query("select count(c) from AdsView c where c.ads=:y and c.user.gender='female' ")
	public long countGF(@Param("y") Ads ads);

}

