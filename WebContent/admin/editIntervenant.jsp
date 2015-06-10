<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="../layouts/header.xhtml" />
<jsp:include page="../layouts/nav.xhtml" />
<fieldset>
<legend><h3>Ajout/Modification d'un intervenant</h3></legend>

<center>
<s:form action="save" >
<s:hidden name="idIntervenant" />
<s:textfield name="nomIntervenant" label="Nom " />
<s:textfield name="prenomIntervenant" label="Prenom "  />
<s:textfield name="loginIntervenant" label="Login "  />
<s:textfield name="mdpIntervenant" label="Mot de passe "  />
<tr>
	<td class="tdLabel">Groupe</td>
	<td>
		<select name="groupeIntervenant" multiple="multiple" >
			<s:iterator value="groupes" var="g">
				<s:if test="listGroupesIntervenant.contains(#g)">
					<option value="${id}" selected="selected"><s:property value="libelle"/></option>
				</s:if>
				<s:else>
					<option value="${id}"><s:property value="libelle"/></option>
				</s:else>
			</s:iterator>
		</select>
	</td>
</tr>
<s:submit />
</s:form>

</center>
</fieldset>
<jsp:include page="../layouts/footer.xhtml" />