<%@page import="dominio.AlimentoComida"%>
<%@page import="java.util.HashMap"%>
<%@page import="dominio.Comida"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<AlimentoComida> listaAlimentosDieta = (List<AlimentoComida>) session.getAttribute("listaAlimentosDieta");
    double totalGrasasDia = 0;
    double totalCarbohidratosDia = 0;
    double totalProteinasDia = 0;
    double totalKcalDia = 0;

    if (listaAlimentosDieta != null) {
        for (AlimentoComida alimentoComida : listaAlimentosDieta) {
            totalGrasasDia += alimentoComida.getTotalGrasas();
            totalCarbohidratosDia += alimentoComida.getTotalCarbohidratos();
            totalProteinasDia += alimentoComida.getTotalProteinas();
            totalKcalDia += alimentoComida.getTotalKcal();
        }
    }

%>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/73066cae85.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">

        <title>JSP Page</title>
    </head>
    <body>
        <br>
        <div class="mx-5 my-5">
            <div class="row">
                <div class="col-md-8 px-5">
                    <h1>DIETA</h1>
                    <br>
                    <c:forEach var="timing" items="${timings}">
                        <div>
                            <h3 class="display-4">${timing.toUpperCase()}</h3> <!-- pone la variable en mayuscula -->
                            <jsp:include page="/WEB-INF/Dieta/tablaDieta.jsp?timing=${timing}"/> <!-- envia al otro jsp la variable para hacer el if -->
                        </div>
                        <div>
                            <a href="#" class="btn btn-outline-secondary" onclick="agregarAlimentoDieta('${timing}')" data-toggle="modal" data-target="#agregarAlimentoDieta">
                                <i class="bi bi-plus-circle"></i> <!-- Icono de "añadir" -->
                                Añadir Alimento
                            </a>
                            <jsp:include page="/WEB-INF/Dieta/agregarAlimentoADieta.jsp"/><!-- devemos añadir esta ruta para que pueda encontrar el modal -->
                        </div>
                        <br><br>
                    </c:forEach>
                </div>
                <!--<div class="col-md-1"></div>-->
                <div class="col-md-4 px-5">
                    <div>
                        <br><br><br><br>
                        <h2>TOTAL DEL DIA</h2>
                        <div class="border p-3">
                            GRASAS: <%=String.format("%.2f", totalGrasasDia)%>g
                        </div>
                        <br>
                        <div class="border p-3">
                            CARBOHIDRATOS: <%=String.format("%.2f", totalCarbohidratosDia)%>g
                        </div>
                        <br>
                        <div class="border p-3">
                            PROTEINAS: <%=String.format("%.2f", totalProteinasDia)%>g
                        </div>
                        <br>
                        <div class="border p-3">
                            <h2 class="text-success">Kcal: <%=String.format("%.2f", totalKcalDia)%></h2>
                        </div>
                    </div>
                    <div class="mt-4"> <!-- Clase "mt-4" para un margen top de 4 -->
                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=listarAlimentos" class="btn btn-warning btn-lg rounded-pill">
                            <i class="bi bi-list-check"></i> LISTA DE ALIMENTOS
                        </a>
                            
                    </div>
                </div>
            </div>
        </div>
                            
        <!-- el siguiente codigo de javascrip es para que se actualice correctamente el elemento modal, ya que si no no actualiza la variable timing -->
        <script src="js/modulosDieta.js"></script>
        <!-- liks de bootstrsp de js, popper, etc-->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
