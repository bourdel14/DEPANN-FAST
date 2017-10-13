<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>
</head>
<body>
	<h1>Bienvenue sur le site Dépann'Fast</h1>

	<s:if test='#session.estConnecte == "true" '>
		<span><s:property value="#session.User.nom" /></span>
		<s:if test="#session.User.role == 'Depanneur'">
			<br />
			<a href="modificationIntervention">Accès interventions</a>
			<br />
		</s:if>

		<s:elseif test="#session.User.role == 'Collaborateur'">
			<a href="creationClient">Création clients</a>
			<br />
			<a href="creationUser">Création Utilisateur</a>
			<br />
			<a href="creationIntervention">Création interventions</a>
			<br />
			<a href="affectationIntervention">Affectation interventions</a>
		</s:elseif>
		<a href="Deconnecter">Deconnexion</a>
	</s:if>
	<c:if test="${actionMessages.size()>0}">
		<fieldset>
			<legend>
				<s:property value="result" />
			</legend>
			<ul>
				<s:actionmessage />
			</ul>
		</fieldset>

	</c:if>
	<s:elseif test="{#session.estConnecteClient == 'true'">
		Client
	</s:elseif>
	<s:elseif test="{#session.estConnecte == 'false'} ">
		<a href="connexion">Connexion Utilisateur</a><br>
		<a href="connexionClient">Connexion Client</a>
	<br />
	</s:elseif>
	

</body>
</html>