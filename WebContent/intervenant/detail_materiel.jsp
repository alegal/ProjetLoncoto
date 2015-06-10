<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="../layouts/header.xhtml" />
<jsp:include page="../layouts/nav.xhtml" />
<body>

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
<jsp:include page="../layouts/footer.xhtml" />