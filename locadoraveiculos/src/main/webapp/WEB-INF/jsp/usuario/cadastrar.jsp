<%@ page language="java" 	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" 	tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html lang="pt">
<head>
	<meta charset="UTF-8">
	<title>Cadastro de Usuario</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>
<body>

	<jsp:include page="../static/header.jsp" />
	<tags:mensagem />
	
	<div class="container col-sm-8 col-offset-2 border border-secondary rounded p-4 mt-4 mb-4">
		<h1 class="mt-4 mb-4">Cadastro de Usuário</h1>
		<form:form action="/usuario/cep" method="post" modelAttribute="usuario">
			<div class="row align-items-center mb-4">		
			    <label for="cep" class="form-label">Busca por CEP:</label>
			    <div class="col-auto">
			      <form:input type="text" 
			      		 id="cep"
			      		 class="form-control"
			      		 maxlength="8"
			      		 pattern="[0-9]{8}$"
			      		 title="Somente 8 digitos numericos!"
			      		 placeholder="Busque endereço pelo CEP"
			      		 path="endereco.cepPesquisa" />
			    </div>
			    
			    <div class="col-auto">			     
					<button type="submit" class="btn btn-primary"><i class="bi bi-search"></i>&nbsp;Buscar</button>
			    </div>
			</div>
		</form:form>
		
		<form:form action="/usuario/salvar" method="post" modelAttribute="usuario">
			<div class="row border border-secondary rounded mb-4">
				  <div class="form-group mb-4">
				    <form:input type="hidden" id="id" class="form-control" path="id" readonly="true" />
				  </div>
				  <div class="form-group col-sm-12 mb-4">
				    <label for="nome" class="form-label">Nome:</label>
				    <form:input type="text" id="nome" class="form-control" placeholder="Entre com o seu nome" path="nome" />
				  </div>
				  <div class="form-group col-sm-6 mb-4">
				    <label for="email" class="form-label">Email:</label>
				    <form:input type="email" id="email" class="form-control" placeholder="Entre com o seu e-mail" path="email" />
				  </div>
				  
				  <div class="form-group col-sm-6 mb-4">
				    <label class="form-label" for="password">Senha:</label>
				    <div class="input-group mb-2">
				      <form:input type="password" class="form-control" id="password" placeholder="Entre com a sua senha" path="senha" readonly="true" />
				      <div class="input-group-prepend">
				      	 <button type="button" class="input-group-text" onclick="chagePassword()"><i id="iconPasswordField" class="bi bi-lock"></i></button>
				      </div>
				    </div>
				  </div>
			  </div>
			  
			  <jsp:include page="../endereco/endereco.jsp" />
		
			  <div class="row mb-4">
				<div class="d-flex">
				  <button type="reset" class="btn btn-secondary me-auto"><i class="bi bi-recycle"></i>&nbsp;Limpar</button>
				  <a  href="/usuario/listar" class="btn btn-secondary"><i class="bi bi-x-lg"></i>&nbsp;Cancelar</a>&nbsp;
				  <button type="submit" class="btn btn-success"><i class="bi bi-check-lg"></i>&nbsp;
				  	<c:if test="${ usuario.id gt 0 }">Salvar</c:if>
				  	<c:if test="${ usuario.id eq null }">Cadastrar</c:if>
				  </button>
				</div>	
			  </div>
		</form:form>
	</div>
	
	<tags:scripts />
	<script type="text/javascript">
		var idField = document.getElementById("id");
		var icon = document.getElementById("iconPasswordField");
		var passwordField = document.getElementById("password");
		var iconPasswordFieldLock = true;
		
		if(id.value == "") {
			icon.className = "bi bi-unlock"
			passwordField.removeAttribute("readOnly");
		}
		
		function chagePassword() {
			
			iconPasswordFieldLock = !iconPasswordFieldLock; 
			if(iconPasswordFieldLock) {
				icon.className = "bi bi-lock"
				passwordField.setAttribute("readOnly", true);
			} else {
				icon.className = "bi bi-unlock"
				passwordField.removeAttribute("readOnly");
				passwordField.focus();
			}
			
		}
	</script>
</body>
</html>