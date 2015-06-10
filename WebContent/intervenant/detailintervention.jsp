<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="../layouts/header.xhtml" />
<jsp:include page="../layouts/nav.xhtml" />
<h2>D�tails de l'intervention <s:property value="%{numIntervention}"/></h2>

<table>
	<tr>
		<td align="right">Num�ro d'intervention : </td>
		<td><s:property value="numIntervention" /></td>
	</tr>
	<tr>
		<td align="right">Statut : </td>
		<s:if test="statutIntervention==1"><td bgcolor="red"><font style="color:white;font-weight:bold">A r�aliser</font></td></s:if>
		<s:elseif test="statutIntervention==2"><td bgcolor="yellow">En cours</td></s:elseif>
		<s:else><td bgcolor="green"><font style="color:white">Termin�e</font></td></s:else>
	</tr>
	<tr>
		<td align="right">Commentaire</td>
		<td><s:property value="comIntervention"/></td>
	</tr>
	<tr>
		<td align="right">Date de r�alisation</td>
		<td><s:property value="dateRealisationIntervention"/></td>
	</tr>
	<tr>
		<td align="right">Date planifi�e</td>
		<td><s:property value="datePlanifieeIntervention"/></td>
	</tr>
	<tr>
		<td align="right">Ajout d'informations compl�mentaires</td>
		<td>
				<form action="importerFichier" method="POST" enctype="multipart/form-data">
					<input type="file" name="fichierExcel" class="btn" /><br><br>
					<input type="submit" class="btn btn-success" Value="Importer"/>
				</form>
				<br><a href="#">T�l�charger les photos</a>
		</td>
	</tr>
	
</table>



<jsp:include page="../layouts/footer.xhtml" />