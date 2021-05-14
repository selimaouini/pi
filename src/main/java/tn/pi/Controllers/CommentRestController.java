package tn.pi.Controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import tn.pi.Repository.CommentRepository;
import tn.pi.entities.Comment;
import tn.pi.entities.Post;
import tn.pi.services.CommentService;
import tn.pi.services.PostServiceImpl;

@RestController
public class CommentRestController {
	@Autowired
	CommentService commentService;

	// yemchi
	// http://localhost:8081/SpringMVC/servlet/comment/retrieve-all-comments
	@GetMapping("/comment/retrieve-all-comments")
	@ResponseBody
	public List<Comment> getComments() {
		List<Comment> list = commentService.retrieveAllComments();
		return list;
	}

	// yemchi
	// http://localhost:8081/SpringMVC/servlet/comment/add-comment/{idu}/{idP}
	@PostMapping("/comment/add-comment/{idu}/{idP}")
	@ResponseBody
	public ResponseEntity<String> addComment(@RequestBody Comment com, @PathVariable("idu") long idu,
			@PathVariable("idP") long idP) {
		// if (!com.getDescription().isEmpty())
		commentService.addComment(com, idu, idP);
		return new ResponseEntity<String>("Comment added !", HttpStatus.OK);
	}
	
	// http://localhost:8081/SpringMVC/servlet/Comment/{idP}/comment/addComment		 
		  @PostMapping("/Comment/{idP}/comment/addComment")		  
		  @ResponseBody public ResponseEntity<String> ajouterComment(@PathVariable("idP") long idP ,@PathVariable("idc") long idc) {
		  commentService.affectCommentToPost(idP, idc); 
			return new ResponseEntity<String>("Comment affected !", HttpStatus.OK);
		  }

	// yemchi
	// http://localhost:8081/SpringMVC/servlet/comment/modify-Comment
	@PutMapping("/Comment/modify-Comment")
	@ResponseBody
	public ResponseEntity<String> modifyComment(@RequestBody Comment com) {
		Comment comment = commentService.getCommentById(com.getIdc());
		if (comment != null && (!com.getDescription().isEmpty()))
			commentService.updateComment(com);
		return new ResponseEntity<String>("Comment updated !", HttpStatus.OK);
	}

	// yemchi
	// http://localhost:8081/SpringMVC/servlet/comment/remove-com/{com-id}
	@DeleteMapping("/comment/remove-com/{com-id}")
	@ResponseBody
	public ResponseEntity<String> removeCom(@PathVariable("com-id") String comId) {
		commentService.deleteComment(comId);
		return new ResponseEntity<String>("Comment deleted !", HttpStatus.OK);
	}

	// yemchi
	// http://localhost:8081/SpringMVC/servlet/comment/{idc}
	@GetMapping("/comment/{idc}")
	@ResponseBody
	public Comment getCommentById(@PathVariable("idc") long idc) {
		return commentService.getCommentById(idc);
	}

	// yemchi
	// http://localhost:8081/SpringMVC/servlet/comment/{idP}/comments
	@GetMapping("/comment/{idP}/comments")
	public List<Comment> getAllCommentsByPost(@PathVariable("idP") long idP) {
		return commentService.getAllCommentsByPostId(idP);
	}

	// http://localhost:8081/SpringMVC/servlet/comment/nbrcmt/{idP}
	@GetMapping("/comment/nbrcmt/{idP}")
	public long NombresCommentsByPost(@PathVariable("idP") long idP) {
		return commentService.NombresCommentsByPost(idP);
	}

	// http://localhost:8081/SpringMVC/servlet/comment/deleteForbiddenWord
	 @DeleteMapping("/comment/deleteForbiddenWord") 
	 @ResponseBody
	 public ResponseEntity<String>  deleteForbiddenWord() {
		 commentService.deleteForbiddenWords();
			return new ResponseEntity<String>("forbidden word deleted!", HttpStatus.OK);
		}
	 
	 
	 
	 //tekhdem
		// http://localhost:8081/SpringMVC/servlet/comment/like/{idc}/{id}/{liked}
	  @PostMapping("/comment/like/{idc}/{id}/{liked}")
      @ResponseBody
      public ResponseEntity<String> likeComment(@PathVariable("idc")long idc, @PathVariable("id")long id,  @PathVariable("liked")boolean liked)
      {	//	if (comment != null )
          commentService.likeComment(idc, id, liked);
      	return new ResponseEntity<String>("comment liked !", HttpStatus.OK);
      }
	  
	  
//tekhdem
		// http://localhost:8081/SpringMVC/servlet/comment/dislike/{idc}/{id}/{disliked}
	  @PostMapping("/comment/dislike/{idc}/{id}/{liked}")
    @ResponseBody
    public ResponseEntity<String> dislikeComment(@PathVariable("idc")long idc, @PathVariable("id")long id,  @PathVariable("liked")boolean disliked)
    {	//	if (comment != null )
        commentService.dislikeComment(idc, id, disliked);
    	return new ResponseEntity<String>("comment liked !", HttpStatus.OK);
    }
}
