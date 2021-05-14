package tn.pi.Controllers;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.pi.entities.Post;
import tn.pi.entities.Rating;
import tn.pi.services.PostService;
import tn.pi.services.RatingService;

@RestController
public class PostRestController {
	@Autowired
	PostService postService;
	@Autowired
	RatingService ratingService;

	// tekhdem
	// http://localhost:8081/SpringMVC/servlet/Post/retrieve-all-posts
	@GetMapping("/Post/retrieve-all-posts")
	@ResponseBody
	public List<Post> getPosts() {
		List<Post> list = postService.retrieveAllPosts();
		return list;
	}

	// tekhdem
	// http://localhost:8081/SpringMVC/servlet/Post/retrieve-post/{post-id}
	@GetMapping("/Post/retrieve-post/{post-id}")
	@ResponseBody
	public Post getPostById(@PathVariable("post-id") long idP) {
		return postService.getPostById(idP);
	}

// tekhdem
	// http://localhost:8081/SpringMVC/servlet/Post/add-post/{user-id}
	@PostMapping("/Post/add-post/{idu}")
	@ResponseBody
	public ResponseEntity<String> addPost(@RequestBody Post p, @PathVariable("idu") long idu) {
		if (!p.getContent().isEmpty() || !p.getPhoto().isEmpty())
			postService.addPost(p, idu);
		return new ResponseEntity<String>("post added !", HttpStatus.OK);

	}

	// tekhdem
	// http://localhost:8081/SpringMVC/servlet/Post/modify-post
	@PutMapping("/Post/modify-post")
	@ResponseBody
	public ResponseEntity<String> updatePost(@RequestBody Post p) {
		Post post = postService.getPostById(p.getIdP());
	//	if (post != null && (!p.getContent().isEmpty() || !p.getPhoto().isEmpty()))
			postService.updatePost(p);
		return new ResponseEntity<String>("post updated !", HttpStatus.OK);
	}

	// tekhdem
	// http://localhost:8081/SpringMVC/servlet/Post/remove-post/{post-id}
	@DeleteMapping("/Post/remove-post/{idP}")
	@ResponseBody
	public ResponseEntity<String> removePost(@PathVariable("idP") String idP) {
		postService.deletePost(idP);
		return new ResponseEntity<String>("post deleted !", HttpStatus.OK);
	}

	// tekhdem: 9dim l jdid
	// http://localhost:8081/SpringMVC/servlet/Post/get-by-date-Asc
	@GetMapping("/Post/get-by-date-Asc")
	@ResponseBody
	public List<Post> retrievePostsByDateAsc() {
		List<Post> list = (List<Post>) postService.retrievePostsByDateAsc();
		return list;
	}

	
	// tekhdem: jdid lel 9dim
	// http://localhost:8081/SpringMVC/servlet/Post/get-by-date
	@GetMapping("/Post/get-by-date")
	@ResponseBody
	public List<Post> retrievePostsByDate() {
		List<Post> list = (List<Post>) postService.getAllPostsOrderedByDate();
		return list;
	}

	// http://localhost:8081/SpringMVC/servlet/Post/getPost-By-UserId/{idUser}
	@GetMapping("/Post/getPost-By-UserId/{idu}")
	@ResponseBody
	public List<Post> getPostByUserId(@PathVariable("idu") Long idu) {
		return (List<Post>) postService.getPostByUserId(idu);
	}

	// tekhdem
	// http://localhost:8081/SpringMVC/servlet/Post/search/{word}
	@GetMapping("Post/search/{word}")
	@ResponseBody
	public List<Post> searchPost(@PathVariable("word") String word) {
		return postService.search(word);
	}

	// http://localhost:8081/SpringMVC/servlet/Post/most-commented
	@GetMapping("/Post/most-commented")
	@ResponseBody
	public List<String> PostmostComment() {
		return postService.PostMostCommented();
	}

	// http://localhost:8081/SpringMVC/servlet/Post/deleteSansInteraction
	 @DeleteMapping("/Post/deleteSansInteraction") 
	 @ResponseBody
		public ResponseEntity<String> deleteSansInteraction(){
		 postService.deleteSansInteraction();	
			return new ResponseEntity<String>("post without interaction deleted !", HttpStatus.OK);
		}
	 
	/******** Rating Section ********/

	// tekhdem
	// http://localhost:8081/SpringMVC/servlet/Post/addRating/{idu}/{idP}/{stars}
	@PostMapping(value = "/Post/addRating/{idu}/{idP}/{stars}")
	@ResponseBody
	public void addRatingByPost(Rating rat, @PathVariable("idu") long idu, @PathVariable("idP") long idP,
			@PathVariable("stars") int stars) {
		ratingService.rate( idu, idP, stars);

	}

	// tekhdem
	// http://localhost:8081/SpringMVC/servlet/Post/Rating/retrieve-all-ratings
	@GetMapping("/Post/Rating/retrieve-all-ratings")
	@ResponseBody
	public List<Rating> getRatings() {
		List<Rating> list = ratingService.retrieveAllRatings();
		return list;
	}

	// tekhdem
	// http://localhost:8081/SpringMVC/servlet/Post/Rating/GetBy_Post_User/{idP}/{idu}
	@GetMapping("/Post/Rating/GetBy_Post_User/{idP}/{idu}")
	public float getValueRatingByPostAndUser(@PathVariable("idP") long idP,
			@PathVariable("idu") long idu) {
		return ratingService.getValueRatingByPostAndUser(idP, idu);
	}

	// tekhdem
	// http://localhost:8081/SpringMVC/servlet/Post/getAVG-Rate/{idP}
	@GetMapping(value = "/Post/getAVG-Rate/{idP}")
	@ResponseBody
	public void avgRating (Rating rat, @PathVariable("idP") long idP) {
		ratingService.getAvgRat( );

	}
	/*
	 * http://localhost:8081/SpringMVC/servlet/Post/upload-img
	 * 
	 * @PostMapping("/Post/upload-img")
	 * 
	 * @ResponseBody public ImageResponse uplaodImage(@RequestParam("imageFile")
	 * MultipartFile file) throws IOException {
	 * System.out.println("Original Image Byte Size - " +
	 * file.getBytes().length); byte[]
	 * photo=decompressBytes(compressBytes(file.getBytes())); return new
	 * ImageResponse(photo); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @PostMapping("/upload")
    public ImageResponse uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {

        System.out.println("Original Image Byte Size - " + file.getBytes().length);

        byte[] photo=decompressBytes(compressBytes(file.getBytes()));
        return new ImageResponse(photo);
    }
	 */
}
