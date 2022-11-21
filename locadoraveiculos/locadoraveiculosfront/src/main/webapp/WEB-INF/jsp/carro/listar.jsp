<%@ page language="java" 	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" 	tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html lang="pt">
<head>
	<meta charset="UTF-8">
	<title>Carros</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>
<body>

	<jsp:include page="../static/header.jsp" />
	<tags:mensagem />
	
	<div class="container">
		<h1 class="mt-4 mb-4">Carros</h1>
		<div class="row mb-4">
			<div class="d-flex flex-row-reverse">			
				<a class="btn btn-primary p-2" href="/carro/cadastrar"><i class="bi bi-plus"></i> Incluir&nbsp;&nbsp;</a> 
			</div>		
		</div>
		<div class="row">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>ID</th>	
						<th>Chassi</th>
						<th>Nome</th>
						<th>Cor</th>
						<th>Assentos</th>
						<th>Combustível</th>
						<th>Motor</th>
						<th>Direção</th>
						<th>Valor</th>
						<th style="width: 80px">Excluir</th>
						<th style="width: 80px">Editar</th>
					</tr>
				</thead>
				<tbody id="lista">
					<c:forEach items="${ listagem }" var="carro">
						<tr>
							<th scope="row">${ carro.id }</th>
							<td>${ carro.codigoChassi }</td>
							<td>${ carro.nome }</td>
							<td>${ carro.cor }</td>
							<td>${ carro.assentos }</td>
							<td>${ carro.combustivel }</td>
							<td>${ carro.motor }</td>
							<td>${ carro.direcaoHidraulica }</td>
							<td>
								<fmt:formatNumber type="number" minFractionDigits="2" value="${ carro.valor }" />	
							</td>
							<td><a href="/carro/${ carro.id }/excluir" class="btn btn-danger"><i class="bi bi-trash"></i></a></td>
							<td><a href="/carro/${ carro.id }/editar" class="btn btn-secondary"><i class="bi bi-pencil-square"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<tags:scripts />	
</body>
</html>