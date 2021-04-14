package tn.pi.Repository;

import org.springframework.data.repository.CrudRepository;

import tn.pi.entities.Rating;

public interface RatingRepository extends CrudRepository <Rating, Long> {

}
