package tn.pi.services;

import java.util.List;


import tn.pi.entities.User;

public interface IUserService {


		
		public User authenticate(String login, String password) ;
		
		List<User> retrieveAllUsers();
		User addUser(User u);
		void deleteUser(String id);
		//User updateUser(User u);
		User retrieveUser(int id);

	
	


}
