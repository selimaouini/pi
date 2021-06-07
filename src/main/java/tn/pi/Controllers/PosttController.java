package tn.pi.Controllers;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tn.pi.entities.Post;
import tn.pi.entities.Theme;
import tn.pi.services.PostService;

@Scope(value = "session")
@Component(value = "posttController")
@ELBeanName(value = "posttController")
// @Join(path = "/pages/post/list.jsf", to = "/pages/post/add-form.jsf")
public class PosttController implements IPostController {

	@Autowired
	PostService postService;

	// 2émé méthode
	@Override
	public String save() {
		return postService.save();
	}

	@Override
	public Post getPost() {
		return postService.getPost();
	}

	@Override
	public String delete(long idP) {
		return postService.delete1(idP);
	}
	
	@Override
	public String modifier(Post p, String title, String content, Theme theme) {
		return postService.modifier(p, p.getTitle(), p.getContent(), p.getTheme());
	}

	@Override
	public String saveModif() {
		return postService.saveModif();
	}

}
