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
		<legend>Affectation Intervention</legend>
		<s:fielderror>
			<s:param value="%{'users'}" />
		</s:fielderror>
		<table style="width: 100%">
			<tr>
				<td>Id</td>
				<td>Demande</td>
				<td>Etat</td>
				<td>Nom</td>
				<td>Adresse</td>
				<td>Depanneur</td>
				<td>Urgence</td>
			</tr>
			<c:forEach items="${interventions}" var="intervention">
				<form action="ValiderAffecterIntervention" method="post">
				<input type="hidden" name="intervention" value="${intervention.id}" />
				<tr>
					<td>${intervention.id}</td>
					<td>${intervention.demande}</td>
					<td>${intervention.etat}</td>
					<td>${intervention.client.nom}</td>
					<td>${intervention.client.adresse}</td>
					<td><select name="depanneur">
							<option value="0"></option>
							<c:forEach items="${users}" var="user">
								<option value="${user.id}" ${user.nom == intervention.user.nom ? 'selected' : ''}>${user.nom}</option>
							</c:forEach>
					</select></td>
					<td><input name="urgence" value="${intervention.urgence}" /></td>
					<td><input type="submit" value="Affecter" name="action"/></td>
					<td><input type="submit" value="Annuler" name="action"/></td>
				</tr>
				</form>
			</c:forEach>
		</table>
	</fieldset>

</body>
</html>