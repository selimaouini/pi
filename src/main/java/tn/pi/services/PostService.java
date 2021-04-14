package tn.pi.services;

import java.util.List;

import tn.pi.entities.Post;

public interface PostService {
	List<Post> retrieveAllPosts();
	Post addPost(Post pos);
	Post updatePost(Post pos);
	Post getPost(String idP);
	Post getPostByName(String name);
	Post getPostByprofil(int id ,int idc);
	void deletePost(String idP);
	void deleteSansInteraction (String idP);
	//void affectePostToUser(int id, int idP);
	void sujetRedondant ();


}
