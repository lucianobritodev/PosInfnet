<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html lang="pt">
<head>
<meta charset="UTF-8">
<title>Cadastro de Reserva</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>
<body>

	<jsp:include page="../static/header.jsp" />
	<tags:mensagem />

	<div
		class="container col-sm-8 col-offset-2 border border-secondary rounded p-4 mt-4 mb-4">
		<h1 class="mt-4 mb-4">Cadastro de Reserva</h1>
		<form:form action="/reserva/salvar" method="post"
			modelAttribute="reserva">
			<div class="row mb-4">
				<div class="form-group mb-4">
					<form:input type="hidden" id="id" class="form-control" path="id"
						readonly="true" />
				</div>
				<div class="form-group mb-4">
					<form:input type="hidden" id="user" class="form-control" value="${ user }" path="usuario"
						readonly="true" />
				</div>
				<div class="form-group col-sm-4">
					<label class="form-label" for="dataReserva">Data:</label>
					<form:input type="datetime-local" id="dataReserva"
						class="form-control" path="dataReserva" requered="true"
						pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}$" />
				</div>

				<div class="form-group col-sm-4">
					<label class="form-label" for="dias">Dias Reservados:</label>
					<form:input type="number" id="dias" class="form-control"
						path="diasReservados" min="1" requered="true" />
				</div>
				<div class="form-group col-sm-4">
					<label class="form-label" for="status">Status:</label>
					<form:select id="status" path="status" class="form-select"
						required="true">
						<form:option value="">Selecione</form:option>
						<c:forEach var="item" items="${ statusList }">
							<form:option value="${ item }" />
						</c:forEach>
					</form:select>
				</div>
			</div>

			<div class="row">
			    <div class="col-sm-12 mb-4">
				    <div class="form-group">
					  <label for="lista-funcoes" class="form-label">Veiculos</label>
					  <div class="input-group mb-2 col-sm-12">
					    <!-- <input list="veiculos" type="text"  id="input-veiculo" class="form-control form-select" placeholder="Escolha o(s) veículo(s)" style="cursor:default" onchange="habilitaBotaoAdicionar()" /> -->
						<select  id="input-veiculo" class="form-control form-select" onchange="habilitaBotaoAdicionar()">
						  <option value="P1">Pastor Local</option>
						  <option>Teste</option>
						  <option>Discipulador</option>
						  <option>Líder de Célula</option>
						  <option>Líder de Célula em Teinamento</option>
						  <option>Líder de Louvor</option>
						  <option>Anfitrião de Célula</option>
						  <option>Administrador de Sistemas</option>
						  <option>Músico Intrumentista</option>
						  <option>Músico Vocal</option>
						  <option>Tesoureiro</option>
						  <option>Secretário(a)</option>
						  <option>Sonoplasta</option>
						  <option>Projetista</option>
						</select>
					    
					    <button class="btn btn-outline-secondary rounded-end" id="btnAdicionarVeiculo" type="button" onclick="adicionarVeiculo()" disabled><i class="bi bi-plus-lg"></i> Adicionar</button>
					    
<!-- 						<datalist  id="veiculos">
						  <option">Pastor Local</option>
						  <option>Teste</option>
						  <option>Discipulador</option>
						  <option>Líder de Célula</option>
						  <option>Líder de Célula em Teinamento</option>
						  <option>Líder de Louvor</option>
						  <option>Anfitrião de Célula</option>
						  <option>Administrador de Sistemas</option>
						  <option>Músico Intrumentista</option>
						  <option>Músico Vocal</option>
						  <option>Tesoureiro</option>
						  <option>Secretário(a)</option>
						  <option>Sonoplasta</option>
						  <option>Projetista</option>
						</datalist> -->
					  
					  </div>
					  <div class="mb-2 col-sm-12">
						<select class="form-control" id="lista-funcoes-area" readonly style="min-height:10em"></select>
					  </div>
					  <div class="d-grid gap-2 d-flex justify-content-md-end">
					    <button class="btn btn-secondary me-md-2" type="button" id="limpar-funcoes">Limpar</button>
					  </div>
				  	</div>
				</div>				  
			</div>

			<div class="row mb-4">
				<div class="form-group">
					<label class="form-label" for="descricao">Descrição:</label>
					<form:textarea id="descricao" class="form-control" rows="6"
						path="descricao" value="${ reserva.descricao }" />
				</div>
			</div>

			<div class="row mb-4">
				<div class="d-flex">
					<button type="reset" class="btn btn-secondary me-auto">
						<i class="bi bi-recycle"></i>&nbsp;Limpar
					</button>
					<a href="/reserva/listar" class="btn btn-secondary"><i
						class="bi bi-x-lg"></i>&nbsp;Cancelar</a>&nbsp;
					<button type="submit" class="btn btn-success">
						<i class="bi bi-check-lg"></i>&nbsp;
						<c:if test="${ reserva.id gt 0 }">Salvar</c:if>
						<c:if test="${ reserva.id eq null }">Cadastrar</c:if>
					</button>
				</div>
			</div>

		</form:form>
	</div>
	<tags:scripts />
	<script type="text/javascript">
	
		function habilitaBotaoAdicionar() {
			$("#btnAdicionarVeiculo").attr("disabled", false);
		}
	
		function adicionarVeiculo() {
			var inputFieldVeiculoVal = $("#input-veiculo").val();
			var inputFieldVeiculo = $("#input-veiculo");
			console.log(inputFieldVeiculoVal);
			console.log(inputFieldVeiculo);
			$("#input-veiculo").find("option").each(function() {
				if(this.selected) {					
					console.log(this);
				}
			});
		}	  	
	</script>
</body>
</html>