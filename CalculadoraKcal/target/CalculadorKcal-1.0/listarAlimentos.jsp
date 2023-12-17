<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>listar alimentos</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/73066cae85.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">

        <style>
            /* Ajuste adicional para la tabla */
            th, td {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1 class="display-4 mt-4">TABLA DE ALIMETNOS</h1>
                <div class="col-md-8"> <!-- tabla de alimentos -->
                    <table class="table table-striped table-bordered">
                        <thead class="thead-dark">
                            <tr>
                                <th>ID</th>
                                <th>NOMBRE</th>
                                <th>GRASAS</th>
                                <th>CARBOHIDRATOS</th>
                                <th>PROTEINAS</th>
                                <th>Kcal</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="alimento" items="${listaAlimentos}">
                                <tr>
                                    <td>${alimento.idAlimento}</td>
                                    <td>${alimento.nombre}</td>
                                    <td>${alimento.grasas}</td>
                                    <td>${alimento.carbohidratos}</td>
                                    <td>${alimento.proteinas}</td>
                                    <td>${alimento.kcal}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=editarAlimentoLista&idAlimento=${alimento.idAlimento}" class="btn btn-outline-primary">
                                            <i class="bi bi-pencil"></i>
                                        </a>
                                    </td>
                                    <td>
                                        <a href="#" onclick="eliminarAlimentoLista('${alimento.idAlimento}')" data-toggle="modal" data-target="#eliminarAlimentoLista" class="btn btn-outline-danger">
                                            <i class="bi bi-trash"></i>
                                        </a>
                                        <jsp:include page="/WEB-INF/Alimentos/eliminarAlimentoLista.jsp"/>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-1"></div>
                <div class="col-md-3"> 
                    <!-- acciones -->
                    <a href="#" data-toggle="modal" data-target="#agregarAlimentoLista" class="btn btn-warning btn-lg rounded-pill">
                        <i class="bi bi-plus-circle"></i> AÑDIR ALIMENTO
                    </a>
                    <jsp:include page="/WEB-INF/Alimentos/agregarAlimentoLista.jsp"/>
                    <a href="${pageContext.request.contextPath}/ServletControlador" class="btn btn-warning btn-lg rounded-pill mt-4">
                        <i class="bi bi-house"></i> VOLVER A INICIO
                    </a>

                </div>
            </div>
        </div>
        <script src="js/eliminarAlimentoLista.js"></script>
        <!-- Agrega el enlace a Bootstrap -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

    </body>
</html>
