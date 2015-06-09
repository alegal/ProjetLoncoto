<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Projet Loncoto</title>
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
<link type="text/css" rel="stylesheet" href="css/app.css"  media="screen,projection"/>
</head>
<body id="body-id">
      <div class="row container-log container">
        <div class="col s12 m6 block-log">
          <div class="card">

            <div class="card-content">
            LOGIN
            <div class="row">
	            <form class="col m12" id="formConnect" action="userConnect" method="post">
					<div class="row">
				        <div class="input-field col s12">
				        <i class="mdi-image-timer-auto prefix"></i>
				          <input required="true" type="text" value="" id="login" name="login" />
				          <label for="login">Login</label>
				        </div>
				        
				        <div class="input-field col s12">
				        <i class="mdi-action-lock prefix"></i>
				          <input required="true" type="password" value="" id="mdp" name="mdp" />
				          <label for="mdp">Password</label>
				        </div>				        
					</div>

			</div>
            </div>

            <div class="card-action">
            	<s:submit value="Connexion" class="waves-effect waves-light btn col m12 blue lighter-2" />

            </div>
            </form>
          </div>
        </div>
      </div>



      <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      <script type="text/javascript" src="js/materialize.min.js"></script>
</body>
</html>