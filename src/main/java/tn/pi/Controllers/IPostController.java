package tn.pi.Controllers;

import tn.pi.entities.Post;
import tn.pi.entities.Theme;

public interface IPostController {
		 public String save();
		 public Post getPost();
		 public String delete(long idP);
		 public String modifier(Post p, String title, String content, Theme theme );
		 public String saveModif();
}
