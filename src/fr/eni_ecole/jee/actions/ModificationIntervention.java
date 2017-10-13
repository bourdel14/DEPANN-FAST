package fr.eni_ecole.jee.actions;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import composant.entites.Intervention;
import composant.entites.Utilisateur;
import composant.sessions.GestionIntervention;

public class ModificationIntervention extends ActionSupport{
	
	private SessionMap<String, Object> session; 
	
	private Intervention intervention;
	
	public Intervention getIntervention() {
		return intervention;
	}
	
	public void setIntervention(Intervention intervention) {
		this.intervention = intervention;
	}
	
	@Override
	public String execute() throws Exception {
		
		Context c = new InitialContext();
		GestionIntervention gestionIntervention = (GestionIntervention) c.lookup("ejb:/EJBDepannFast//GestionInterventionBean!composant.sessions.GestionIntervention");
		session =  (SessionMap) ActionContext.getContext().getSession();
		Utilisateur u = (Utilisateur) session.get("User");
		this.intervention = gestionIntervention.getCurrentIntervention(u.getId());
		// Si une intervention acceptée n'est pas trouvée on prend la prochaine affectée
		if(this.intervention.getId() == 0){
			this.intervention = gestionIntervention.getNext(u.getId());			
		}
		// S'il n'y a pas non plus d'interventions affectées
		if(this.intervention.getId() == 0){	
			this.addActionMessage("Aucune intervention");
		}
		
		return ActionSupport.SUCCESS;
	}	
	

}
