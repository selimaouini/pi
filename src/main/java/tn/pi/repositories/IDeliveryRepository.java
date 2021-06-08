package tn.pi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.pi.entities.Cart;
import tn.pi.entities.Delivery;
import tn.pi.entities.Product;
import tn.pi.entities.User;


@Repository
public interface IDeliveryRepository extends JpaRepository<Delivery, Integer>{


	
	
	
	
	
	
}
