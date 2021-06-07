package tn.pi.Controllers;


import java.util.List;


import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import tn.pi.entities.Post;
import tn.pi.services.PostService;


@Controller(value = "adminController")
@ELBeanName(value = "adminController")
@Join(path = "/validateposts", to = "/admin/validate-posts.jsf")

@Transactional
public class adminController {
	@Autowired
	PostService postService;
	
	public void acceptPost(long idP){
		postService.accpeterPost(idP);
	}
	
	public void refusPost(long idP)
	{
		postService.RefuserPost(idP);
	}
    
	public List<Post> getAllSujetEtatWaiting(){
		return postService.getAllPostEtatWaiting();
	}

}



	