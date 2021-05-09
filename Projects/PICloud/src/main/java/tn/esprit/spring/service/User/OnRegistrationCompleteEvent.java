package tn.esprit.spring.service.User;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import tn.esprit.spring.entities.User.Employe;


public class OnRegistrationCompleteEvent extends ApplicationEvent {
    private String appUrl;
    private Locale locale;
    private Employe user;
 
    public OnRegistrationCompleteEvent(
    		Employe user, Locale locale, String appUrl) {
        super(user);
         
        this.user = user;
        this.locale = locale;
        this.appUrl = appUrl;
    }
    
    public OnRegistrationCompleteEvent(
    		Employe user, String appUrl) {
    	        super(user);
    	         
    	        this.user = user;
    	        this.appUrl = appUrl;
    	    }

	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public Employe getUser() {
		return user;
	}

	public void setUser(Employe user) {
		this.user = user;
	}
    
    
     
}
