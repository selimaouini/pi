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

	//yemchi
	// http://localhost:8081/SpringMVC/servlet/comment/retrieve-all-comments
			@GetMapping("/comment/retrieve-all-comments")
			@ResponseBody
			public List<Comment> getComments() {
			List<Comment> list = commentService.retrieveAllComments();
			return list;
			}	
	//yemchi
	// http://localhost:8081/SpringMVC/servlet/comment/add-comment/{idu}/{idP}
	   @PostMapping("/comment/add-comment/{idu}/{idP}")
    @ResponseBody
    public ResponseEntity <String> addComment(@RequestBody Comment com,@PathVariable("idu") long idu,@PathVariable("idP") long idP) {
     //   if  (!com.getDescription().isEmpty())
            commentService.addComment(com, idu, idP);
        return new ResponseEntity <String>("Comment added !",HttpStatus.OK);
    }
	
				
				
				//yemchi
				// http://localhost:8081/SpringMVC/servlet/comment/modify-Comment
				@PutMapping("/Comment/modify-Comment")
				@ResponseBody
				public  ResponseEntity <String> modifyComment(@RequestBody Comment com) {
					Comment comment=commentService.getCommentById(com.getIdc());
			      //  if (comment!=null && (!com.getDescription().isEmpty() ))
			        	commentService.updateComment(com);
			        return new ResponseEntity <String>("Comment updated !",HttpStatus.OK);
				}
			
				// http://localhost:8081/SpringMVC/servlet/comment/remove-com/{com-id}
				@DeleteMapping("/comment/remove-com/{com-id}")
				@ResponseBody
				public ResponseEntity <String> removeCom(@PathVariable("com-id") String comId) {
					commentService.deleteComment(comId);
					 return new ResponseEntity <String>("Comment deleted !",HttpStatus.OK);
				}
				
				
				  @GetMapping("/comment/{idc}")
				    @ResponseBody
				    public Comment getCommentById(@PathVariable("idc") long idc) {
				        return commentService.getCommentById(idc);
				    }
}
