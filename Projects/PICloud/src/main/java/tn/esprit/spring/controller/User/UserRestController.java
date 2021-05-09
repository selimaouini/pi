package tn.esprit.spring.controller.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.User.Employe;
import tn.esprit.spring.service.User.IEmployeService;


@RestController
public class UserRestController {
	
	@Autowired
	IEmployeService userService;
	
	
	@GetMapping("/retrieve-all-users")
	@ResponseBody
	public List<Employe> getAllEmployes() {
	List<Employe> list = userService.getAllEmployes();
	return list;
	}
	
	
	// http://localhost:8083/retrieve-user/{user-id}
	
	@GetMapping("/retrieve-user/{user-id}")
	@ResponseBody
	public Employe retrieveUser(@PathVariable("user-id") int userId) {
	return userService.retrieveUser(userId);
	}

	
/*	
	// http://localhost:8083/add-user
	
	@PostMapping("/add-user")
	@ResponseBody
	public Employe addUser(@RequestBody Employe u) {
		Employe user = userService.addUser(u);
	return user;
	}
	*/
	
	
	// http://localhost:8083/remove-user/{user-id}
	@DeleteMapping("/remove-user/{user-id}")
	@ResponseBody
	public void removeUser(@PathVariable("user-id") int employeId) {
	userService.deleteEmployeById(employeId);
	}

	
	// http://localhost:8083/modify-user
	@PutMapping("/modify-user")
	@ResponseBody
	public Employe modifyUser(@RequestBody Employe user) {
	return userService.updateUser(user);
	}

}
