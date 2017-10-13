<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Création d'une intervention</title>
</head>
<body>

	<fieldset>
		<legend>Création d'une intervention</legend>
		<s:form method="post" action="ValiderAjouterIntervention">
		<s:textfield key="creation.intervention.demande" name="demande" id="demande"></s:textfield>
		<s:property value="getText('creation.intervention.client')"/>
		<select name="client">
			<c:forEach items="${clients}" var="client">
				<option value ="${client.id}">${client.nom}</option>
			</c:forEach>
		</select>
		<br/>
		Date : <input type="date" name="date" value="2017-09-27"/>
		<s:submit value="Envoyer"/>
		</s:form>
	</fieldset>

</body>
</html>