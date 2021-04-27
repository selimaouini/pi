package tn.pi.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.pi.Repository.CommentRepository;
import tn.pi.Repository.PostRepository;
import tn.pi.Repository.UserRepository;
import tn.pi.entities.Comment;
import tn.pi.entities.Post;
import tn.pi.entities.User;


@Service
public class CommentServiceImpl  implements CommentService {
	@Autowired 
	CommentRepository commentRepository; 
	
	@Autowired 
	UserRepository userRepository; 
	
	@Autowired 
	PostRepository postRepository; 
	
	private static final Logger log = LogManager.getLogger(CommentServiceImpl.class);

	
	@Override
	public List<Comment> retrieveAllComments() {
		List<Comment> comments= (List<Comment>) commentRepository.findAll();
		for (Comment comment : comments){
			log.info ("comment :" +comment);
				}
	return comments; 		
	}
	
	@Override
	public List<Comment> retrieveAllCommentsByPost(long idP) {
		return null;
	//	Post pos = postRepository.findById(idP).orElse(null);
		//return pos.getCommentList();
		// return postRepository.getAllPostsOrderedByDate(topicId);
	}


	@Override
	public Comment getCommentById(long idc) {
		   return commentRepository.findById(idc).orElse(null);
	}

	
	@Override
	public void addComment(Comment com, long idu, long idP) {
	        User user = userRepository.findById(idu).orElse(null);
	        Post post = postRepository.findById(idP).orElse(null);
	      /// if (user!=null && post!=null) {
	          //    String[] forbiddenWords=getForbiddenWords().split(" ");
		          String[] description=com.getDescription().replaceAll(" +", " ").split(" ");
		       //   for (int i=0;i<description.length;i++) {
	           //     for (String forbiddenWord : forbiddenWords) {
	             //       if (description[i].toLowerCase().contains(forbiddenWord.toLowerCase()))*/
	              //          description[i]=description[i].replaceAll(".", "*");*/
	         //       }
		//		}
	            com.setDescription(String.join(" ", description));
	            com.setUser(user);
	            //p.setDate(new Date());
	            commentRepository.save(com);
	     //   }
	    }

	  @Override
	public void updateComment(Comment com) {
        Comment comment = commentRepository.findById(com.getIdc()).orElse(null);
        if (comment!=null) {
            com.setLikes(com.getLikes());
            com.setDescription(comment.getDescription());
            com.setUser(com.getUser());
            //com.setDate(com.getDateCreation());
           	commentRepository.save(com);
        }
    }
    
	@Override
	public void deleteComment(String idc) {
		commentRepository.deleteById(Long.parseLong(idc));
		
	}


	

	@Override
	public void likeComment(long idc, long idu, long idL) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getForbiddenWords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setForbiddenWords(String words) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void motInterdit() {
		// TODO Auto-generated method stub
		
	}
	
}

/*	@Override
	public void affectCommentToUser(long idu, long idc) {
		Comment com = commentRepository.findById(idc).get();
		User  user = userRepository.findById(idu).get();
if(com !=null && user !=null) {
				com.setUser(user);
		//user.getComments().add(com);
		userRepository.save(user);		
	}
 * 
 * 
 *
	*/