<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connexion</title>
</head>
<body>

<fieldset>
<legend>Connexion d'un client</legend>

<s:form action="ConnecterClient" method = "post">
	<s:textfield key="creation.client.nom" name="nom" id="nom"></s:textfield>
	<s:password key="creation.mdp" name="mdp" id="mdp" ></s:password>>
	<s:submit value = "Se connecter"></s:submit>
</s:form>

</fieldset>

</body>
</html>