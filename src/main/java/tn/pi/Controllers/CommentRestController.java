package tn.pi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.pi.entities.Comment;
import tn.pi.entities.Post;
import tn.pi.services.CommentService;

@RestController
public class CommentRestController {
	@Autowired 
	CommentService commentService; 
	
	// http://localhost:8081/SpringMVC/servlet/add-comment
			@PostMapping("/add-comment")
			@ResponseBody
			public Comment addComment(@RequestBody Comment com) {
				Comment comment = commentService.addComment(com);
			return comment;
			}
			
			// http://localhost:8081/SpringMVC/servlet/modify-Comment
			@PutMapping("/modify-Comment")
			@ResponseBody
			public Comment modifyComment(@RequestBody Comment com) {
			return commentService.updateComment(com);
			}
			
			// http://localhost:8081/SpringMVC/servlet/remove-com/{com-id}
			@DeleteMapping("/remove-com/{com-id}")
			@ResponseBody
			public void removeCom(@PathVariable("com-id") String comId) {
				commentService.deleteComment(comId);
			}

}
