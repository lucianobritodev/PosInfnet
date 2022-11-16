<%@ page language="java" 	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" 	tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html lang="pt">
<head>
	<meta charset="UTF-8">
	<title>Cadastro de Cliente</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>
<body>

	<jsp:include page="../static/header.jsp" />
	
	<div class="container col-sm-6 col-offset-3 mt-4 mb-4">
		<tags:mensagem />
		<h1 class="mb-4">Cadastro de Cliente</h1>
		<form:form action="/cliente/incluir" method="post" modelAttribute="cliente">
		  <div class="form-group mb-4">
		    <form:input type="hidden" id="id" class="form-control" placeholder="Entre com o seu nome" path="id" readonly="true" />
		  </div>
		  <div class="form-group mb-4">
		    <label for="nome">Nome:</label>
		    <form:input type="text" id="nome" class="form-control" placeholder="Entre com o seu nome" path="nome" />
		  </div>
		  <div class="form-group mb-4">
		    <label for="email">Email:</label>
		    <form:input type="email" id="email" class="form-control" placeholder="Entre com o seu e-mail" path="email" />
		  </div>
		  <div class="form-group mb-4">
		    <label for="cpf">CPF:</label>
		    <form:input type="text" id="cpf" class="form-control" placeholder="Entre com o seu CPF" path="cpf" />
		  </div>
		  <div class="row mb-4">
			<div class="d-flex flex-row-reverse">			
			  <button type="submit" class="btn btn-success">
			  	<c:if test="${ cliente.id gt 0 }">Salvar</c:if>
			  	<c:if test="${ cliente.id eq null }">Cadastrar</c:if>
			  </button>
			</div>		
		  </div>
		</form:form>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>