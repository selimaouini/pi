package tn.pi.services;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import tn.pi.entities.Post;
import tn.pi.entities.User;

public interface PostService {
	List<Post> retrieveAllPosts();//done
	Post addPost(Post pos); //done
	Post updatePost(Post pos); //done 
	Post getPostById(String idP); //done 
	Post getPostByTitle(String title);
	Post getPostByTheme (String theme);
	public List<Post> getPostByUser(long idu);
//	Post getPostByUser(int idP ,int idu);
	void deletePost(String idP); //done
	void deleteSansInteraction (String idP); //not commented
	//void affectPostToUser(int id, int idP);
	void sujetRedondant ();

	List<Post> retrievePostsByDateAsc(Date dateCreation); //filtre by date asc
	List<Post> retrievePostsByDateDesc(Date dateCreation); //filtre by date desc
	//most rated 


}
