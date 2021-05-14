package tn.pi.services;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import tn.pi.entities.Post;
import tn.pi.entities.Theme;
import tn.pi.entities.User;

public interface PostService {
	
	/******** jsf ********/
	 public String save(Post p);
	 public Post getPost();
	 public String delete(long idP);
	 public String modifier(Post p, String title, String content,String photo, Theme theme);
	 public void loadData();
	 public List<Post> getPosts();
	 public String saveModif();

	 public void deleteP(long idP);
	public Post addPostt(Post p);
	/******** Crud ********/
	List<Post> retrieveAllPosts();// done

	String addPost(Post p, long id); // done

	void updatePost(Post p); // done
	// Post getPostById(String idP); //done

	void deletePost(String idP); // done

	/******** Get By ********/
	Post getPostById(long idP); //done

	public List<Post> getPostByUserId(Long id);

	/******** Search ********/

	public List<Post> search(String word);//done

	/******** Filtre ********/

	List<Post> retrievePostsByDateAsc(); // filtre by date asc done

	List<Post> getAllPostsOrderedByDate(); // filtre by date desc done

	/******** Suppression automatique ********/
	void deleteSansInteraction(); // not commented

	// void affectPostToUser(int id, int idP);

	/******** Post a la une ********/
	List<String> PostMostCommented();

	
	// public void uploadImage(final MultipartFile file);
}
