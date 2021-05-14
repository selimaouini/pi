package tn.pi.services;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.pi.Repository.UserRepository;
import tn.pi.entities.Post;
import tn.pi.entities.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired 
	UserRepository userRepository; 
	
	

	private static final Logger log = LogManager.getLogger(UserServiceImpl.class);

	@Override
	public List<User> retrieveUsersByDateSQL(Date date1, Date date2) {
		List<User> users = (List<User>)  userRepository.retrieveUsersByDateSQL (date1, date2); 
			for (User user : users )		{
				log.info ("user selected with SQL:" +user);
				}
		return users; 
	}
	
	
		@Override
		public List<User> retrieveUsersByDateJPQL(Date date1, Date date2) {
			List<User> users = (List<User>)  userRepository. retrieveUsersByDateJPQL (date1, date2); 
					for (User user : users )		{
						log.info ("user selected with JPQL:" +user);
						}
			return users; 
		}

	
	@Override
	public List<User> retrieveAllUsers() {
	List<User> users= (List<User>) userRepository.findAll();
		for (User user: users){
			log.info ("user :" +user);
				}
	return users; 		
	}

	@Override
	public User addUser(User u) {
		userRepository.save(u);
		return u;
	}

	@Override
	public User updateUser(User u) {
		userRepository.save(u);
		return u;
	}

	@Override
	public User retrieveUser(String id) {
		User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		log.info ("user :" +u);
		 return u ;
		 
	}

	@Override
	public void deleteUser(String id) {
		userRepository.deleteById(Long.parseLong(id));
		
	}
}
