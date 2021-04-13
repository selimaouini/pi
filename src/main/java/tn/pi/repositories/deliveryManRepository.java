package tn.pi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pi.entities.DeliveryMan;

@Repository
public interface deliveryManRepository extends JpaRepository<DeliveryMan,Long>  {

}
