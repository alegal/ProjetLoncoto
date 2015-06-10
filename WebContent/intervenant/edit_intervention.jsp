<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="../layouts/header.xhtml" />
<jsp:include page="../layouts/nav.xhtml" />
<body>

<h2>Modification de l'intervention <s:property value="%{numIntervention}"/></h2>

<s:form action="saveIntervention" method="post">
<s:hidden name="interventionID" />
<s:textfield value="%{numIntervention}" name="numIntervention" label="N° d'intervention " />
<s:textarea value="%{comIntervention}" name="comIntervention" label="Commentaire " />
<s:textfield value="%{datePlanifieeIntervention}" name="datePlanifieeIntervention" label="Date Planifiée " />
<tr>
	<td class="tdLabel">Statut</td>
	<td>
		<select name="statutIntervention">
			<option value="1">A réaliser</option>
			<option value="2">En cours</option>
			<option value="3">Terminée</option>
		</select>
	</td>
</tr>
<s:submit value='Enregistrer' />
</s:form>


<jsp:include page="../layouts/footer.xhtml" />