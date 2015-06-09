<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="css/list.css" />
<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/"/>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/jquery.formvalidation.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    $("#formConnect").formValidation({
        alias       : "name",
        required    : "accept",
        err_list    : true
    }); 

});
</script>
<title>Projet Loncoto</title>
</head>
<body>


<h2>Connexion</h2>
<form id="formConnect" action="userConnect" method="post">

Identifiant : <input required="true" type="text" value="" id="login" name="login" /><!-- <p class="error"></p> -->
<br/>
Mot de passe : <input required="true" type="password" value="" id="mdp" name="mdp" /><!-- <p class="error"></p> -->
<br/>
<s:submit value="Connexion" />
</form>

</body>
</html>