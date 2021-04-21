package tn.pi.Controllers;

import java.util.Date;
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
		
		//tekhdem
		// http://localhost:8081/SpringMVC/servlet/Post/retrieve-post/{post-id}
		@GetMapping("/Post/retrieve-post/{post-id}")
		@ResponseBody
		public Post getPostById(@PathVariable("post-id") String idP) {
		return postService.getPostById(idP);
		}
		
		

		//tekhdem
		// http://localhost:8081/SpringMVC/servlet/Post/add-post
				@PostMapping("/Post/add-post")
				@ResponseBody
				public Post addPost(@RequestBody Post pos) {
					Post post = postService.addPost(pos);
				return post;
				}
				
		//tekhdem
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

		// http://localhost:8081/SpringMVC/servlet/Post/get-by-title/{title}
	  	  @GetMapping("/Post/get-by-title")
		  @ResponseBody 
		  public  List<Post> getPostByTitle(@PathVariable("title") String title) {
			  List<Post> list =  (List<Post>) postService.getPostByTitle(title); 
			  return list; 
		 }
	  	  
	  	// http://localhost:8081/SpringMVC/servlet/Post/get-by-theme/{theme}
	  	  @GetMapping("/Post/get-by-theme")
		  @ResponseBody 
		  public  List<Post> getPostByTheme(@PathVariable("theme") String theme) {
			  List<Post> list =  (List<Post>) postService.getPostByTheme(theme); 
			  return list; 
		 }
	  	  
	  	// http://localhost:8081/SpringMVC/servlet/Post/get-by-date-Asc
	  	  @GetMapping("/Post/get-by-date-Asc")
		  @ResponseBody 
		  public  List<Post> retrievePostsByDateAsc(@PathVariable("dateCreation") Date dateCreation) {
			  List<Post> list =  (List<Post>) postService.retrievePostsByDateAsc(dateCreation); 
			  return list; 
		 }
	  	  
	    	// http://localhost:8081/SpringMVC/servlet/Post/get-by-date-Desc
	  	  @GetMapping("/Post/get-by-date-Desc")
		  @ResponseBody 
		  public  List<Post> retrievePostsByDateDesc(@PathVariable("dateCreation") Date dateCreation) {
			  List<Post> list =  (List<Post>) postService.retrievePostsByDateDesc(dateCreation); 
			  return list; 
		 }
	  	  
	  	  
	  	  
	  	  
	  	  /*
	  	   * http://localhost:8081/SpringMVC/servlet/Post/upload-img
	  	   *  @PostMapping("/Post/upload-img")
	  	   * @ResponseBody
    public ImageResponse uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        byte[] photo=decompressBytes(compressBytes(file.getBytes()));
        return new ImageResponse(photo);
    }

	  	   */
}	
