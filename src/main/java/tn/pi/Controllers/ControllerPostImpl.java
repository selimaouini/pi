package tn.pi.Controllers;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.pi.entities.Post;
import tn.pi.entities.Theme;
import tn.pi.services.PostService;

@Scope(value = "session")
@Controller(value = "postController")
@ELBeanName(value = "postController")
@Join(path = "/", to = "/forum.jsf")
public class ControllerPostImpl {
	@Autowired 
	PostService postService;
	
	private List<Post> posts;

	private String title;
	private String content;
	private String photo;
	//private Date dateCreation;
	private Theme theme;
	private Long postdToBeUpdated;
	
	
	public void addPost() {
postService.addOrUpdatePost(new Post(title, content, photo, theme));
}
	
public List<Post> getPosts() {
posts = postService.retrieveAllPosts();
return posts;
}
	
		public void removePost(long idP){
	postService.deletePostById(idP);
		}

	
	public void displayPost(Post p) {
this.setTitle(p.getTitle());
this.setContent(p.getContent());
this.setPhoto(p.getPhoto());
this.setTheme(p.getTheme());
this.setPostdToBeUpdated(p.getIdP());
}


public void updatePost(){ 
	postService.addOrUpdatePost(new Post( title, content, photo, theme,postdToBeUpdated)); 
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

		public Theme getTheme() {
			return theme;
		}

		public void setTheme(Theme theme) {
			this.theme = theme;
		}

		public Long getPostdToBeUpdated() {
			return postdToBeUpdated;
		}

		public void setPostdToBeUpdated(long l) {
			this.postdToBeUpdated = l;
		}

		public void setPosts(List<Post> posts) {
			this.posts = posts;
		}
	
	
	

}
