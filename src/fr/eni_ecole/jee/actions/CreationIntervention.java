package fr.eni_ecole.jee.actions;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.opensymphony.xwork2.ActionSupport;

import composant.entites.Client;
import composant.entites.Utilisateur;
import composant.sessions.GestionClient;
import composant.sessions.GestionUtilisateur;

public class CreationIntervention extends ActionSupport{
	
	private List<Client> clients;
	private List<Utilisateur> users;
	
	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<Utilisateur> getUsers() {
		return users;
	}

	public void setUsers(List<Utilisateur> users) {
		this.users = users;
	}

	@Override
	public String execute() throws Exception {
		
		Context c = new InitialContext();
		GestionClient gestionClient = (GestionClient) c.lookup("ejb:/EJBDepannFast//GestionClientBean!composant.sessions.GestionClient");
		GestionUtilisateur gestionUser= (GestionUtilisateur) c.lookup("ejb:/EJBDepannFast//GestionUtilisateurBean!composant.sessions.GestionUtilisateur");
		
		this.clients = gestionClient.findAll();
		this.users = gestionUser.findAll();
		
		return ActionSupport.SUCCESS;
	}

	@Override
	public void validate() {

	}
	
	

}
