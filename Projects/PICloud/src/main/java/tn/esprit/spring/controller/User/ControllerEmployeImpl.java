package tn.esprit.spring.controller.User;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.Security.jwt.JwtUtils;
import tn.esprit.spring.Security.services.UserDetailsImpl;
import tn.esprit.spring.entities.User.Employe;
import tn.esprit.spring.entities.User.Role;
import tn.esprit.spring.repository.User.EmployeRepository;
import tn.esprit.spring.service.User.IEmployeService;


@Scope(value = "session")
@Controller(value = "employeController")
@ELBeanName(value = "employeController")
@Join(path = "/", to = "/login.jsf")
//@Transactional
//@Component
public class ControllerEmployeImpl {
	
	@Autowired
	IEmployeService employeService;
	
	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	EmployeRepository userRepository;
	
	private String login;
	private String password;
	private Employe employe;
	private Boolean loggedIn;
	private Employe authenticatedUser;
	private String prenom; 
	private String nom;
	private String username;
	private String email;
	private boolean actif; 
	private Set<Role> role;
	
 	static UserDetailsImpl userDetails;
 	private Authentication authentication;
	
	private List<Employe> employes;
	
	private Integer employeIdToBeUpdated;
	
	public List<Employe> getEmployes() {
		employes = employeService.getAllEmployes();
		return employes;
		}

	public void addEmploye() {
	employeService.addOrUpdateEmploye(new Employe(nom, prenom, email, password, actif, role));
	}
	
	public void removeEmploye(int employeId) {
		employeService.deleteEmployeById(employeId); 
	}
	
	//public Role[] getRoles() { return Role.values(); }
	
	public void displayEmploye(Employe empl)
	{
	this.setPrenom(empl.getPrenom());
	this.setNom(empl.getNom());
	this.setUsername(empl.getusername());
	this.setActif(empl.isActif());
	this.setEmail(empl.getEmail());
	this.setRole(empl.getRoles());
	this.setPassword(empl.getPassword());
	this.setEmployeIdToBeUpdated(empl.getId());
	}
	
	public void updateEmploye()
	{ employeService.addOrUpdateEmploye(new Employe(employeIdToBeUpdated, nom,
	prenom,username, email, password, actif, role)); }
	
	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public boolean isActif() {
		return actif;
	}



	public void setActif(boolean actif) {
		this.actif = actif;
	}


	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	public IEmployeService getEmployeService() {
		return employeService;
	}
	public void setEmployeService(IEmployeService employeService) {
		this.employeService = employeService;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Boolean getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Employe getAuthenticatedUser() {
		return authenticatedUser;
	}

	public void setAuthenticatedUser(Employe authenticatedUser) {
		this.authenticatedUser = authenticatedUser;
	}
	
	public Integer getEmployeIdToBeUpdated() {
		return employeIdToBeUpdated;
	}

	public void setEmployeIdToBeUpdated(Integer employeIdToBeUpdated) {
		this.employeIdToBeUpdated = employeIdToBeUpdated;
	}
	
	public Authentication getAuthentication() {
		return authentication;
	}

	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}

	public void onAuthenticationSuccess(HttpServletRequest request, 
    		HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        userDetails=(UserDetailsImpl) authentication.getPrincipal();
        System.out.println(userDetails.getUsername());
    }
	
	public UserDetailsImpl getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetailsImpl userDetails) {
		this.userDetails = userDetails;
	}
	
	

	public String doLogin() {
		
		String navigateTo = "null";
		try
		{
		 authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(login, password));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		userDetails = (UserDetailsImpl) authentication.getPrincipal();
		Employe U = userRepository.findByUsername(login)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + login));
		
System.out.println("Role"+U.getRoles().stream().findFirst().get().getId());
		if(authentication.isAuthenticated())
		{
			//if (!userDetails.getIsActif()) {
				//FacesMessage facesMessage =

					//	new FacesMessage("Error: Your account is Disabled by Admin!");

						//FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
		//	}
			
		/*	else if (!U.isEnabled()) {
				FacesMessage facesMessage =

						new FacesMessage("Please Confirm your Account, We've sent you a confirmation email");

						FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
			}  */
			 if(U.getRoles().stream().findFirst().get().getId()==1)
			{
				navigateTo = "/pages/admin/welcome.xhtml?faces-redirect=true";
			loggedIn = true; 
			}
		/*	else if(U.getRoles().stream().findFirst().get().getId()==2)
			{
				navigateTo = "Chart.xhtml?faces-redirect=true";
			loggedIn = true; 
			}
			else if(U.getRoles().stream().findFirst().get().getId()==4)
			{
				navigateTo = "LoginDeliveryController.xhtml?faces-redirect=true";
				userDetails=null;
				loggedIn = false; 
			}
			else
			{
				
			}
		*/	
		}
		}
		catch (BadCredentialsException badCredentialsException)  {
			FacesMessage facesMessage =

					new FacesMessage("Login Failed: please check your username/password and try again.");

					FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
		}
		catch (UsernameNotFoundException e) {
			FacesMessage facesMessage =

					new FacesMessage("Login Failed: please check your username/password and try again.");

					FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
		}	
		return navigateTo;
		}
	
	
/*	public String doLogin() {
		String navigateTo = "null";
		
		authenticatedUser=employeService.authenticate(login, password);
		
		if (authenticatedUser != null && authenticatedUser.getRoles().equals(ERole.ROLE_ADMIN) ){
			
		navigateTo = "/pages/admin/welcome.xhtml?faces-redirect=true";
		loggedIn = true; }
		else {
		FacesMessage facesMessage =
		new FacesMessage("Login Failed: please check your username/password and try again.");
		FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
		}
		return navigateTo;
		}
	*/
	//////////////////////////////
		public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.xhtml?faces-redirect=true";
		}
	
}