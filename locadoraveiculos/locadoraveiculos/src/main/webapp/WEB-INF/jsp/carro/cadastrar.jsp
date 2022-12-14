<%@ page language="java" 	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" 	tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html lang="pt">
<head>
	<meta charset="UTF-8">
	<title>Cadastro de Carro</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>
<body>

	<jsp:include page="../static/header.jsp" />
	<tags:mensagem />
	
	<div class="container col-sm-8 col-offset-2 border border-secondary rounded p-4 mt-4 mb-4">
		<h1 class="mb-4">Cadastro de Carro</h1>
		<form:form action="/carro/salvar" method="post" modelAttribute="carro" >
		   <div class="row">
			  <div class="form-group mb-4">
			    <form:input type="hidden" id="id" class="form-control" placeholder="Entre com o seu nome" path="id" readonly="true" />
			  </div>
			  <div class="form-group mb-4 col-sm-8">
			    <label class="form-label" for="nome">Nome:</label>
			    <form:input type="text" id="nome" class="form-control" placeholder="Entre com o seu nome" path="nome" minlength="3" required="true" />
			  </div>
			  <div class="form-group mb-4 col-sm-4">
			    <label class="form-label" for="codigoChassi">Chassi:</label>
			    <form:input 
			    	type="text" 
			    	id="codigoChassi" 
			    	class="form-control" 
			    	placeholder="Entre com o número do chassi" 
			    	title="Digite o número do Chassi com 7 dígitos no máximo!"
			    	path="codigoChassi" 
			    	minlength="4"
			    	maxlength="7"
			    	pattern="[0-9]{4,7}$" 
			    	required="true" />
			  </div>
		  </div>
		  
		  <div class="row">
		  	  <div class="col-sm-6 mb-4">
				<label class="form-label" id="valor-label" for="valor">Valor:</label>
				<div class="d-flex">
			  	  <div class="form-group col me-auto">
				    <form:input type="range" id="valor" class="form-control" placeholder="Entre com o valor" min="50.00" max="1000.00" step="50.00" path="valor" required="true" onchange="printValor()"  />
				  </div>
				</div>
			  </div>
			  
			  <div class="form-group mb-4 col-sm-3">
			    <label class="form-label" for="assentos">Assentos:</label>
			    <form:input type="number" id="assentos" class="form-control" placeholder="Entre com a quantidade de assentos" path="assentos" value="2" min="2" required="true" />
			  </div>
			  
			  <div class="col d-flex justify-content-center">
			    <div class="form-check">
			      <form:checkbox id="assentos" class="form-form-check-input" placeholder="Entre com a quantidade de assentos" path="direcaoHidraulica" />
		    	  <label class="form-check-label" for="assentos">Direcao Hidraulica:</label>
			    </div>
			  </div>
		  </div>
		  
		  <div class="row">
			<div class="form-group mb-4 col-sm-4">
			  <label class="form-label" for="cor">Cor:</label>
			  <form:input type="text" id="cor" class="form-control" placeholder="Entre com a cor" path="cor" minlength="4" required="true" />
			</div>
			
 			<div class="form-group mb-4 col-sm-4">
			  <label class="form-label">Combustível:</label>
				<form:select path="combustivel" class="form-select" required="true" >
				  <form:option value="">Selecione</form:option>
				  <c:forEach var="com" items="${ combustivelLista }">
				    <form:option value="${ com }">${ com }</form:option>
				  </c:forEach>
				</form:select>
			</div>
			
			<div class="form-group mb-4 col-sm-4">
			  <label class="form-label" for="motor">Motor:</label>
			  <form:input type="text" id="motor" class="form-control" placeholder="Entre com a descrição do motor" path="motor" minlength="2" required="true" />
			</div>
		  </div>
		  
		  <div class="row mb-4">
			<div class="d-flex">
			  <button type="reset" class="btn btn-secondary me-auto"><i class="bi bi-recycle"></i>&nbsp;Limpar</button>
			  <a  href="/carro/listar" class="btn btn-secondary"><i class="bi bi-x-lg"></i>&nbsp;Cancelar</a>&nbsp;
			  <button type="submit" class="btn btn-success"><i class="bi bi-check-lg"></i>&nbsp;
			  	<c:if test="${ carro.id gt 0 }">Salvar</c:if>
			  	<c:if test="${ carro.id eq null }">Cadastrar</c:if>
			  </button>
			</div>	
		  </div>
		</form:form>
	</div>
	<script type="text/javascript">
		function printValor() {
			var valor = document.getElementById("valor");
			var valorOutput = document.getElementById("valor-label");
			valorOutput.textContent = "Valor: R$ " + valor.value + ",00";
			console.log(valor.value);
		}
		
		printValor();
	</script>
	<tags:scripts />
</body>
</html>