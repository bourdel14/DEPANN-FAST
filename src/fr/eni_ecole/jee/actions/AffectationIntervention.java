package fr.eni_ecole.jee.actions;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import composant.entites.Intervention;
import composant.entites.Utilisateur;
import composant.sessions.GestionClient;
import composant.sessions.GestionIntervention;
import composant.sessions.GestionUtilisateur;

public class AffectationIntervention extends ActionSupport {
	
	private List<Utilisateur> users;
	private List<Intervention> interventions;
	
	public List<Utilisateur> getUsers() {
		return users;
	}

	public void setUsers(List<Utilisateur> users) {
		this.users = users;
	}

	public List<Intervention> getInterventions() {
		return interventions;
	}
	
	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}
	
	@Override
	public String execute() throws Exception {
		
		Context c = new InitialContext();
		GestionIntervention gestionIntervention = (GestionIntervention) c.lookup("ejb:/EJBDepannFast//GestionInterventionBean!composant.sessions.GestionIntervention");
		GestionUtilisateur gestionUser = (GestionUtilisateur) c.lookup("ejb:/EJBDepannFast//GestionUtilisateurBean!composant.sessions.GestionUtilisateur");
		
		this.interventions = gestionIntervention.findAll();
 		this.users = gestionUser.findByRole();
		
		return ActionSupport.SUCCESS;
	}	
	

}
