package tn.pi.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.pi.Repository.CommentRepository;
import tn.pi.entities.Comment;




@Service
public class CommentServiceImpl  implements CommentService {
	@Autowired 
	CommentRepository commentRepository; 
	
	private static final Logger log = LogManager.getLogger(CommentServiceImpl.class);

	@Override
	public List<Comment> retrieveAllCommentsByPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment addComment(Comment com) {
		commentRepository.save(com);
		return com;
	}

	@Override
	public Comment updateComment(Comment com) {
		commentRepository.save(com);
		return com;
	}

	@Override
	public void deleteComment(String idC) {
		commentRepository.deleteById(Long.parseLong(idC));
		
	}

	@Override
	public void motInterdit() {
		// TODO Auto-generated method stub
		
	}

}





	

	