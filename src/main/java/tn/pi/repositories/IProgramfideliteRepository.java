package tn.pi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.pi.entities.ProgrammeFidelité;

@Repository
public interface IProgramfideliteRepository extends JpaRepository<ProgrammeFidelité, Integer>{

}
