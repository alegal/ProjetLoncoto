<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edition des groupse</title>
</head>
<body>
<jsp:include page="/menu.html" />
<fieldset>
<legend><h3>Ajout/Modification d'un groupe</h3></legend>

<center>
<s:form action="saveGroupe" >
<s:hidden name="idGroupe" />
<s:textfield name="libelleGroupe" label="Libellé " />
<s:submit />
</s:form>

</center>
</fieldset>
</body>
</html>