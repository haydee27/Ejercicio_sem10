<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>MUESTRA DE DATOS!</h1>
        <center>
        <h1>Todos los registros</h1>
        <table class="table" Style="width: 50%">
                <thead>
                    <tr>
                        <th scope="col">DUI</th>
                        <th scope="col">Apellidos</th>
                        <th scope="col">Nombres</th>
                    </tr>
                </thead>
                <tbody>
    <c:forEach var="listaTotal" items="${sessionScope.personas}">
                    <tr>
                        <td>${listaTotal.dui}</td>
                        <td>${listaTotal.apellido}</td>
                        <td> ${listaTotal.nombre}</td>
                        <td><a  href="actualizarHB.do?accion=editar&&dui=${listaTotal.dui}" role="button">Editar</a></td>
                        <td><a  href="actualizarHB.do?accion=eliminar&&dui=${listaTotal.dui}" role="button">Eliminar</a></td>
                    </tr>
                   
    </c:forEach>
                    <tr>
                        <td colspan="3" align="center">
                            <a class="btn btn-primary" href="index.jsp" role="button">Regresar:</a>
                            
                        </td>
                    </tr>
                     </tbody>
            </table>
        </center>
    </body>
</html>
