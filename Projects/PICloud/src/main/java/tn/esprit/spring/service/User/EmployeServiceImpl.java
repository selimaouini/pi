package tn.esprit.spring.service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User.Employe;
import tn.esprit.spring.repository.User.EmployeRepository;

@Service
public class EmployeServiceImpl implements IEmployeService {

	@Autowired
	EmployeRepository employeRepository;

	@Override
	public Employe authenticate(String login, String password) {
		return employeRepository.getEmployeByEmailAndPassword(login, password);
	}

	@Override
	public int addOrUpdateEmploye(Employe employe) {
		employeRepository.save(employe);
		return employe.getId();
	}

	@Override
	public List<Employe> getAllEmployes() {
		return (List<Employe>) employeRepository.findAll();
	}

	public void deleteEmployeById(int employeId) {
		employeRepository.deleteById((long) employeId);
	}
	////////////////// RestController/////////////////////



	@Override
	public Employe updateUser(Employe u) {
		employeRepository.save(u);
		return u;
	}

	@Override
	public Employe retrieveUser(int userId) {
		employeRepository.findById((long) userId);
		return null;
	}


	//////////////////////////////////

}
