package tn.pi.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.pi.entities.RoleType;
import tn.pi.entities.User;
import tn.pi.repositories.UserRepository;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	UserRepository userRepository;
	
	

	@Override
	public List<User> retrieveAllUsers() {
		return (List<User>) userRepository.findAll() ;
	}

	@Override
	public User addUser(User u) {
		userRepository.save(u) ;
		return u; 
	
	}

	@Override
	public void deleteUser(String id) {
		userRepository.deleteById((int) Long.parseLong(id));
		
	}

	//@Override
	//public User updateUser(User u) {
		//userRepository.save(u) ;
		//return u;
	//}

	@Override
	public User retrieveUser(int id) {
		 userRepository.findById(id).get();
		return userRepository.findById(id).get() ;
	
}

	@Override
	public User authenticate(String login, String password) {
		return userRepository.getUserByEmailAndPassword(login, password);
	}
}
