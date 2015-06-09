<%@ taglib prefix="s" uri="/struts-tags" %>
<div id="divaffLstintervention">
					<table border="1">
					<tr>
						<th>N° d'intervention </th>
						<th>N° Matériel</th>
						<th>Commentaire</th>
						<th>Statut</th>
						<th colspan="2">Actions</th>
					</tr>
					
					<s:iterator value="interV">
					<tr>
					<td>
						<s:property value="numIntervention"/>
					</td>
					<td>
						<s:property value="materiel.numSerie"/>
					</td>
					<td>
						<s:property value="commentaire" />
					</td>
					<s:if test="statut==1"><td bgcolor="red"><font style="color:white;font-weight:bold">A réalise</font></td></s:if>
					<s:elseif test="statut==2"><td bgcolor="yellow">En cours</td></s:elseif>
					<s:else><td bgcolor="green"><font style="color:white">Terminée</font></td></s:else>
					<td>
						<s:property value="client.id"/>-<s:property value="client.nom"/>
					</td>
					<td><s:a action="edit/%{id}">Modification</s:a></td>
					<td><s:a action="detailmateriel/%{id}">Détails</s:a></td>
					</tr>
					</s:iterator>
					<!-- <tr>
						<td colspan="6"><span id="lk_retour"><s:a action="ListeIntervention">Retour</s:a></span></td>
					</tr>-->
					</table>
			</div>