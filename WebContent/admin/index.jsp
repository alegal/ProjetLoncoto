<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administration</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script>
/* $(function() {
    $( "#accordion" ).accordion({
      heightStyle: "content"
    });
  }); */
</script>
</head>
<body>
<jsp:include page="/menu.html"   />
<h2>Bienvenue <s:property value="session.login"/> du côté de l'administration</h2>
<div id="accordion" >
<%-- <s:a action="addIntervention" style="color:blue !important;">Ajouter une intervention</s:a><br><br> --%>
<h3>Liste des intervenants</h3>
  <div>
  	<s:a action="editIntervenant" style="color:blue !important;">Ajouter un intervenant</s:a><br><br>
  	<table border="2px">
  		<tr>
  			<th>Nom</th>
  			<th>Prenom</th>
  			<th>login</th>
  			<th>Actions</th>
  		</tr>
    <s:iterator value="intervenants">
	<tr>
		<td><s:property value="nom"/></td>
		<td><s:property value="prenom"/></td>
		<td><s:property value="login"/></td>
		<td><s:a action="editIntervenant/%{id}">Modifier</s:a></td>
	</tr>
	</s:iterator>
  	</table>
  </div>
<h3>Matériels</h3>
  <div>
    <s:iterator value="materiels">
	<tr>
	<td><s:property value="numSerie"/></td>
	<td><s:a action="editMateriel/%{id}"><s:property value="materiel"/></s:a></td>
	</tr>
	</s:iterator>
  </div>
<h3>Clients</h3>
  <div>
    <s:iterator value="clients">
	<tr>
	<td><s:a action="editClient/%{id}"><s:property value="client"/></s:a></td>
	</tr>
	</s:iterator>
  </div>

</div>
</body>
</html>