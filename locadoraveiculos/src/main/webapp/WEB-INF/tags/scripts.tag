<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 	uri="http://java.sun.com/jstl/core_rt"%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<script>
    var toastElList = [].slice.call(document.querySelectorAll('.toast'))
    var toastList = toastElList.map(toastEl => {
      return new bootstrap.Toast(toastEl)
    });
   toastList.forEach(toast => toast.show());
</script>
