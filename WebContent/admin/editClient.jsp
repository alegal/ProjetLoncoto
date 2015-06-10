<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="../layouts/header-sub.xhtml" />
<jsp:include page="../layouts/nav.xhtml" />
<fieldset>
<legend><h3>Ajout/Modification d'un client</h3></legend>

<center>
<s:form action="saveClient" >
<s:hidden name="idClient"/>
<s:textfield name="nomClient" label="Nom" />
<s:textfield name="emailClient" label="Email"  />
<tr>
	<td class="tdLabel">Site(s)</td>
	<td>
		<select name="sitesClient" multiple="multiple" >
			<s:iterator value="sites" var="s">
				<s:if test="listSitesClient.contains(#s)">
					<option value="${id}" selected="selected"><s:property value="numSite"/></option>
				</s:if>
				<s:else>
					<option value="${id}"><s:property value="numSite"/></option>
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