<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>détail intervention</title>
</head>
<body>
<h2>détail interventions</h2>

<h2>Fiche n°  <s:property value="%{interventionID}"/></h2>
<table>
	<tr>
		<td align="right">Nom : </td>
		<td><s:property value="interventionNom" /></td>
	</tr>
	<tr>
		<td align="right">Statut : </td>
		<s:if test="interventionStatut==1"><td bgcolor="red"><font style="color:white;font-weight:bold">A FAIRE</font></td></s:if>
		<s:elseif test="interventionStatut==2"><td bgcolor="yellow">En cours</td></s:elseif>
		<s:else><td bgcolor="green"><font style="color:white">Terminée</font></td></s:else>
	</tr>
	<tr>
		<td align="right">Commentaire</td>
		<td><s:property value="interventionCommentaire"/></td>
	</tr>
	<tr>
		<td align="right">Date de création</td>
		<td><s:property value="interventionCreated_at"/></td>
	</tr>
	<tr>
		<td align="right">Date de planification</td>
		<td><s:property value="interventionPlanified_at"/></td>
	</tr>
	<tr>
		<td align="right">options</td>
		<td>
				<form action="importerFichier" method="POST" enctype="multipart/form-data">
					<input type="file" name="fichierExcel" class="btn" /><br><br>
					<input type="submit" class="btn btn-success" Value="Importer"/>
				</form>
				<br><a href="#">Télécharger les photos</a>
		</td>
	</tr>
	
</table>




</body>
</html>