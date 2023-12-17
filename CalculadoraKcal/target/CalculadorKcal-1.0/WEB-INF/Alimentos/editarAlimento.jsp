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

        <title>Editar Alimento</title>
    </head>
    <body>
        <div>
            <div class="container">
                <div class="col-md-8 mt-4">
                    <div class="d-grid gap-2 col-6 mx-auto">
                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=listarAlimentos" class="btn btn-light" type="submit">
                            <i class="bi bi-arrow-left-circle"></i> Lista de Alimentos
                        </a>
                    </div>
                </div>
            </div>
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificarAlimentoLista" method="POST" class="was-validated">
                <!-- envia al servlet controlador los datos con el nombre de insertar y la variable es accion -->
                <section id="details">
                    <div class="container mt-4">
                        <div class="row">
                            <div class="col-md-8">
                                <div class="card">
                                    <div class="card-header">
                                        <h4>Editar Alimento: id #${alimento.idAlimento}</h4>
                                    </div>
                                    <div class="card-body">
                                        <div class="form-group">
                                            <label for="nombreAlimento">Alimetno</label>
                                            <input type="text" value="${alimento.nombre}" name="nombreAlimento" class="form-control" required>
                                        </div>

                                        <jsp:include page="/WEB-INF/Alimentos/radioFormularioEditarAlimentoLista.jsp"></jsp:include>

                                        <div class="form-group">
                                            <label for="grasas">Grasas</label>
                                            <input type="number" value="${alimento.grasas}" class="form-control" name="grasas" required step="any">
                                        </div>
                                        <div class="form-group">
                                            <label for="carbohidratos">Carbohidratos</label>
                                            <input type="number" value="${alimento.carbohidratos}" class="form-control" name="carbohidratos" required step="any">
                                        </div>
                                        <div class="form-group">
                                            <label for="proteinas">Proteinas</label>
                                            <input type="number" value="${alimento.proteinas}" class="form-control" name="proteinas" required step="any">
                                        </div>
                                        <div class="form-group">
                                            <label for="kcal">Kcal</label>
                                            <input type="number" value="${alimento.kcal}" class="form-control" name="kcal" required step="any">
                                        </div>

                                        <div>
                                            <input type="hidden" name="idAlimento" value="${alimento.idAlimento}">
                                        </div>

                                    </div>
                                    <div class="d-grid gap-2 col-6 mx-auto mb-3">
                                        <button class="btn btn-warning" type="submit">Guardar</button>
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