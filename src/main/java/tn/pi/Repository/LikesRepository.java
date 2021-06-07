package tn.pi.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.pi.entities.Comment;
import tn.pi.entities.Likes;
import tn.pi.entities.Post;

@Repository
public interface LikesRepository extends CrudRepository<Likes, Long> {
	
	
	@Query("select count (*) from Likes l  where l.comment.idc=:idc and l.etat = 'like' ")
	public int getAllNbrLikesByCom(@Param("idc") long idc);
	
	@Query("select l from Likes l where l.comment.idc =idc and l.etat = 'like'")
	public List<Likes> getAllLikesByCom(@Param("etat") String etat);
	
	@Query("select count (*) from Likes l  where l.comment.idc=:idc and l.etat = 'dislike' ")
	public int getAllNbrDisLikesByCom(@Param("idc") long idc);
	
	@Query("select l from Likes l where  l.comment.idc=:idc and l.user.id=:id ")
	public Likes getLikesByComAndUser (@Param("idc") long idc, @Param("id") long id);
	
	@Query("select l from Likes l where  l.comment.idc=:idc and l.user.id=:id ")
	public Likes getDislikesByComAndUser (@Param("idc") long idc, @Param("id") long id);
  
	
	/*
	
	@Query(value = "select count(*) from Likes where nb_like=1 and id_sujet= ?1", nativeQuery = true)
	 public int countlike(Long sujetId);
	
	@Query(value = "select count(*) from Likes where nb_dislike=1 and id_sujet= ?1", nativeQuery = true)
	 public int countdislike(Long sujetId);
*/
	
	/*
		
	 * 
	 * @Query("select l from Likes l JOIN Comment c JOIN User u where c.idc = :idc and u.id = :id")
	Likes findPostLiked(@Param("idc") long idc, @Param("id") long id);

	

	@Query("select count (*) from Like l where l.idc=:idc and l.etat = 'dislike'  ")
	public int getAllDisLikeByCom(@Param("idc") long idc);

	
	 * @Query("select distinct e.comment from Likes e ") public List<Comment>
	 * evsave();
	 * 
	 * @Query("select e from Likes e where e.comment=:comment") public Likes
	 * findev(@Param("comment") Comment comment);
	 * 
	 * ////comments + pertinents//////
	 * 
	 * @Query("SELECT MAX(l) FROM Likes JOIN Comment c WHERE c.idc=:idc") public
	 * int best1();
	 * 
	 * 
	 */
}
