package tn.pi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pi.entities.Claim;

@Repository
public interface claimRepository extends JpaRepository<Claim,Long> {

}
