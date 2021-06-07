package tn.pi.Controllers;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import tn.pi.entities.Post;
import tn.pi.services.PostService;

@Controller(value = "ControllerValidatePost")
@ELBeanName(value = "ControllerValidatePost")
//@Join(path = "/validateposts", to = "/pages/admin/validate-posts.jsf")
@Transactional
public class ValidatePost {
	@Autowired
	PostService postService;
	
	private String a; 
	private Post postrec;

	public Post getPostrec() {
		return postrec;
	}

	public void setPostrec(Post postrec) {
		this.postrec = postrec;
	}

	public String findPostrec() {
		postrec = postService.getPostById(outcome());
		String navigatTo = "/pages/admin/postAdmin?faces-redirect=true&idsujet=" + outcome().toString();
		return navigatTo;
	}
	private long idP;
	public Post findPostrec1() {
		return postrec = postService.getPostById(idP);
	
	}

	private String getCountryFromJSF(FacesContext context) {
		Map<String, String> parameters = context.getExternalContext().getRequestParameterMap();
		return parameters.get("idP");
	}

	public Long outcome() {
		FacesContext context = FacesContext.getCurrentInstance();
		a = getCountryFromJSF(context);
		System.out.println(a);
		return Long.parseLong(a);

	}



	public String accptedPost(Long idP) {
		postService.accepterPost(idP);
		return "/pages/admin/validate-posts.jsf";
	}

	public void accptePost(long idP) {
		postService.accepterPost(idP);
	}

	public void refusePost(long idP) {
		postService.RefuserPost(idP);
	}

	public List<Post> getAllPostEtatWaiting() {
		return postService.getAllPostEtatWaiting();
	}

	public String refusePost(Long idP) {
		postService.RefuserPost(idP);
		return "/admin/validate-posts.jsf";
	}
}
