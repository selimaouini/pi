package tn.pi.Repository;

import org.springframework.data.repository.CrudRepository;

import tn.pi.entities.Likes;

public interface LikesRepository extends CrudRepository <Likes, Long> {
}
