package tn.pi.services;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.pi.Repository.CommentRepository;
import tn.pi.Repository.LikesRepository;
import tn.pi.Repository.PostRepository;
import tn.pi.Repository.RatingRepository;
import tn.pi.entities.Post;


@Service
public class PostServiceImpl implements PostService {
	@Autowired 
	PostRepository postRepository; 
	
	@Autowired 
	CommentRepository commentRepository;
	
	@Autowired 
	RatingRepository ratingRepository;

	private static final Logger log = LogManager.getLogger(PostServiceImpl.class);

	@Override
	public List<Post> retrieveAllPosts() {
		List<Post> posts= (List<Post>) postRepository.findAll();
		for (Post post: posts){
			log.info ("post :" +post);
				}
	return posts; 		
	}

	@Override
	public Post addPost(Post pos) {
		postRepository.save(pos);
		return pos;
	}
	/*
	 * if(pos.getTitle()==null || pos.getTitle().isEmpty()) return "Fill the title !";
	 * if(pos.getDescription()==null || pos.getDescription().isEmpty()) return "Fill the description!";
	   if(pos.getPhoto()==null || pos.getPhoto().isEmpty()) pos.setPhoto("photo.jpg");
		
		//Test sujets redondants  
		//if(postRepository.findByTitle(pub.getTitle()).size()>5) return "there are 5 publications with this title so you can interact with them without publishing new one";
		

	    User user = use.findById(idUser).orElse(null);
	    if(user!=null) {
			pos.setPublicationUser(user);
			postRepository.save(pos);
			return " post Added Successfuly ! ";
	    }
		
		return "Failed Add";
	*/
	
	@Override
	public Post updatePost(Post pos) {
		postRepository.save(pos);
		return pos;
	}

	@Override
	public Post getPostById(String idP) {
		Post pos =  postRepository.findById(Long.parseLong(idP)).orElse(null);
		log.info ("post :" +pos);
		 return pos ;
	}
	
	
	
/*	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return employee;
	}*/
	
	@Override
	public void deletePost(String idP) {
		postRepository.deleteById(Long.parseLong(idP));
		
	}	

	@Override
	public void deleteSansInteraction(String idP) {
		// not commented post
/*	if {
	postRepository.deleteById(Long.parseLong(idP));
	}*/
	}

	@Override
	public void sujetRedondant() {
	//	postRepository.sujetRedondant(title);
		
	}

	@Override
	public Post getPostByTitle(String title) {
		Post pos = (Post) postRepository.getPostByTitle(title);	
		log.info ("post :" +title);
		return pos ;
	}
	
	@Override
	public Post getPostByTheme(String theme) {
	    Post pos = (Post) postRepository.getPostByTheme(theme);
		return pos;
	}

	@Override
	public List<Post> getPostByUser(long idu) {
		return null; 
		//return (List<Post>) postRepository.getPostByUser(idu);
	}

	@Override
	public List<Post> retrievePostsByDateAsc(Date dateCreation) {
		List<Post> posts = (List<Post>)  postRepository.retrievePostsByDateAsc (dateCreation); 
		for (Post post : posts )		{
			log.info ("the newest posts :" +post);
			}
		return posts; 
	}

	@Override
	public List<Post> retrievePostsByDateDesc(Date dateCreation) {
		List<Post> posts = (List<Post>)  postRepository.retrievePostsByDateDesc (dateCreation); 
		for (Post post : posts )		{
			log.info ("the oldest posts:" +post);
			}
		return posts; 
	}
	
	
	/*
	 * 
	 * 
	 * 
	 * 
	 */
	/*
	 @Override
	public Post getPostByName(String name) {
		/*List<Post> posts = (List<Post>)  postRepository.retrieveUserByName(name); 
		for (Post post : posts )	{
			log.info ("posts are written by:" +name);
			}
	return posts; 
	
	
	
	
	
	
	
		public void uploadImage(final MultipartFile file) throws IOException {
//        UUID imgGeneratedId = UUID.nameUUIDFromBytes(file.getBytes());
//        File convertFile = new File("src/main/frontend/src/assets/images/" + imgGeneratedId + file.getOriginalFilename());
//        Post foundPost = pubrep.findFirstByOrderByIdDesc();
//        foundPost.setImageUrl("./assets/images/" + imgGeneratedId + file.getOriginalFilename());
//        convertFile.createNewFile();
//        FileOutputStream fout = new FileOutputStream(convertFile);
//        fout.write(file.getBytes());
//        fout.close();
//        postRepository.save(foundPost);
//    }






	

	}*/
	
}
