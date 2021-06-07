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
	 public long addOrUpdatePost(Post post) ;
	 public Post addPostt(Post p);
	 public String delete1(long idP);

	 //2éme méthode
	 public String save();
	 public Post getPost();
	 public String delete(long idP);
	 public String modifier(Post p, String title, String content, Theme theme);
	 public void loadData();
	 public List<Post> getPosts();
	 public String saveModif();

	/******** Crud ********/
	public List<Post> retrieveAllPosts();// done
	public String addPost(Post p, long id); // done
	public void updatePost(Post p); // done
	// Post getPostById(String idP); //done
	public	void deletePost(String idP); // done

	/******** Get By ********/
	public Post getPostById(long idP); //done
	public List<Post> getPostByUserId(Long id);
 	public List<Post> findPostbyUser(Long id);
 
	/******** Search ********/
	public List<Post> search(String word);//done

	/******** Filtre ********/
	public List<Post> retrievePostsByDateAsc(); // filtre by date asc done
	public List<Post> getAllPostsOrderedByDate(); // filtre by date desc done

	/******** Suppression automatique ********/
	public void deleteSansInteraction(); // not commented

	// void affectPostToUser(int id, int idP);

	/******** Post a la une ********/
	public List<String> PostMostCommented();

	/******** Partie Admin ********/
	public void accepterPost (Long idP);
	public void RefuserPost (Long idP);
	public List<Post> getAllPostEtatWaiting();
	public List<Post> getAllPostEtatAccepted();

	// public void uploadImage(final MultipartFile file);
}
