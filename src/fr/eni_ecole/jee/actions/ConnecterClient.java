package fr.eni_ecole.jee.actions;

import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import composant.entites.Client;
import composant.sessions.GestionClient;

public class ConnecterClient extends ActionSupport {

	private String nom;
	private String prenom;
	private String adresse;
	private String mdp;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	@Override
	public String execute() throws Exception {

		Context c = new InitialContext();
		GestionClient gestionClient = (GestionClient) c
				.lookup("ejb:/EJBDepannFast/GestionClientBean!composant.sessions.GestionClient");

		Client client = new Client();

		client = gestionClient.connexion(nom, mdp);

		if (client != null) {

			// on renseigne la session
			SessionMap session = (SessionMap) ActionContext.getContext().getSession();
			session.put("estConnecteClient", "true");
			session.put("Client", client);

			System.out.println(client.getId());

			return ActionSupport.SUCCESS;
		} else {
			return ActionSupport.INPUT;
		}

	}

	
}
