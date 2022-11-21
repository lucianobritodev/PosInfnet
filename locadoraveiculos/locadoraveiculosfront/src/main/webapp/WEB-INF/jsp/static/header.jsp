<%@ taglib prefix="c" 		uri="http://java.sun.com/jstl/core_rt" %>

<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="/home">AppLocadora</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item active">
          <a class="nav-link" href="/home">Home</a>
        </li>
        <c:if test="${ not empty user }">
	        <li class="nav-item">
	          <a class="nav-link" href="/usuario/listar">Usuario</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="/cliente/listar">Cliente</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="/reserva/listar">Reserva</a>
	        </li>
	        <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	            Veículos
	          </a>
	          <ul class="dropdown-menu">
	            <li><a class="dropdown-item" href="/veiculo/listar">Veiculo</a></li>
	            <li><a class="dropdown-item" href="/carro/listar">Carro</a></li>
	            <li><a class="dropdown-item" href="/trator/listar">Trator</a></li>
	            <li><a class="dropdown-item" href="/carreta/listar">Carreta</a></li>
	          </ul>
	        </li>
        </c:if>
      </ul>
      <ul class="nav navbar-nav navbar-right mb-2">
	      <c:if test="${ empty user }">
	        <li class="nav-item">
	      		<a class="nav-link" href="/usuario/cadastrar"><i class="bi bi-person-plus-fill"></i> Sign Up</a>
	      	</li>
	      	<li class="nav-item">
	      		<a class="nav-link" href="/login"><i class="bi bi-box-arrow-in-right"></i> Login</a>
	      	</li>
		  </c:if>
		  <c:if test="${ not empty user }">	
	      	<li class="nav-item">
	      		<a class="nav-link" href="/logout"><i class="bi bi-box-arrow-right"></i> Logout</a>
	      	</li>
	      </c:if>
      </ul>
    </div>
  </div>
</nav>