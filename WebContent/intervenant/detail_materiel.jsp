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
<title>Detail matériel</title>
</head>
<body>
<jsp:include page="/menu.html" />
<h3>Détail du matériel</h3>
<div id="maincontent">

			<div id="divaffLstintervention">
					<table border="1">
					<tr>
						<th>NOM</th>
                 		<th>SERIAL NUMBER</th>
                  		<th>CLIENT</th>
                  		<th>SITE</th>
                  		<th>SALLE</th>
						<th>&nbsp;</th>
					</tr>
					
					<s:iterator value="materiel">
					<tr>
					<td>
						<s:property value="nom"/></s>
					</td>
					<td>
						<s:property value="serialnumber"/>
					</td>
					<td>
						<s:property value="NAMECLIENT"/>
					</td>
					<td>
						<s:property value="site"/>
					</td>
					<td>
						<s:property value="salle"/>
					</td>
					
					</tr>
					
					</s:iterator>
					<tr><td colspan="5"><span id="lk_retour"><s:a action="EditIntervention">Retour</s:a></span></td></tr>
					</table>
			</div>
</div>
</body>
</html>