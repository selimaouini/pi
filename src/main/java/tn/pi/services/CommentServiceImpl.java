package tn.pi.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.pi.Repository.CommentRepository;
import tn.pi.Repository.LikesRepository;
import tn.pi.Repository.PostRepository;
import tn.pi.Repository.UserRepository;
import tn.pi.entities.Comment;
import tn.pi.entities.Likes;
import tn.pi.entities.Post;
import tn.pi.entities.Theme;
import tn.pi.entities.User;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentRepository commentRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PostRepository postRepository;
	@Autowired
	LikesRepository likesRepository; 

	
	private Comment comment = new Comment();
	private List<Comment> comments;
	
	private static final Logger log = LogManager.getLogger(CommentServiceImpl.class);

	/******** JSF ********/
	/*@Override
	public Comment addOrUpdateComment(Comment comment) {
		commentRepository.save(comment);
		return comment;
	}
	
	@Override
	public void deleteCommentById(long idc) {
		commentRepository.deleteById(idc);

	}*/
	
	@Override
	public String save() {
		commentRepository.save(comment);
		comment = new Comment();
		return "/pages/post/detail.xhtml?faces-redirect=true";
		
	}
	
	@Override
	public Comment getComment() {
		return comment;
	}

	@Override
	public String delete(long idc) {
		Comment com = commentRepository.findById(idc).get();
		commentRepository.delete(com);
		return "/pages/post/detail.xhtml?faces-redirect=true";
	}


	@Override
	public String modifier(Comment com, String description) {
	comment= com;
			return "/pages/post/update-com.xhtml?faces-redirect=true";
	}
	
	
	@Override
	public void loadData() {
		comments = (List<Comment>) commentRepository.findAll();
		
	}

	@Override
	public List<Comment> getComments() {
		return comments;
	}

	@Override
	public String saveModif() {
		Comment com =commentRepository.findById(comment.getIdc()).get();
		com.setDescription(comment.getDescription());
		commentRepository.save(com);
		comment = new Comment();
		return "/pages/post/detail.xhtml?faces-redirect=true";
		
	}

	/******** Crud ********/
	@Override
	public List<Comment> retrieveAllComments() {
		List<Comment> comments = (List<Comment>) commentRepository.findAll();
		for (Comment comment : comments) {
			log.info("comment :" + comment);
		}
		return comments;
	}

	// ma temchich
	@Override
	public List<Comment> retrieveAllCommentsByPost(long idP) {
		/*
		 * List<Comment> comments= new ArrayList<Comment>();
		 * commentRepository.getAllByPost(idP).forEach(comment->comments.add(
		 * comment)); return comments;
		 */
		return null;
	}

	@Override
	public Comment getCommentById(long idc) {
		return commentRepository.findById(idc).orElse(null);
	}

	@Override
	public void addComment(Comment com, long id, long idP) {
		
		String words = com.getDescription();
		List<String> forbiddenWord = new ArrayList<String>();
		forbiddenWord.add("fuck");
		forbiddenWord.add("merde");
		forbiddenWord.add("connard");
		forbiddenWord.add("salop");
		forbiddenWord.add("bastard");
		forbiddenWord.add("bitch");

		if (forbiddenWord.contains(words)) {
			Post post = postRepository.findById(idP).get();
			User user = userRepository.findById(id).get();
			com.setUser(user);
			com.setPost(post);
			com.setDescription("***");
			com.setUsername(user.getFirstName()+" "+user.getLastName());
			// Date currentSqlDate= new Date (System.currentTimeMillis());
			// com.setDateCreation(currentSqlDate);
			commentRepository.save(com);
		} else {
			Post post = postRepository.findById(idP).get();
			User user = userRepository.findById(id).get();
			com.setPost(post);
			com.setUser(user);

			commentRepository.save(com);

		}

		// return com.getIdc();

		
	}

	@Override
	public void updateComment(Comment com) {
		Comment comment = commentRepository.findById(com.getIdc()).orElse(null);
		if (comment != null) {
			com.setDescription(com.getDescription());
			com.setUser(com.getUser());
			com.setPost(com.getPost());
			commentRepository.save(com);
		}
	}
	
	@Override
	public void deleteComment(String idc) {
		commentRepository.deleteById(Long.parseLong(idc));

	}

	@Override
	public void deleteForbiddenWords() {
		commentRepository.deleteForbiddenWords();

	}

	@Override
	public Comment affectCommentToPost(long idP, long idc) {
		Post p = postRepository.findById(idP).get();
		Comment com = commentRepository.findById(idc).get();
		com.setPost(p);
		commentRepository.save(com);
		return com;

	}

	@Override
	public long NombresCommentsByPost(long idP) {
		return Long.valueOf(commentRepository.getNombrecommentsByPost());

	}

	@Override
	public List<Comment> getAllCommentsByPostId(long idP) {
		/*
		 * List<Comment> comments = new ArrayList<Comment>();
		 * commentRepository.findAllByPostId(idP).forEach(comment ->
		 * comments.add(comment)); return comments;
		 */
		return 	commentRepository.getAllByPostId(idP);

	}
@Override
	 public void likeComment(long idc, long id, boolean liked) {
	        Likes l = likesRepository.getLikesByComAndUser(idc,id);
	        if (l!=null) {
	          //  if (l.isLiked()==liked)
	             //   likesRepository.deleteById(l.getIdL());
	         //   else {
	                l.setLiked(liked);
	                likesRepository.save(l);
	        //    }
	        } else {
	            User user = userRepository.findById(id).orElse(null);
	            Comment comment = commentRepository.findById(idc).orElse(null);
	            if (user!=null && comment!=null) {
	                l=new Likes();
	                l.setComment(comment);
	                l.setUser(user);
	                l.setLiked(liked);
	                l.setEtat("like");
	                likesRepository.save(l);
	            }
	        }
	    }

@Override
public void dislikeComment(long idc, long id, boolean disliked) {
       Likes l = likesRepository.getDislikesByComAndUser(idc,id);
       if (l!=null) {
         //  if (l.isLiked()==liked)
            //   likesRepository.deleteById(l.getIdL());
        //   else {
               l.setDisliked(disliked);
               likesRepository.save(l);
       //    }
       } else {
           User user = userRepository.findById(id).orElse(null);
           Comment comment = commentRepository.findById(idc).orElse(null);
           if (user!=null && comment!=null) {
               l=new Likes();
               l.setComment(comment);
               l.setUser(user);
               l.setEtat("dislike");
               l.setDisliked(disliked);
               likesRepository.save(l);
           }
       }
   }


}

/* 
 * 
 * 
 * @Override
 * 
 * public void affectCommentToUser(long id, long idc) { Comment com =
 * commentRepository.findById(idc).get(); User user =
 * userRepository.findById(id).get(); if(com !=null && user !=null) {
 * com.setUser(user); //user.getComments().add(com); userRepository.save(user);
 * }
 * 
 * 
 *
 */
