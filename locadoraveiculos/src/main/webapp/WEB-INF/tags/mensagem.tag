<%@ taglib prefix="c" 	uri="http://java.sun.com/jstl/core_rt"%>

<c:if test="${ msgWelcome != null }">
	<div class="alert alert-success alert-dismissible fade show" role="alert">
	  <strong>${ msgWelcome }</strong>
	  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	</div>
</c:if>

<c:if test="${ msgSuccess != null }">
	<div class="alert alert-success alert-dismissible fade show" role="alert">
	  <strong>${ msgSuccess }</strong>
	  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	</div>
</c:if>

<c:if test="${ msgError != null }">
	<div class="alert alert-danger alert-dismissible fade show" role="alert">
	  <strong>${ msgError }</strong>
	  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	</div>
</c:if>