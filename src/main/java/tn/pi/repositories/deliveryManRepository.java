package tn.pi.repositories;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.pi.entities.DeliveryMan;
import tn.pi.entities.User;

@Repository
public interface deliveryManRepository extends JpaRepository<DeliveryMan,Integer>  {

	
	
	@Query("select c FROM DeliveryMan c where (c.workZone=:wc) ")
	public DeliveryMan  getdeliverymanbyworkzone(@Param ("wc") String workZone);
	
	
	
}
