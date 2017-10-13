<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Création dépanneur</title>
</head>
<body>

<fieldset>
<legend>Création d'un dépanneur</legend>

<s:form action="ValiderAjouterUtilisateur" method = "post">
	<s:textfield key="creation.utilisateur.nom" name="nom" id="nom" errorPosition="bottom"></s:textfield>
	<s:textfield key="creation.utilisateur.prenom" name="prenom" id="prenom" errorPosition="bottom"></s:textfield>
	<s:password key="creation.mdp" name="mdp" id="mdp"></s:password>
	<s:radio label="Role" name="role" list="#{'Depanneur':'DEPANNEUR','Collaborateur':'COLLABORATEUR'}" value="1" />
	<s:submit value = "Création"></s:submit>
</s:form>

</fieldset>

</body>
</html>