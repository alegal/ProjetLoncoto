<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Détails des interventions</title>
</head>
<body>
<h2>Détails de l'intervention <s:property value="%{numIntervention}"/></h2>

<table>
	<tr>
		<td align="right">Numéro d'intervention : </td>
		<td><s:property value="numIntervention" /></td>
	</tr>
	<tr>
		<td align="right">Statut : </td>
		<s:if test="statutIntervention==1"><td bgcolor="red"><font style="color:white;font-weight:bold">A réaliser</font></td></s:if>
		<s:elseif test="statutIntervention==2"><td bgcolor="yellow">En cours</td></s:elseif>
		<s:else><td bgcolor="green"><font style="color:white">Terminée</font></td></s:else>
	</tr>
	<tr>
		<td align="right">Commentaire</td>
		<td><s:property value="comIntervention"/></td>
	</tr>
	<tr>
		<td align="right">Date de réalisation</td>
		<td><s:property value="dateRealisationIntervention"/></td>
	</tr>
	<tr>
		<td align="right">Date planifiée</td>
		<td><s:property value="datePlanifieeIntervention"/></td>
	</tr>
	<tr>
		<td align="right">Ajout d'informations complémentaires</td>
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