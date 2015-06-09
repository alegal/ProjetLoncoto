<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edition intervenants</title>
</head>
<body>
<jsp:include page="/menu.html" />
<fieldset>
<legend><h3>Ajout/Modification</h3></legend>

<center>
<s:form action="save" >
<s:textfield name="nomIntervenant" label="Nom" />
<s:textfield name="prenomIntervenant" label="Prenom"  />
<s:textfield name="loginIntervenant" label="Login"  />
<s:textfield name="passIntervenant" label="Mot de passe"  />
<tr>
	<td class="tdLabel">Groupe</td>
	<td>
		<select name="groupeIntervenant" multiple="multiple" >
			<s:iterator value="groupes">
				<option value="${id}"><s:property value="status"/></option>
			</s:iterator>
		</select>
	</td>
</tr>
<s:submit />
</s:form>

</center>
</fieldset>
</body>
</html>