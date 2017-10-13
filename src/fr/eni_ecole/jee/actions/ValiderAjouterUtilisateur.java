package fr.eni_ecole.jee.actions;



import javax.naming.Context;
import javax.naming.InitialContext;

import com.opensymphony.xwork2.ActionSupport;

import composant.entites.Client;
import composant.entites.Utilisateur;
import composant.sessions.GestionClient;
import composant.sessions.GestionUtilisateur;

public class ValiderAjouterUtilisateur extends ActionSupport{
	
	private String nom;
	private String prenom;
	private String role;
	private String mdp;
	private String result = "Validation de l'utilisateur";

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String execute() throws Exception {
		
		Context c = new InitialContext();
		GestionUtilisateur gestionUser = (GestionUtilisateur) c.lookup("ejb:/EJBDepannFast//GestionUtilisateurBean!composant.sessions.GestionUtilisateur");
		
		Utilisateur user = new Utilisateur();
		user.setPrenom(prenom);
		user.setNom(nom);
		user.setRole(role);
		user.setMdp(mdp);
		
		user = gestionUser.add(user);
		
		System.out.println(user);
		
		this.addActionMessage(getText("valider.utilisateur", new String[]{nom,prenom}));
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
