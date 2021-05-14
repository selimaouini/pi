package tn.pi.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.pi.entities.Comment;
import tn.pi.entities.Likes;
import tn.pi.entities.Post;
import tn.pi.services.CommentService;
import tn.pi.services.LikesService;

@RestController
public class LikesRestController {
	@Autowired
	LikesService likesService;

	@Autowired
	CommentService commentService;

	// tekhdem
	// http://localhost:8081/SpringMVC/servlet/comment/retrieve-all-likes
	@GetMapping("/comment/retrieve-all-likes")
	@ResponseBody
	public List<Likes> getLikes() {
		List<Likes> list = likesService.retrieveAllLikes();
		return list;
	}

	// tekhdem
	// http://localhost:8081/SpringMVC/servlet/comment/retrieve-like/{like-id}
	@GetMapping("/comment/retrieve-like/{idL}")
	@ResponseBody
	public Likes getlikeById(@PathVariable("idL") long idL) {
		return likesService.getLikeById(idL);
	}

	// tekhdem
	// http://localhost:8081/SpringMVC/servlet/comment/remove-like/{like-id}
	@DeleteMapping("/comment/remove-like/{idL}")
	@ResponseBody
	public ResponseEntity<String> removeLike(@PathVariable("idL") String idL) {
		likesService.deleteLike(idL);
		return new ResponseEntity<String>("like removed !", HttpStatus.OK);
	}

	// http://localhost:8081/SpringMVC/servlet/Like/remove-dislike/{idL}
	@DeleteMapping("/Like/remove-dislike/{idL}")
	@ResponseBody
	public ResponseEntity<String> removeDislike(@PathVariable("idL") String idL) {
		likesService.deleteDislike(idL);
		return new ResponseEntity<String>("dislike removed !", HttpStatus.OK);
	}
	
	// tekhdem
	// http://localhost:8081/SpringMVC/servlet/comment/getAllLikeByCom/{idc}
	@GetMapping(value = "/comment/getAllLikeByCom/{idc}")
	@ResponseBody
	public int getAllLikeByCom(@PathVariable("idc") long idc) {

		return likesService.getAllNbrLikesByCom(idc);
	}

	// tekhdem
	// http://localhost:8081/SpringMVC/servlet/comment/getAllDisLikeByCom/{idc}
	@GetMapping(value = "/comment/getAllDisLikeByCom/{idc}")
	@ResponseBody
	public int getAllDisLikeByCom(@PathVariable("idc") long idc) {

		return likesService.getAllNbrDislikeByCom(idc);
	}

	// http://localhost:8081/SpringMVC/servlet/comment/getAllNbrLikeByCom/etat
	@GetMapping("/getAllNbrLikeByCom/etat")
	@ResponseBody
	public List<Likes> getAllLikesByCom(@PathVariable("etat") String etat) {
		return likesService.getAllLikesByCom(etat);
	}

	// tekhdem
	// http://localhost:8081/SpringMVC/servlet/comment/retrieve-Like/{idc}/{idu}
	@GetMapping("/comment/retrieve-Like/{idc}/{idu}")
	@ResponseBody
	public Likes getLike(@PathVariable("idc") long idc, @PathVariable("idu") long idu) {
		return likesService.getByComAndUser(idc, idu);
	}
	
}
