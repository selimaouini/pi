package tn.pi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.pi.entities.Product;
@Repository
public interface IProductRepository extends JpaRepository<Product, Integer>{
	
}
