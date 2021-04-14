package tn.pi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pi.entities.Delivery;

@Repository
public interface deliveryRepository extends JpaRepository<Delivery,Long>  {

}
