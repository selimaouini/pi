package tn.pi.repositories;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.pi.entities.Decision;

@Repository
public interface decisionRepository extends JpaRepository<Decision,Integer> {
	//public List<Decision> findByDecision_stateFalse();
	
	
	
	
}
