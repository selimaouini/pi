package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Donation;

public interface DonationRepository extends CrudRepository<Donation, Integer>{

}
