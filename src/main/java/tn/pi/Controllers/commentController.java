package tn.pi.Controllers;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.pi.Repository.CommentRepository;
import tn.pi.Repository.PostRepository;
import tn.pi.Repository.UserRepository;
import tn.pi.entities.Comment;
import tn.pi.entities.Likes;
import tn.pi.entities.Post;
import tn.pi.entities.User;
import tn.pi.services.CommentService;
import tn.pi.services.PostService;
import tn.pi.services.UserService;

@Scope(value = "session")
@Controller(value = "commentController")
@ELBeanName(value = "commentController")
// @Join(path = "/detail", to = "/detail.jsf")
public class commentController {
	@Autowired
	CommentService commentService;
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserService userService;
	@Autowired
	PostService postService;
	@Autowired
	PostRepository postRepository;

	private String description;
	private List<Comment> comments;
	// long idP=23;
	long idc;
	long id = 1;
	private Comment comment;
	boolean disliked;
	boolean liked;

	/*** 1er méthode ***/
	public void saveComment() {
		commentService.addOrUpdateComment(new Comment(description));
	}

	/*** 2éme méthode ***/
	public void addComment(long idP) {
		Comment com = new Comment();
		User u = userRepository.findById(id).get();
		Post p = postRepository.findById(idP).get();

		com.setUser(u);
		com.setPost(p);
		com.setDescription(description);
		commentService.addComment(com, id, idP);
	}

	public List<Comment> getComments() {
		comments = commentService.retrieveAllComments();
		return comments;
	}

	public void removeComment(long idP) {
		commentService.deleteCommentById(idP);
		addMessage(FacesMessage.SEVERITY_INFO, "Success", "Comment deleted");
	}

	public void updateComment() {
		commentService.addOrUpdateComment(new Comment(description));
	}

	List<Comment> retrieveAllCommentsByPost(long idP) {
		comments = commentService.retrieveAllCommentsByPost(idP);
		return comments;
	}

	public void dislike(long idc) {
		Likes l = new Likes();
		User u = userRepository.findById(id).get();
		l.setDisliked(disliked);
		l.setUser(u);
		commentService.dislikeComment(idc, id, disliked);
	}

	public void like(long idc) {
		Likes l = new Likes();
		User u = userRepository.findById(id).get();
		l.setUser(u);
		l.setLiked(liked);
		commentService.likeComment(idc, id, disliked);
	}

	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	/*
	 * public long getIdP() { return idP; }
	 * 
	 * public void setIdP(long idP) { this.idP = idP; }
	 */

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

}
