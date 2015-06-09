<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edition intervention</title>
</head>
<body>
<h2>Edition interventions</h2>

<h2>Fiche n°  <s:property value="%{interventionID}"/></h2>
<s:form action="saveIntervention" method="post">
<s:hidden name="interventionID" />
<s:textfield value="%{interventionNom}" name="interventionNom" label="Nom" />
<s:textarea value="%{interventionCommentaire}" name="interventionCommentaire" label="Commentaire" />
<s:textfield value="%{interventionPlanified_at}" name="interventionPlanified_at" label="Date de Planification" />
<tr>
	<td class="tdLabel">Statut</td>
	<td>
		<select name="interventionStatut">
			<option value="1">A Faire</option>
			<option value="2">En cours</option>
			<option value="3">Terminée</option>
		</select>
	</td>
</tr>
<s:submit value='Enregistrer' />
</s:form>




</body>
</html>