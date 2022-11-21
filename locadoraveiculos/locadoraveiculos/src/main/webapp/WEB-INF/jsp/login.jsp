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
	<tags:mensagem />
	
	<div class="container col-sm-4 col-offset-4 border border-secondary rounded mt-4 mb-4">
		<h2 class="text-center mt-4">Login</h2>
		
		<form action="/login" method="post">
			<div class="form-group mb-4">
			  <label for="email">Email:</label>
			  <input type="email" id="email" class="form-control" placeholder="Entre com o seu e-mail" name="email">
			</div>
			<div class="form-group mb-4">
				<label for="password">Senha:</label>
				<input type="password" id="password" class="form-control" placeholder="Entre com a sua senha" name="senha">
			</div>
			
		    <div class="row mb-4">
				<div class="col d-flex justify-content-center">
				  <div class="form-check">
				    <input class="form-check-input" type="checkbox" value="" id="remember-password" />
				    <label class="form-check-label" for="remember-password"> Relembre-me</label>
				  </div>
				</div>
				
				<div class="col d-flex justify-content-center">
				    <a href="#!">Esqueceu a senha?</a>
				</div>
			</div>
			
			<div class="form-group text-center mb-4">
				<button type="submit" class="btn btn-primary col-sm-8">Entrar</button>
			</div>
			
			<div class="text-center mb-4">
			  <p>Não sou usuário? <a href="/usuario/cadastrar">Cadastre-se</a></p>
			</div>
		</form>
		
	</div>
	<tags:scripts />
</body>
</html>