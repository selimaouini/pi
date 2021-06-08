package tn.pi.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.pi.entities.Donation;

public interface DonationRepository extends CrudRepository<Donation, Integer>{

}
