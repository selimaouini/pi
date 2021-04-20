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
	
	//tekhdem
	// http://localhost:8081/SpringMVC/servlet/Post/retrieve-all-posts
		@GetMapping("/Post/retrieve-all-posts")
		@ResponseBody
		public List<Post> getPosts() {
		List<Post> list = postService.retrieveAllPosts();
		return list;
		}	

		//didn't work anymore
		// http://localhost:8081/SpringMVC/servlet/Post/add-post
				@PostMapping("/Post/add-post")
				@ResponseBody
				public Post addPost(@RequestBody Post pos) {
					Post post = postService.addPost(pos);
				return post;
				}
				
				// http://localhost:8081/SpringMVC/servlet/Post/modify-post
				@PutMapping("/Post/modify-post")
				@ResponseBody
				public Post modifyPost(@RequestBody Post post) {
				return postService.updatePost(post);
				}
		
		//tekhdem
		// http://localhost:8081/SpringMVC/servlet/Post/remove-post/{post-id}
		@DeleteMapping("/Post/remove-post/{post-id}")
		@ResponseBody
		public void removePost(@PathVariable("post-id") String postId) {
			postService.deletePost(postId);
		}

}
