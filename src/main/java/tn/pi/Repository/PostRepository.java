package tn.pi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.pi.entities.Post;


public interface PostRepository extends CrudRepository <Post, Long> {

	/*@Query("SELECT name FROM Post pos WHERE e.name= :name")
	List<Post> retrieveUserByName (@Param ("name") String name) ;*/
}
