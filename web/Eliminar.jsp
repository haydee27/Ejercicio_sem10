<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Eliminar Datos</h1>
        
        
        
    <from action="Delete_CA.do" method="post">
        <c:forEach var="listaTotal" items="${sessionScope.persona}">
            DUI:<input type="text" name="txtDui" value="${listaTotal.dui}"><br>
            Nombre:<input type="text" name="txtNombre" value="${listaTotal.nombre}"><br>
            Apellido:<input type="text" name="txtApellido" value="${listaTotal.apellido}"><br>
            
        </c:forEach>
            <input type="submit" value="Eliminar">
            
    </from>
    </body>
</html>
