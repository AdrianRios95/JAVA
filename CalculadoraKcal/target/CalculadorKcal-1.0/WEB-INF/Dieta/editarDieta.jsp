<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- liks de bootstrsp y font awesome -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/73066cae85.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">

        <title>Editar Dieta</title>
    </head>
    <body>
        <div>
            <div class="container">
                <div class="col-md-8 mt-4">
                    <div class="d-grid gap-2 col-6 mx-auto">
                        <a href="${pageContext.request.contextPath}/ServletControlador" class="btn btn-light" type="submit">
                            <i class="bi bi-arrow-left-circle"></i> Inicio
                        </a>
                    </div>
                </div>
            </div>
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificarDieta" method="POST" class="was-validated">
                <section id="details">
                    <div class="container mt-4">
                        <div class="row">
                            <div class="col-md-8">
                                <div class="card">
                                    <div class="card-header">
                                        <h4>Editar Dieta: id #${alimentoComida.idDieta}</h4>
                                    </div>
                                    <div class="card-body">
                                        <div class="form-group">
                                            <label for="idAlimento">Alimento</label>
                                            <select id="idAlimento" class="form-control" name="idAlimento" required>
                                                <option value="${alimentoComida.idAlimento}">${alimentoComida.nombre}</option>
                                                <c:forEach var="alimento" items="${listaAlimentos}">
                                                    <c:if test="${alimento.nombre ne alimentoComida.nombre}">
                                                        <option value="${alimento.idAlimento}">${alimento.nombre}</option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="form-group">
                                            <label for="cantidad">Cantidad(g):</label>
                                            <input type="number" class="form-control" name="cantidad" value="${alimentoComida.cantidad}" step="any"  required>
                                        </div> 

                                        <div>
                                            <input type="hidden" name="timing" value="${alimentoComida.timing}"/>
                                        </div>
                                        <div>
                                            <input type="hidden" name="idDieta" value="${alimentoComida.idDieta}"/>
                                        </div>
                                        <br>
                                        <div class="d-grid gap-2 col-6 mx-auto">
                                            <button class="btn btn-warning" type="submit">Guardar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </form>
        </div>

        <!-- liks de bootstrsp de js, popper, etc-->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>