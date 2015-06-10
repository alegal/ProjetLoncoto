<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="../layouts/header-sub.xhtml" />
<jsp:include page="../layouts/nav.xhtml" />

<fieldset>
<legend><h3>Ajout/Modification de batiment</h3></legend>

<center>
<s:form action="saveClient" >
<s:hidden name="idClient"/>
<s:textfield name="nomClient" label="Nom" />
<s:textfield name="prenomClient" label="Prenom"  />
<tr>
	<td class="tdLabel">Site</td>
	<td>
<%-- 		<s:property value="sitesClientBDD.size()"/> --%>
		<select name="sitesClient" multiple="multiple" >
			<s:iterator value="sites" var="s">
				<s:if test="sitesClientBDD.contains( #s)">
					<option value="${id}" selected="selected"><s:property value="nom"/></option>
				</s:if>
				<s:else>
					<option value="${id}"><s:property value="nom"/></option>
				</s:else>
			</s:iterator>
		</select>
	</td>
</tr>

<tr>
	<td class="tdLabel">Matériel</td>
	<td>
		<s:property value="materielsClientBDD.size()"/>
		<select name="materielsClient" multiple="multiple" >
			<s:iterator value="materiels" var="m">
				<s:if test="materielsClientBDD.contains( #m)">
					<option value="${id}" selected="selected"><s:property value="nom"/></option>
				</s:if>
				<s:else>
					<option value="${id}"><s:property value="nom"/></option>
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