package fr.eni_ecole.jee.actions;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import composant.entites.Intervention;
import composant.enums.Etat;
import composant.sessions.GestionIntervention;
import composant.sessions.GestionUtilisateur;

public class ValiderAffecterIntervention extends ActionSupport implements ServletRequestAware {

	private String result = "Validation d'une affectation";
	private int intervention;
	private int user;
	private int urgence;
	private HttpServletRequest request;
	private String action;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getIntervention() {
		return intervention;
	}

	public void setIntervention(int intervention) {
		this.intervention = intervention;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getUrgence() {
		return urgence;
	}

	public void setUrgence(int urgence) {
		this.urgence = urgence;
	}

	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.request = req;

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
		GestionUtilisateur gestionUser= (GestionUtilisateur) c
				.lookup("ejb:/EJBDepannFast//GestionUtilisateurBean!composant.sessions.GestionUtilisateur");

		if ("Affecter".equals(action)) {
			Intervention intervention = gestionIntervention.findById(this.intervention);
			intervention.setUrgence(urgence);
			intervention.setEtat(Etat.AFFECTEE);
			intervention.setUser(gestionUser.findById(user));
			intervention = gestionIntervention.update(intervention);
			System.out.println(intervention);

			this.addActionMessage("Affectation d'une intervention réussie");
		} else if ("Annuler".equals(action)){
			gestionIntervention.delete(this.intervention);
			this.addActionMessage("Suppression d'une intervention réussie");
		}
		return ActionSupport.SUCCESS;
	}

	@Override
	public void validate() {
		if (this.user == 0) {
			this.addFieldError("depanneur", this.getText("valider.erreur.depanneur"));
		}
	}

}
