<%@ page language="java" 	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" 	tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html lang="pt">
<head>
	<meta charset="UTF-8">
	<title>AppLocadoraVeiculo</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>
<body>

	<jsp:include page="../static/header.jsp" />
	
	<div class="container">
		<tags:mensagem />
		<h1>Trator Listar</h1>
		<div class="row">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>ID</th>	
						<th>Chassi</th>
						<th>Nome</th>
						<th>Cor</th>
						<th>Tipo</th>
						<th>Combustível</th>
						<th>Motor</th>
						<th>Valor</th>
						<th>Excluir</th>
					</tr>
				</thead>
				<tbody id="lista">
					<c:forEach items="${ listagem }" var="trator">
						<tr>
							<th scope="row">${ trator.id }</th>
							<td>${ trator.codigoChassi }</td>
							<td>${ trator.nome }</td>
							<td>${ trator.cor }</td>
							<td>${ trator.tipoTrator }</td>
							<td>${ trator.combustivel }</td>
							<td>${ trator.motor }</td>
							<td>
								<fmt:formatNumber type="number" minFractionDigits="2" value="${ trator.valor }" />	
							</td>
							<td><a href="/trator/${ trator.id }/excluir" class="btn btn-danger"><i class="bi bi-trash"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>	
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>