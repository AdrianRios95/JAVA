<%@page import="java.util.List"%>
<%@page import="dominio.AlimentoComida"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    List<AlimentoComida> listaAlimentosDieta = (List<AlimentoComida>) session.getAttribute("listaAlimentosDieta");
    String timing = (String) request.getParameter("timing");
    double sumaGrasas = 0;
    double sumaCarbohidratos = 0;
    double sumaProteinas = 0;
    double sumaKcal = 0;

    if (listaAlimentosDieta != null) {
        for (AlimentoComida alimentoComida : listaAlimentosDieta) {
            if (alimentoComida.getTiming().equals(timing)) {
                sumaGrasas += alimentoComida.getTotalGrasas();
                sumaCarbohidratos += alimentoComida.getTotalCarbohidratos();
                sumaProteinas += alimentoComida.getTotalProteinas();
                sumaKcal += alimentoComida.getTotalKcal();
            }
        }
    }

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Agrega el enlace a Bootstrap CSS -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <style>
            /* Ajuste adicional para la tabla */
            th, td {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <table class="table table-striped table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>NOMBRE</th>
                    <th>CANTIDAD</th>
                    <th>GRASAS</th>
                    <th>CARBOHIDRATOS</th>
                    <th>PROTEINAS</th>
                    <th>Kcal</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="alimentoComida" items="${listaAlimentosDieta}">
                    <c:if test="${param.timing eq alimentoComida.timing}"> <!-- $.{param.timing} recupera la variable "timing" compartida en la url -->
                        <tr>
                            <td>${alimentoComida.nombre}</td>
                            <td>${alimentoComida.cantidad}</td>
                            <td>${String.format('%.2f', alimentoComida.totalGrasas)}</td>
                            <td>${String.format('%.2f', alimentoComida.totalCarbohidratos)}</td>
                            <td>${String.format('%.2f', alimentoComida.totalProteinas)}</td>
                            <td>${String.format('%.2f', alimentoComida.totalKcal)}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/ServletControlador?accion=editarDieta&idDieta=${alimentoComida.idDieta}" class="btn btn-outline-primary">
                                    <i class="bi bi-pencil"></i> <!-- Icono de "añadir" -->
                                </a>
                            </td>
                            <td>
                                <a href="#" onclick="eliminarComida('${alimentoComida.idDieta}')" data-toggle="modal" data-target="#modalEliminarComida" class="btn btn-outline-danger">
                                    <i class="bi bi-trash"></i>
                                </a>
                                <jsp:include page="/WEB-INF/Dieta/eliminarAlimentoDieta.jsp"/>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
                <tr>
                    <td><b></b></td>
                    <td><b>TOTAL</b></td>
                    <td><b><%= String.format("%.2f", sumaGrasas)%></b></td> <!-- se usa este formato para que solo tenga 2 decimales -->
                    <td><b><%= String.format("%.2f", sumaCarbohidratos)%></b></td>
                    <td><b><%= String.format("%.2f", sumaProteinas)%></b></td>
                    <td><b><%= String.format("%.2f", sumaKcal)%></b></td>
                </tr>
            </tbody>
        </table>
        <script src="js/eliminarComida.js"></script>
    </body>
</html>
