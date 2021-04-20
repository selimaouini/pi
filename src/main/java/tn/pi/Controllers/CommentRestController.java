package tn.pi.Controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

	//ma y'afichich liste 
	// http://localhost:8081/SpringMVC/servlet/Comment/retrieve-all-comments
			@GetMapping("/Comment/retrieve-all-comments")
			@ResponseBody
			public List<Comment> getComments() {
			List<Comment> list = commentService.retrieveAllComments();
			return list;
			}	
	
	// http://localhost:8081/SpringMVC/servlet/comment/add-comment
				@PostMapping("/comment/add-comment")
				@ResponseBody
				public Comment addComment(@RequestBody Comment com) {
					Comment comment = commentService.addComment(com);
				return comment;
				}
				
				// http://localhost:8081/SpringMVC/servlet/Comment/modify-Comment
				@PutMapping("/modify-Comment")
				@ResponseBody
				public Comment modifyComment(@RequestBody Comment com) {
				return commentService.updateComment(com);
				}
				
				// http://localhost:8081/SpringMVC/servlet/comment/remove-com/{com-id}
				@DeleteMapping("/remove-com/{com-id}")
				@ResponseBody
				public void removeCom(@PathVariable("com-id") String comId) {
					commentService.deleteComment(comId);
				}
}
