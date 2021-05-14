package tn.pi.Controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.pi.Repository.PostRepository;
import tn.pi.Repository.UserRepository;
import tn.pi.entities.Post;
import tn.pi.entities.Theme;
import tn.pi.entities.User;
import tn.pi.services.PostService;
import tn.pi.services.UserService;

@Scope(value = "session")
@Controller(value = "postController")
@ELBeanName(value = "postController")
public class postController {

	@Autowired
	PostService postService;
	@Autowired
	PostRepository postRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserService userService;

	private List<Post> posts;
	private long idP;
	private String title;
	private String content;
	private String photo;
	private LocalDateTime dateCreation;
	@Enumerated(EnumType.STRING)
	private Theme theme;
	private Long postdToBeUpdated;
	private User user;
	long id=1; 
	private Post post;
	private Post p;
		
	public Post addPost(){		
		User u =userRepository.findById(id).get();
	Post post =new Post();
		post.setUser(u);
		post.setTitle(title);
		post.setContent(content);
		post.setPhoto(photo);
		post.setTheme(theme);
		return postService.addPostt(post);
				}
	
	public void deletePost(long idP){
		postService.deleteP(idP);
		addMessage(FacesMessage.SEVERITY_INFO, "Success", "Post deleted");
	}
	
	
	public void update(long idP){
	 postService.updatePost(p);
	  addMessage(FacesMessage.SEVERITY_INFO, "Success", "Post updated");
	
	}
	
	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
	     FacesContext.getCurrentInstance().
	             addMessage(null, new FacesMessage(severity, summary, detail));
	}
	
	 public List<Post> getPosts() {
	    	posts=postService.retrieveAllPosts();
	        return posts;
	    }
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public long getIdP() {
		return idP;
	}
	public void setIdP(long idP) {
		this.idP = idP;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public LocalDateTime getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Theme[] getThemes() { 
		return Theme.values(); 
		}
	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	public Long getPostdToBeUpdated() {
		return postdToBeUpdated;
	}
	public void setPostdToBeUpdated(Long postdToBeUpdated) {
		this.postdToBeUpdated = postdToBeUpdated;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	
	
}
