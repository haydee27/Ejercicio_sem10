

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
       <h1> Registro  </h1>
        
        <form action="recibir_HB.do" method="POST">
         <table cellspacing="3" cellpadding="0" border="1" bigcolor="$purple-100" > 
            <tr><td> <label>DUI:</label><br>
            <input type="text" name="txtDui" value="" /><br><br>
            <label>Apellidos:</label>
            <input type="text" name="txtApellido" value="" /><br><br>
            <label>Nombre:</label>
            <input type="text" name="txtNombre" value="" /><br><br>
            
            <input type="submit" value="Registrar" name="btn" />
            
            <a href="Mostrar_BH.do">Ver registros</a></tr>
             </table>  
    </form>
       </center>
    </body>
</html>
