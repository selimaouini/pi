package tn.pi.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.pi.Repository.CommentRepository;
import tn.pi.Repository.LikesRepository;
import tn.pi.Repository.UserRepository;
import tn.pi.entities.Comment;
import tn.pi.entities.Likes;
import tn.pi.entities.Post;
import tn.pi.entities.User;

@Service
public class LikesServiceImpl implements LikesService {

	@Autowired
	LikesRepository likesRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	CommentRepository commentRepository;

	private static final Logger log = LogManager.getLogger(LikesServiceImpl.class);

	/******** JSF ********/
	@Override
	public long addOrUpdateLikes(Likes likes) {
		likesRepository.save(likes);
		return likes.getIdL();
	}
	@Override
	public void deleteLikesById(long idL) {
		likesRepository.deleteById(idL);

	}
	
	/****** Crud ******/
	
	@Override
	public List<Likes> retrieveAllLikes() {
		List<Likes> likess = (List<Likes>) likesRepository.findAll();
		for (Likes likes : likess) {
			log.info("likes :" + likes);
		}
		return likess;
	}

	@Override
	public Likes getLikeById(long idL) {
		return likesRepository.findById(idL).orElse(null);
	}

	@Override
	public void deleteLike(String idL) {
		likesRepository.deleteById(Long.parseLong(idL));
	}

	@Override
	public void deleteDislike(String idL) {
		likesRepository.deleteById(Long.parseLong(idL));
	}

	@Override
	public int getAllNbrLikesByCom(long idc) {
		return likesRepository.getAllNbrLikesByCom(idc);
	}

	
	@Override
	public int getAllNbrDislikeByCom(long idc) {
		return likesRepository.getAllNbrDisLikesByCom(idc);
	}

	@Override
	public Likes getByComAndUser(long idc, long id) {
		return likesRepository.getLikesByComAndUser(idc, id);
	}

	@Override
	public List<Likes> getAllLikesByCom(String etat) {
		return (List<Likes>) likesRepository.getAllLikesByCom(etat);
	}


}
