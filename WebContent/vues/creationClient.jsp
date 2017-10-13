<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Création client</title>
</head>
<body>

<fieldset>
<legend>Création d'un client</legend>

<s:form action="ValiderAjouterClient" method = "post">
	<s:textfield key="creation.client.nom" name="nom" id="nom" errorPosition="bottom"></s:textfield>
	<s:textfield key="creation.client.adresse" name="adresse" id="adresse" errorPosition="bottom"></s:textfield>
	<s:submit value = "Création"></s:submit>
</s:form>

</fieldset>

</body>
</html>