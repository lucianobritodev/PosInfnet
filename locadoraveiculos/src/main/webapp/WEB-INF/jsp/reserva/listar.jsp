<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pt">
<head>
<meta charset="UTF-8">
<title>AppLocadoraVeiculo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous" />

</head>
<body>

	<jsp:include page="../static/header.jsp" />

	<div class="container">
		<h1>Reservas:</h1>
		<div class="row">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>#</th>
						<th>Cliente</th>
						<th>Data da Reserva</th>
						<th>Descrição</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody id="lista">
					<c:forEach items="${ listagem }" var="reserva" varStatus="i">
						<tr>
							<th scope="row">${ i.index + 1 }</th>
							<td>${ reserva.cliente.nome }</td>
							<td>
								<fmt:parseDate value="${ reserva.dataReserva }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
								<fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss" value="${ parsedDateTime }" />	
							</td>
							<td>${ reserva.descricao }</td>
							<td>${ reserva.status }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
			crossorigin="anonymous"></script>
</body>
</html>