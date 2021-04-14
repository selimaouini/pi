package tn.pi.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.pi.Repository.PostRepository;
import tn.pi.entities.Post;
import tn.pi.services.PostService;

@RestController
public class PostRestController {
	@Autowired 
	PostService postService;
	
	
	// http://localhost:8080/SpringMVC/servlet/retrieve-all-posts
		@GetMapping("/retrieve-all-posts")
		@ResponseBody
		public List<Post> getPosts() {
		List<Post> list = postService.retrieveAllPosts();
		return list;
		}
		
		// http://localhost:8080/SpringMVC/servlet/retrieve-user/{user-id}
	/*	@GetMapping("/retrieve-user/{user-id}")
		@ResponseBody
		public User retrieveUser(@PathVariable("user-id") String userId) {
		return userService.retrieveUser(userId);
		}*/

		// http://localhost:8081/SpringMVC/servlet/add-post
		@PostMapping("/add-post")
		@ResponseBody
		public Post addPost(@RequestBody Post pos) {
			Post post = postService.addPost(pos);
		return post;
		}
		
		// http://localhost:8081/SpringMVC/servlet/modify-post
		@PutMapping("/modify-post")
		@ResponseBody
		public Post modifyPost(@RequestBody Post post) {
		return postService.updatePost(post);
		}
		
		// http://localhost:8081/SpringMVC/servlet/remove-post/{post-id}
		@DeleteMapping("/remove-post/{post-id}")
		@ResponseBody
		public void removePost(@PathVariable("post-id") String postId) {
			postService.deletePost(postId);
		}

}
