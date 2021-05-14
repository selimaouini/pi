package tn.pi.services;

import java.util.Date;
import java.util.List;

import tn.pi.entities.User;


public interface UserService {
	List<User> retrieveUsersByDateSQL(Date date1, Date date2);
	List<User> retrieveUsersByDateJPQL(Date date1, Date date2);
	List<User> retrieveAllUsers();
	User addUser(User u);
	User updateUser(User u);
	User retrieveUser(String id);
	void deleteUser(String id);


}
