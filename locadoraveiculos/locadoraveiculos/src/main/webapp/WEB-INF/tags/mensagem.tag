<%@ taglib prefix="c" 	uri="http://java.sun.com/jstl/core_rt"%>

<c:if test="${ msgWelcome != null }">
	<div class="toast-container position-fixed top-1 end-0 p-3" id="toast">
		<div class="toast text-bg-info border-0" role="alert" aria-live="assertive" aria-atomic="true">
		  <div class="d-flex">
		    <div class="toast-body">
			    ${ msgWelcome }
		    </div>
		    <button type="button" class="btn-close me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
		  </div>
		</div>
	</div>
</c:if>

<c:if test="${ msgInfo != null }">
	<div class="toast-container position-fixed top-1 end-0 p-3" id="toast">
		<div class="toast text-bg-info border-0" role="alert" aria-live="assertive" aria-atomic="true">
		  <div class="d-flex">
		    <div class="toast-body">
		      ${ msgInfo }
		    </div>
		    <button type="button" class="btn-close me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
		  </div>
		</div>
	</div>
</c:if>

<c:if test="${ msgSuccess != null }">
	<div class="toast-container position-fixed top-1 end-0 p-3" id="toast">
		<div class="toast text-bg-success border-0" role="alert" aria-live="assertive" aria-atomic="true">
		  <div class="d-flex">
		    <div class="toast-body">
		      ${ msgSuccess }
		    </div>
		    <button type="button" class="btn-close me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
		  </div>
		</div>
	</div>
</c:if>

<c:if test="${ msgWarning != null }">
	<div class="toast-container position-fixed top-1 end-0 p-3" id="toast">
		<div class="toast text-bg-warning border-0" role="alert" aria-live="assertive" aria-atomic="true">
		  <div class="d-flex">
		    <div class="toast-body">
		      ${ msgWarning }
		    </div>
		    <button type="button" class="btn-close me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
		  </div>
		</div>
	</div>
</c:if>

<c:if test="${ msgError != null }">
	<div class="toast-container position-fixed top-1 end-0 p-3" id="toast">
		<div class="toast text-bg-danger border-0" role="alert" aria-live="assertive" aria-atomic="true">
		  <div class="d-flex">
		    <div class="toast-body">
		      ${ msgError }
		    </div>
		    <button type="button" class="btn-close me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
		  </div>
		</div>
	</div>
</c:if>