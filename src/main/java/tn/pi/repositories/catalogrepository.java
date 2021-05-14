package tn.pi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.pi.entities.Product;
import tn.pi.entities.catalog;
@Repository
public interface catalogrepository extends JpaRepository<catalog, Integer>{
	
}
