package tn.pi.services;

import java.util.List;

import tn.pi.entities.Post;
import tn.pi.entities.User;

public interface PostService {
	List<Post> retrieveAllPosts();
	Post addPost(Post pos);
	Post updatePost(Post pos);
	Post getPostById(String idP);
	Post getPostByTitle(String title);
//	Post getPostByUser(int id ,int idc);
	Post getPostByTheme (String theme);
	public List<Post> getPostByUser(long idu);
	void deletePost(String idP);
	void deleteSansInteraction (String idP); //not commented
	//void affectPostToUser(int id, int idP);
	void sujetRedondant ();
//filtre 


}
