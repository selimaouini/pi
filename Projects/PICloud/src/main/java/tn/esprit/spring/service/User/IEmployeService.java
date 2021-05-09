package tn.esprit.spring.service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User.Employe;
import tn.esprit.spring.repository.User.EmployeRepository;

public interface IEmployeService {
	public Employe authenticate(String login, String password);

	public int addOrUpdateEmploye(Employe employe);

	public List<Employe> getAllEmployes();

	public void deleteEmployeById(int employeId);
	
	//List<Employe> retrieveAllUsers();

	Employe updateUser(Employe u);

	public Employe retrieveUser(int userId);

	


	}