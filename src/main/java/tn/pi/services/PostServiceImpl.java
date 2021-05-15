package tn.pi.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tn.pi.Repository.CommentRepository;
import tn.pi.Repository.PostRepository;
import tn.pi.Repository.RatingRepository;
import tn.pi.Repository.UserRepository;
import tn.pi.entities.Post;
import tn.pi.entities.Theme;
import tn.pi.entities.User;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	PostRepository postRepository;

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	RatingRepository ratingRepository;

	@Autowired
	UserRepository userRepository;

	private Post post = new Post();
	private List<Post> posts;

	private static final Logger log = LogManager.getLogger(PostServiceImpl.class);

	
	
	@Override
	public void deleteP(long idP) {
		postRepository.deleteById(idP);
		
	}
	/******** CRUD ********/

	@Override
	public List<Post> retrieveAllPosts() {
		List<Post> posts = (List<Post>) postRepository.findAll();
		for (Post post : posts) {
			log.info("post :" + post);
		}
		return posts;
	}

	@Override
	public Post addPostt(Post post) {
		postRepository.save(post);
		return post;
	}
	
	@Override
	public String addPost(Post p, long id) {
		// Post p = postRepository.findById(idP).get();
		String words = p.getContent();
		List<String> forbiddenWord = new ArrayList<String>();
		forbiddenWord.add("fuck");
		forbiddenWord.add("merde");
		forbiddenWord.add("connard");
		forbiddenWord.add("salop");
		forbiddenWord.add("bastard");
		forbiddenWord.add("bitch");

		if (forbiddenWord.contains(words)) {
			User user = userRepository.findById(id).get();
			p.setUser(user);
			// Test titres redondants
			if (postRepository.findByTitle(p.getTitle()).size() > 0)
				return "** Attention il y a un autre post avec ce titre **";
			// p.setTitle();
			p.setContent("***");
			p.setEtat("Waiting");
			p.setUsername(user.getFirstName()+" "+user.getLastName());
			// Date currentSqlDate= new Date (System.currentTimeMillis());
			// p.setDateCreation(currentSqlDate);
			postRepository.save(p);
			return "** Attention votre contenu sera masqué ** ";

		} else {

			// Date currentSqlDate= new Date (System.currentTimeMillis());
			// p.setDateCreation(currentSqlDate);
			postRepository.save(p);
			return "** Votre post a été ajoutée avec succès ** ";
		}

	}

	/*
	 * User user = userRepository.findById(id).orElse(null); if (user != null)
	 * { // Test titres redondants if
	 * (postRepository.findByTitle(p.getTitle()).size() > 0) return
	 * "** Il y a 2 publications avec ce titre **"; // String[] title =
	 * p.getTitle().replaceAll(" +", " ").split(" "); // forbidden words
	 * String[] forbiddenWords = getForbiddenWords().split(" "); String[]
	 * content = p.getContent().replaceAll(" +", " ").split(" "); // String[]
	 * theme=p.getTheme().replaceAll(" +", " ").split(" "); if (p.getPhoto() ==
	 * null || p.getPhoto().isEmpty()) p.setPhoto("postpic.jpg");
	 * 
	 * for (int i = 0; i < content.length; i++) { for (String forbiddenWord :
	 * forbiddenWords) { if
	 * (content[i].toLowerCase().contains(forbiddenWord.toLowerCase()))
	 * content[i] = content[i].replaceAll(".", "*"); } } //
	 * p.setTitle(String.join(" ", title)); p.setContent(String.join(" ",
	 * content)); // p.setTheme(String.join(" ", theme)); p.setUser(user); //
	 * p.setDateCreation(new Date()); postRepository.save(p); }
	 */

	@Override
	public void updatePost(Post p) {
		Post post = postRepository.findById(p.getIdP()).orElse(null);
		if (post != null) {
			p.setTitle(post.getTitle());
			p.setContent(post.getContent());
			p.setPhoto(post.getPhoto());
		//	p.setRating(post.getRating());
		    p.setTheme(post.getTheme());
		//	p.setDateCreation(post.getDateCreation());
			p.setPostdToBeUpdated(post.getPostdToBeUpdated());
			p.setUser(post.getUser());
			postRepository.save(p);
		}
	}

	
	public Post getPostById(long idP) {
		return postRepository.findById(idP).orElse(null);
	}

	@Override
	public void deletePost(String idP) {
		postRepository.deleteById(Long.parseLong(idP));
	}

	/******** Filtre ********/

	@Override
	public List<Post> getPostByUserId(Long id) {
		return (List<Post>) postRepository.getPostByUserId(id);
	}

	@Override
	public List<Post> retrievePostsByDateAsc() {
		List<Post> posts = (List<Post>) postRepository.getAllPostsOrderByDateByDateAsc();
		for (Post post : posts) {
			log.info("the oldest posts :" + post);
		}
		return posts;
	}

	@Override
	public List<Post> getAllPostsOrderedByDate() {
		return postRepository.getAllPostsOrderedByDate();
	}

	/******** Search ********/
	@Override
	public List<Post> search(String word) {
		return (List<Post>) postRepository.searchPost(word);
	}

	@Override
	public List<String> PostMostCommented() {
		return postRepository.getPostMostCommented();
	}

	@Override
	public void deleteSansInteraction() {
		postRepository.deleteSansInteraction();
		System.out.println("done");

	}

	@Override
	public String save(Post p) {
		postRepository.save(post);
		post = new Post();
		return "/list.xhtml?faces-redirect=true";

	}

	@Override
	public Post getPost() {
		return  post;
	}

	@Override
	public String delete(long idP) {
		Post p =postRepository.findById(idP).get();
		postRepository.delete(p);
		return "/list.xhtml?faces-redirect=true";

	}

	@Override
	public String modifier(Post p, String title, String content, String photo, Theme theme) {
		post=p;
		return "/update.xhtml?faces-redirect=true";

	}

	@Override
	public void loadData() {
		posts = (List<Post>) postRepository.findAll();
		
	}

	@Override
	public List<Post> getPosts() {
		return posts;
	}

	
	
	@Override
	public String saveModif() {
		Post p=postRepository.findById(post.getIdP()).get();
		p.setTitle(post.getTitle());
		p.setContent(post.getContent());
		p.setPhoto(post.getPhoto());
		p.setTheme(post.getTheme());
		postRepository.save(p);
		post = new Post();
		return "/list.xhtml?faces-redirect=true";

	}
	@Override
	public void accpeterPost(Long idP) {
		Post post=postRepository.findById(idP).get();
		post.setEtat("Accpted");
		postRepository.save(post);
		
	}
	@Override
	public void RefuserPost(Long idP) {
		Post post=postRepository.findById(idP).get();
		post.setEtat("Accpted");
		postRepository.save(post);
		
	}
	@Override
	public List<Post> getAllPostEtatWaiting() {
		return postRepository.findAllbyEtatWaiting();
	}

	/*
	 * public void uploadImage(final MultipartFile file) { // UUID
	 * imgGeneratedId = UUID.nameUUIDFromBytes(file.getBytes()); // File
	 * convertFile = new File("src/main/webapp/resources/images/" +
	 * imgGeneratedId + file.getOriginalFilename()); // Post foundPost =
	 * postRepository.findFirstByOrderByIdDesc(); //
	 * foundPost.setImageUrl("./assets/images/" + imgGeneratedId +
	 * file.getOriginalFilename()); // convertFile.createNewFile(); //
	 * FileOutputStream fout = new FileOutputStream(convertFile); //
	 * fout.write(file.getBytes()); // fout.close(); //
	 * postRepository.save(foundPost); }
	 */

}
