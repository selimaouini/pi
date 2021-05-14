package tn.pi.Controllers;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import tn.pi.entities.Post;
import tn.pi.entities.Rating;
import tn.pi.services.RatingService;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Scope(value = "session")
@Controller(value = "ratingController")
@ELBeanName(value = "ratingController")
public class ControllerRatingImpl {
		@Autowired 
		RatingService ratingService;
	
		private List<Rating> ratings;
	private int stars; 
	
	public void addRating() {
	//	if (authenticatedUser==null || !loggedIn) return "/login.xhtml";
		ratingService.addOrUpdateRating(new Rating(stars));
	//	return navigateTo;
	}

	public List<Rating> getRatings() {
		ratings = ratingService.retrieveAllRatings();
		return ratings;
	}

	public void displayRating(Rating r) {
	//	this.setStars(r.getStars());

	}
	
	
 public void onrate(Rating rating) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Rate Post", "You rated:" + rating.getStars());
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }

	    public void oncancel() {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancel Rate", "Rate Reset");
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	
	
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	
	
	
	/*
	 *  @RequestMapping(value="detail/{id}",method=RequestMedthod.GET)
	 * public String detail(@PathVariable("idP") long idP, ModelMap modelMap){
	 * Post post = postService.getById(idP);
	 * modelMap.put("post",post);
	 * Rating rating = new Rating();
	 * rating.SetPost(post);
	 * modelMap.put("rating",rating);
	 * return "post/detail";
	 * }
	 * 
	 * 
	 * 
	 * @RequestMapping(value="addRating",method=RequestMedthod.POST)
	 * public String addRating(@ModelAttribute("Rating") Rating rating, HttpSession session) {
	 * ratingService.addRating(Rating),
	 * return "redirect:/post/login";
	 * }
	 * 
	 ** @RequestMapping(value="addRating",method=RequestMedthod.POST) 
	 * public String sendRating(@ModelAttribute("Rating") Rating rating, 
	 * @RequestParam("hdrating") float hdrating HttpSession session) {
	 * String firstName = session.getAttribute("firstName");
	 * rating.setUser(user);
	 * }





*/
}
