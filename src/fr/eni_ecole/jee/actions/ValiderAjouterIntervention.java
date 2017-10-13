package fr.eni_ecole.jee.actions;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.opensymphony.xwork2.ActionSupport;

import composant.entites.Client;
import composant.entites.Intervention;
import composant.enums.Etat;
import composant.sessions.GestionClient;
import composant.sessions.GestionIntervention;

public class ValiderAjouterIntervention extends ActionSupport{
	
	private String result = "Validation de l'intervention";
	private int client;
	private String demande;
	private String date;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}


	public int getClient() {
		return client;
	}

	public void setClient(int client) {
		this.client = client;
	}

	public String getDemande() {
		return demande;
	}

	public void setDemande(String demande) {
		this.demande = demande;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String execute() throws Exception {
		
		Context c = new InitialContext();
		GestionClient gestionClient = (GestionClient) c.lookup("ejb:/EJBDepannFast//GestionClientBean!composant.sessions.GestionClient");
		GestionIntervention gestionIntervention = (GestionIntervention) c.lookup("ejb:/EJBDepannFast//GestionInterventionBean!composant.sessions.GestionIntervention");
		
		Intervention intervention = new Intervention();
		intervention.setClient(gestionClient.findById(client));
		intervention.setDemande(demande);
		intervention.setUrgence(3);		
		intervention.setEtat(Etat.NA);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		intervention.setDateEtat(sdf.parse(date));
		intervention = gestionIntervention.add(intervention);
		
		System.out.println(intervention);
		
		this.addActionMessage(getText("valider.intervention"));
		return ActionSupport.SUCCESS;
	}

	@Override
	public void validate() {

	}
	
	

}
