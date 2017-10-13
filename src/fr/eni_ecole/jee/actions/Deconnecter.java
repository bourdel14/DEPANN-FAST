package fr.eni_ecole.jee.actions;

import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import composant.entites.Utilisateur;

public class Deconnecter extends ActionSupport {
	
	private SessionMap<String, Object> session; 

	public String execute() throws Exception {
		
		session =  (SessionMap) ActionContext.getContext().getSession();
		System.out.println(session);
		Utilisateur u = (Utilisateur) session.get("User");
		System.out.println(u.getId());
		if(session != null){
			session.invalidate();

		}	
		return SUCCESS;
	}

}
