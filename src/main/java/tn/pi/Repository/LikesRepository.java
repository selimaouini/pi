package tn.pi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.pi.entities.Comment;
import tn.pi.entities.Likes;

public interface LikesRepository extends CrudRepository <Likes, Long> {
	
/*	@Query("select distinct e.comment from Likes e ")
	public List<Comment> evsave();
	
	@Query("select e from Likes e where e.comment=:comment")
	public Likes findev(@Param("comment") Comment comment);

	 ////comments + pertinents//////
	@Query("select max(e.l) from Comment_evaluation e")
	public int best1();
	
	@Query("select max(e.h) from Comment_evaluation e")
	public int best2();
	
	Likes findByL(int l);
	Likes findByH(int h);
	
	@Query("select e.comment from Likes e where e.l=:nbrl or e.h=:nbrh")
	public List<Comment> myfind(@Param("nbrl") int nbrl , @Param("nbrh") int nbrh);*/
}
