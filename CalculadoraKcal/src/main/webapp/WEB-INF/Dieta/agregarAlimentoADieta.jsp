<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="agregarAlimentoDieta" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-dark text-white">
                <h5 class="modal-title">Agregar Alimento en <span id="valorTiming"></span></h5>
                <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close"></button> <!-- X que cierra modal -->
            </div>
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertarAlimentoDieta" method="POST" class="was-validated">
                <!-- envia al servlet controlador los datos con el nombre de insertar y la variable es accion -->
                <div class="modal-body">
                    <div class="form-group">
                        <label for="idAlimento">Alimetno</label>
                        <select id="idAlimento" class="form-control" name="idAlimento" required>
                            <c:forEach var="alimento" items="${listaAlimentos}">
                                <option value="${alimento.idAlimento}">${alimento.nombre}</option>
                            </c:forEach>
                        </select>
                    </div>
                    
                    <div class="form-group">
                        <label for="cantidad">Cantidad(g)</label>
                        <input type="number" class="form-control" name="cantidad" required step="any">
                    </div>
                    
                    <div>
                        <input type="hidden" name="timing" id="inputTiming" value="">
                    </div>
                    
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>
            </form>
        </div>
    </div>
</div>
