<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="../layouts/header.xhtml" />
<jsp:include page="../layouts/nav.xhtml" />
<body>
<h2>Bienvenue <s:property value="session.login"/> du côté de l'administration</h2>
<div id="accordion" >
<h3>Liste des interventions</h3>
<div>
 	<s:a action="../editIntervention" style="color:blue !important;">Ajouter une intervention</s:a><br><br>
 	<table border="2px">
 		<tr>
 			<th>N° d'intervention</th>
 			<th>Date planifiée</th>
 			<th>Date de réalisation</th>
 			<th>Statut</th>
 			<th>Commentaire</th>
 			<th>Intervenant(s)</th>
 			<th colspan="2">Actions</th>
 		</tr>
	   	<s:iterator value="interventions">
			<tr>
				<td><s:property value="numIntervention"/></td>
				<td><s:property value="datePlanifiee"/></td>
				<td><s:property value="dateRealisation"/></td>
				<td><s:property value="statut"/></td>
				<td><s:property value="commentaire"/></td>
				<td>
					<s:iterator value="intervenants">
						<s:property value="nom"/> - 
					</s:iterator>
				</td>
				<td><%-- <s:a action="editIntervenant/%{id}">Modifier</s:a> --%></td>
				<td>
					<form action="deleteIntervenant" method="post">
						<s:hidden name="idIntervenant" value="%{id}" />
						<input type="submit" value="Supprimer" />
					</form>
				</td>
			</tr>
		</s:iterator>
 	</table>
</div>
<h3>Liste des intervenants</h3>
<div>
 	<s:a action="editIntervenant" style="color:blue !important;">Ajouter un intervenant</s:a><br><br>
 	<table border="2px">
 		<tr>
 			<th>Nom</th>
 			<th>Prenom</th>
 			<th>Groupe(s)</th>
 			<th colspan="2">Actions</th>
 		</tr>
	   	<s:iterator value="intervenants">
			<tr>
				<td><s:property value="nom"/></td>
				<td><s:property value="prenom"/></td>
				<td>
					<s:iterator value="groupes">
						<s:property value="libelle"/> - 
					</s:iterator>
				</td>
				<td><s:a action="editIntervenant/%{id}">Modifier</s:a></td>
				<td>
					<form action="deleteIntervenant" method="post">
						<s:hidden name="idIntervenant" value="%{id}" />
						<input type="submit" value="Supprimer" />
					</form>
				</td>
			</tr>
		</s:iterator>
 	</table>
</div>
<h3>Liste des groupes</h3>
<div>
 	<s:a action="editGroupe" style="color:blue !important;">Ajouter un groupe</s:a><br><br>
 	<table border="2px">
 		<tr>
 			<th>Libellé</th>
 			<th>Intervenant(s)</th>
 			<th colspan="2">Actions</th>
 		</tr>
	   	<s:iterator value="groupes">
			<tr>
				<td><s:property value="libelle"/></td>
				<td>
					<s:iterator value="intervenants">
						<s:property value="nom"/> - 
					</s:iterator>
				</td>
				<td><s:a action="editGroupe/%{id}">Modifier</s:a></td>
				<td>
					<form action="deleteGroupe" method="post">
						<s:hidden name="idGroupe" value="%{id}" />
						<input type="submit" value="Supprimer" />
					</form>
				</td>
			</tr>
		</s:iterator>
 	</table>
</div>
<h3>Liste des matériels</h3>
<div>
  	<s:a action="editMateriel" style="color:blue !important;">Ajouter un matériel</s:a><br><br>
  	<table border="2px">
  		<tr>
  			<th>N° de série</th>
  			<th>Type</th>
  			<th>Emplacement</th>
  			<th colspan="2">Actions</th>
  		</tr>
	    <s:iterator value="materiels">
			<tr>
				<td><s:property value="numSerie"/></td>
				<td><s:property value="typeIntervention"/></td>
				<td>
					<s:property value="salle.numSalle"/> - <s:property value="salle.etage.numEtage"/> -
					<s:property value="salle.etage.batiment.numBat"/> - <s:property value="salle.etage.batiment.site.numSite"/>
				</td>
				<td><s:a action="editMateriel/%{id}">Modifier</s:a></td>
				<td>
					<form action="deleteMateriel" method="post">
						<s:hidden name="idMateriel" value="%{id}" />
						<input type="submit" value="Supprimer" />
					</form>
				</td>
			</tr>
		</s:iterator>
  	</table>
</div>
<h3>Liste des clients</h3>
<div>
 	<s:a action="editClient" style="color:blue !important;">Ajouter un client</s:a><br><br>
 	<table border="2px">
 		<tr>
 			<th>Nom du client</th>
 			<th>Email client</th>
 			<th colspan="2">Actions</th>
 		</tr>
	   	<s:iterator value="clients">
			<tr>
				<td><s:property value="nom"/></td>
				<td><s:property value="email"/></td>
				<td><s:a action="editClient/%{id}">Modifier</s:a></td>
				<td>
					<form action="deleteClient" method="post">
						<s:hidden name="idClient" value="%{id}" />
						<input type="submit" value="Supprimer" />
					</form>
				</td>
			</tr>
		</s:iterator>
 	</table>
</div>
<h3>Liste des sites</h3>
<div>
 	<s:a action="editSite" style="color:blue !important;">Ajouter un site</s:a><br><br>
 	<table border="2px">
 		<tr>
 			<th>N° du site</th>
 			<th>Client(s)</th>
 			<th colspan="2">Actions</th>
 		</tr>
	   	<s:iterator value="sites">
			<tr>
				<td><s:property value="numSite"/></td>
				<td>
					<s:iterator value="clients">
						<s:property value="nom"/> - 
					</s:iterator>
				</td>
				<td><s:a action="editSite/%{id}">Modifier</s:a></td>
				<td>
					<form action="deleteSite" method="post">
						<s:hidden name="idSite" value="%{id}" />
						<input type="submit" value="Supprimer" />
					</form>
				</td>
			</tr>
		</s:iterator>
 	</table>
</div>
<h3>Liste des bâtiments</h3>
<div>
 	<s:a action="editBatiment" style="color:blue !important;">Ajouter un bâtiment</s:a><br><br>
 	<table border="2px">
 		<tr>
 			<th>N° bâtiment</th>
 			<th>Site</th>
 			<th colspan="2">Actions</th>
 		</tr>
	   	<s:iterator value="batiments">
			<tr>
				<td><s:property value="numBat"/></td>
				<td><s:property value="site.numSite"/></td>
				<td><s:a action="editBatiment/%{id}">Modifier</s:a></td>
				<td>
					<form action="deleteBatiment" method="post">
						<s:hidden name="idBatiment" value="%{id}" />
						<input type="submit" value="Supprimer" />
					</form>
				</td>
			</tr>
		</s:iterator>
 	</table>
</div>
<h3>Liste des étages</h3>
<div>
 	<s:a action="editEtage" style="color:blue !important;">Ajouter un étage</s:a><br><br>
 	<table border="2px">
 		<tr>
 			<th>N° d'étage</th>
 			<th>Bâtiment</th>
 			<th colspan="2">Actions</th>
 		</tr>
	   	<s:iterator value="etages">
			<tr>
				<td><s:property value="numEtage"/></td>
				<td><s:property value="batiment.numBat"/></td>
				<td><s:a action="editEtage/%{id}">Modifier</s:a></td>
				<td>
					<form action="deleteEtage" method="post">
						<s:hidden name="idEtage" value="%{id}" />
						<input type="submit" value="Supprimer" />
					</form>
				</td>
			</tr>
		</s:iterator>
 	</table>
</div>
<h3>Liste des salles</h3>
<div>
 	<s:a action="editSalle" style="color:blue !important;">Ajouter une salle</s:a><br><br>
 	<table border="2px">
 		<tr>
 			<th>N° de salle</th>
 			<th>Etage</th>
 			<th colspan="2">Actions</th>
 		</tr>
	   	<s:iterator value="salles">
			<tr>
				<td><s:property value="numSalle"/></td>
				<td><s:property value="etage.numEtage"/></td>
				<td><s:a action="editSalle/%{id}">Modifier</s:a></td>
				<td>
					<form action="deleteSalle" method="post">
						<s:hidden name="idSalle" value="%{id}" />
						<input type="submit" value="Supprimer" />
					</form>
				</td>
			</tr>
		</s:iterator>
 	</table>
</div>
</div>
<jsp:include page="../layouts/footer.xhtml" />