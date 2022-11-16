<%@ page language="java" 	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" 	tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
	<title>Login</title>
</head>
<body>
	<jsp:include page="./static/header.jsp" />

	<div class="container col-sm-4 col-offset-4 border border-secondary rounded p-4 mt-4 mb-4">
		<tags:mensagem />
		<h2 class="text-center mt-4">Login</h2>
		
		<form action="/login" method="post">
		  <div class="form-group mt-4 mb-4">
		    <label for="email">Email:</label>
		    <input type="email" id="email" class="form-control" placeholder="Entre com o seu e-mail" name="email">
		  </div>
		  <div class="form-group mb-4">
		    <label for="password">Senha:</label>
		    <input type="password" id="password" class="form-control" placeholder="Entre com a sua senha" name="senha">
		  </div>
		  <div class="form-group text-center mt-4 mb-4">
			<button type="submit" class="btn btn-primary col-sm-12">Entrar</button>
		  </div>
		</form>
		
	</div>
</body>
</html>