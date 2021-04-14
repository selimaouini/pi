package tn.pi.Repository;

import org.springframework.data.repository.CrudRepository;

import tn.pi.entities.Comment;

public interface CommentRepository extends CrudRepository <Comment, Long> {

}
