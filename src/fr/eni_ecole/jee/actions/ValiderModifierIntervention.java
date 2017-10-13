package fr.eni_ecole.jee.actions;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import composant.entites.Intervention;
import composant.enums.Etat;
import composant.sessions.GestionClient;
import composant.sessions.GestionIntervention;

public class ValiderModifierIntervention extends ActionSupport {

	private String intervention;
	private String action;

	public String getIntervention() {
		return intervention;
	}

	public void setIntervention(String intervention) {
		this.intervention = intervention;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public String execute() throws Exception {

		Context c = new InitialContext();
		GestionIntervention gestionIntervention = (GestionIntervention) c
				.lookup("ejb:/EJBDepannFast//GestionInterventionBean!composant.sessions.GestionIntervention");
		
		Intervention intervention = gestionIntervention.findById(Integer.valueOf(this.intervention));
		if ("Accepter".equals(action)) {
			intervention.setEtat(Etat.ACCEPTEE);
		} else if ("Refuser".equals(action)) {
			intervention.setEtat(Etat.REFUS);
			intervention.setUser(null);
		} else if ("Terminer".equals(action)) {
			intervention.setEtat(Etat.TERMINEE);
		} else if ("Replanifier".equals(action)) {
			intervention.setEtat(Etat.REPLANIFIEE);
		}
		intervention = gestionIntervention.update(intervention);
		System.out.println(intervention);
		return ActionSupport.SUCCESS;
	}
	
	@Override
	public void validate() {

	}
}
