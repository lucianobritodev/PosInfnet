<%@ page language="java" 	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" 	tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html lang="pt">
<head>
	<meta charset="UTF-8">
	<title>Cadastro de Carreta</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>
<body>

	<jsp:include page="../static/header.jsp" />
	
	<div class="container col-sm-8 col-offset-2 border border-secondary rounded p-4 mt-4 mb-4">
		<tags:mensagem />
		<h1 class="mb-4">Cadastro de Carreta</h1>
		<form:form action="/carreta/incluir" method="post" modelAttribute="carreta">
		   <div class="row">
			  <div class="form-group mb-4">
			    <form:input type="hidden" id="id" class="form-control" placeholder="Entre com o seu nome" path="id" readonly="true" />
			  </div>
			  <div class="form-group mb-4">
			    <label for="nome">Nome:</label>
			    <form:input type="text" id="nome" class="form-control" placeholder="Entre com o seu nome" path="nome" />
			  </div>
		  	  <div class="form-group mb-4">
			    <label for="valor">Valor:</label>
			    <form:input type="number" id="valor" class="form-control" placeholder="Entre com o valor" path="valor" />
			  </div>
		  </div>
		  <div class="row">
			  <div class="form-group mb-4">
			    <label for="codigoChassi">Chassi:</label>
			    <form:input type="number" id="codigoChassi" class="form-control" placeholder="Entre com o número do chassi" path="codigoChassi" />
			  </div>
			  <div class="form-group mb-4">
			    <label for="capacidadeReboque">Capacidade:</label>
			    <form:input type="number" id="capacidadeReboque" class="form-control" placeholder="Entre com a capacidade máxima" path="capacidadeReboque" />
			  </div>
			  <div class="form-group mb-4">
			    <label for="cor">Cor:</label>
			    <form:input type="text" id="cor" class="form-control" placeholder="Entre com a cor" path="cor" />
			  </div>
		  </div>
		  <div class="row">
<%--  			  <div class="form-group mb-6">
				<label  class="control-label">Combustível:</label>
				<div class="form-search">
					<form:select path="combustivel.value" cssClass="form-control">
						<c:forEach var="com" items="${combustivel.getValues()}">
					         <form:option value="${com.value}">${com.name}</form:option>
					    </c:forEach>
					</form:select>
				</div> --%>
			  </div>
			  <div class="form-group mb-6">
			    <label for="motor">Motor:</label>
			    <form:input type="text" id="motor" class="form-control" placeholder="Entre com a descrição do motor" path="motor" />
			  </div>
			  <div class="row mb-4">
				<div class="d-flex flex-row-reverse">			
				  <button type="submit" class="btn btn-success">
				  	<c:if test="${ carreta.id gt 0 }">Salvar</c:if>
				  	<c:if test="${ carreta.id eq null }">Cadastrar</c:if>
				  </button>
				</div>		
		  	</div>
		</form:form>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>