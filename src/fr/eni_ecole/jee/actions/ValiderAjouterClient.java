package fr.eni_ecole.jee.actions;



import javax.naming.Context;
import javax.naming.InitialContext;

import com.opensymphony.xwork2.ActionSupport;

import composant.entites.Client;
import composant.sessions.GestionClient;

public class ValiderAjouterClient extends ActionSupport{
	
	private String nom;
	private String adresse;
	private String result = "Validation du client";

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String execute() throws Exception {
		
		//@EJB(mappedName="java:global/EJBDepannFast/GestionClientBean!composant.sessions.GestionClient")
		//GestionClient gestionClient;
		//On va creer un nouveau client
		Context c = new InitialContext();
		GestionClient gestionClient = (GestionClient) c.lookup("ejb:/EJBDepannFast//GestionClientBean!composant.sessions.GestionClient");
		
		Client client = new Client();
		client.setAdresse(adresse);
		client.setNom(nom);
		
		client = gestionClient.add(client);
		
		System.out.println(client);
		
		this.addActionMessage(getText("valider.client", new String[]{nom}));
		return ActionSupport.SUCCESS;
	}

	@Override
	public void validate() {
		if(this.nom.length()<5)
		{
			this.addFieldError("nom", this.getText("valider.erreur.nom"));
		}
	}
	
	

}
