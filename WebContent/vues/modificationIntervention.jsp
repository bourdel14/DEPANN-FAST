<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Affectation Intervention</title>
</head>
<body>

	<fieldset>
		<legend>Modification d'intervention</legend>
		<s:actionmessage />
		<c:if test="${actionMessages.size()==0}">
		<table style="width: 100%">
			<tr>
				<td>Id</td>
				<td>Demande</td>
				<td>Etat</td>
				<td>Nom</td>
				<td>Adresse</td>
				<td>Depanneur</td>
				<td>Urgence</td>
				<td>Date</td>
			</tr>
						
			
			<form action="ValiderModifierIntervention" method="get">
				<input type="hidden" name="intervention" value="${intervention.id}" />
				<tr>
					<td>${intervention.id}</td>
					<td>${intervention.demande}</td>
					<td>${intervention.etat}</td>
					<td>${intervention.client.nom}</td>
					<td>${intervention.client.adresse}</td>
					<td>${intervention.user.nom}</td>
					<td>${intervention.urgence}</td>
					<td>${intervention.dateEtat}</td>
					<c:if test="${intervention.etat == 'AFFECTEE' }">
						<td><input type="submit" value="Accepter" name="action" /></td>
						<td><input type="submit" value="Refuser" name="action" /></td>
					</c:if>
					<c:if test="${intervention.etat == 'ACCEPTEE'}">
						<td><input type="submit" value="Terminer" name="action" /></td>
						<td><input type="submit" value="Replanifier" name="action" /></td>
					</c:if>
				</tr>
			</form>
		</table>
		</c:if>
	</fieldset>

</body>
</html>