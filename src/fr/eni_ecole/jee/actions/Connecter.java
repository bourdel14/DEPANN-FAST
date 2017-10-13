package fr.eni_ecole.jee.actions;

import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import composant.entites.Utilisateur;
import composant.sessions.GestionUtilisateur;


public class Connecter extends ActionSupport {

	private String nom;
	private String prenom;
	private String role;
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

	@Override
	public String execute() throws Exception {

		Context c = new InitialContext();
		GestionUtilisateur gestionUtilisateur = (GestionUtilisateur) c
				.lookup("ejb:/EJBDepannFast//GestionUtilisateurBean!composant.sessions.GestionUtilisateur");

		Utilisateur user = new Utilisateur();

		user = gestionUtilisateur.connexion(nom, mdp);

		if (user != null) {

			// on renseigne la session
			SessionMap session = (SessionMap) ActionContext.getContext().getSession();
			session.put("estConnecte", "true");
			session.put("User", user);

			System.out.println(user.getRole());

			return ActionSupport.SUCCESS;
		} else {
			return ActionSupport.INPUT;
		}

	}

	
}
