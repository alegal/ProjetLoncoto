<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/"/>

<link rel="stylesheet" type="text/css" href="css/list.css"/>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/list.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.10.3.custom.js" ></script>
<title>Affichage des interventions</title>
</head>
<body>
<jsp:include page="/menu.html" />
<center>
<h3>Liste des interventions</h3>

<div class="right">
	<s:a action="deconnection">Deconnexion</s:a>
</div>
<div id="maincontent">

			<%-- <s:form action="search" method="POST" enctype="multipart/form-data">
			<table class="ui-responsive ">
               <thead>
                  <tr>
                  <th >STATUT</th>
                  <th >SITE</th>
                  <th >CLIENT</th>
                  <th >DATE DE CREATION</th>
                  </tr>
                  </thead>
                  <tbody>
                     <tr>
                      <td>
                      		<select name="lstStatut" id="lstStatut">
								<option selected="selected" value="-1">Faites votre choix</option>
								<option value="1">A FAIRE</option>
								<option value="2">EN COURS</option>
								<option value="3">TERMINE</option>
							</select>
                      </td>
                      <td><input type="text" id="tbSite" name="tbSite"  value="" />
                      <td><input type="text" id="tbClient" name="tbClient" value=""   /></td>
                      <td><input type="text" id="tbDate" name="tbDate" value=""   /></td>
                      <td> 
                          
                          <!-- 
                          <input type="submit" id="btn_search" value="OK" onclick="fct_search()" />
                           -->
                          <input type="button" id="btn_search" value="OK">
                          
                      </td>
                     </tr> 
                  </tbody>
              </table>
			</s:form> --%>
			<div id="divaffLstintervention">
				<s:if test="interV.size()>0">
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
							<s:if test="statut==1"><td bgcolor="red"><font style="color:white;font-weight:bold">A réaliser</font></td></s:if>
							<s:elseif test="statut==2"><td bgcolor="yellow">En cours</td></s:elseif>
							<s:else><td bgcolor="green"><font style="color:white">Terminée</font></td></s:else>
							
							<td><s:a action="edit/%{id}">Modifier</s:a></td>
							<td><s:a action="detailintervention/%{id}">Détails</s:a></td>
						</tr>
						
						</s:iterator>
					</table>
				</s:if>
				<s:else>
					Pas d'interventions.
				</s:else>
			</div>
</div>
</center>
</body>
</html>