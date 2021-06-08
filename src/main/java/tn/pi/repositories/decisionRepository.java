package tn.pi.repositories;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.pi.entities.Decision;
import tn.pi.entities.Etatdemande;

@Repository
public interface decisionRepository extends JpaRepository<Decision,Integer> {
	
	
	
	
}
