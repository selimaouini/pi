package tn.pi.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.pi.entities.Ads;
import tn.pi.entities.AdsView;
@Repository
public interface AdsViewRepository extends CrudRepository<AdsView,Integer>{

	AdsView getAdsViewByAds(Ads ads);
}
