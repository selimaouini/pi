package tn.pi.repositories;


import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.pi.entities.Delivery;
import tn.pi.entities.DeliveryMan;
import tn.pi.entities.DeliveryState;

@Repository
public interface deliveryRepository extends JpaRepository<Delivery,Integer>  {

	@Modifying
	@Query("update Delivery d set d.state = :state where d.id_delivery = :id")
	@Transactional
	void updateState( @Param(value = "id") int id, @Param(value = "state") DeliveryState state);
	
	
	@Query("select c FROM Delivery c where (c.city=:wc) ")
	public Delivery  getdeliverybycity(@Param ("wc") String city);
	
	

}
