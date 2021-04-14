package tn.pi.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.pi.Repository.LikesRepository;
import tn.pi.Repository.PostRepository;
import tn.pi.entities.Post;


@Service
public class PostServiceImpl implements PostService {
	@Autowired 
	PostRepository postRepository; 
	
	private static final Logger log = LogManager.getLogger(PostServiceImpl.class);

	@Override
	public List<Post> retrieveAllPosts() {
		List<Post> posts= (List<Post>) postRepository.findAll();
		for (Post post: posts){
			log.info ("post :" +post);
				}
	return posts; 		
	}

	@Override
	public Post addPost(Post pos) {
		postRepository.save(pos);
		return pos;
	}

	@Override
	public Post updatePost(Post pos) {
		postRepository.save(pos);
		return pos;
	}

	@Override
	public Post getPost(String idP) {
		Post pos =  postRepository.findById(Long.parseLong(idP)).orElse(null);
		log.info ("post :" +pos);
		 return pos ;
	}

	@Override
	public Post getPostByName(String name) {
		return null;
		/*List<Post> posts = (List<Post>)  postRepository.retrieveUserByName(name); 
		for (Post post : posts )	{
			log.info ("posts are written by:" +name);
			}
	return posts; */
	}
	
	@Override
	public Post getPostByprofil(int id, int idc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(String idP) {
		postRepository.deleteById(Long.parseLong(idP));
		
	}	

	@Override
	public void deleteSansInteraction(String idP) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sujetRedondant() {
		// TODO Auto-generated method stub
		
	}
	

}
