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
	}

	
	@Override
	public Comment addComment(Comment com) {
		commentRepository.save(com);
		return com;
		
		// if(pos.getTitle()==null || pos.getTitle().isEmpty()) return "Fill the title !";
	}

	@Override
	public Comment updateComment(Comment com) {
		commentRepository.save(com);
		return com;
	}

	@Override
	public void deleteComment(String idc) {
		commentRepository.deleteById(Long.parseLong(idc));
		
	}

	@Override
	public void motInterdit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void affectCommentToUser(long idu, long idc) {
	/*	Comment com = commentRepository.findById(idc).get();
		User  user = userRepository.findById(idu).get();

		user.getComments().add(com);
		userRepository.save(user);	*/
		
	}

	
}
/*	public void affectCommentToUSer(long idu, long idc) {
		Comment com = commentRepository.findById(idc).get();
		User  user = userRepository.findById(idu).get();

	if(com !=null && user !=null) {
				com.setUser(user);
				commentRepository.save(com);			
		} 
	*/