package tn.pi.controllers;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import tn.pi.entities.Claim;

@Named
@RequestScoped
public class EditorView {

    private String text2;
   
    
    public String getText2() {
    	Claim cc=new Claim();
    	text2 =cc.getDescription();
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }
}
