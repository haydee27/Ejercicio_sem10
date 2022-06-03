
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DatosPersona;

public class Modificar_SA extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
  
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String d =request.getParameter("txtDui");
        String n = request.getParameter("txtNombre");
        String a =request.getParameter("txtApellido");
        
        DatosPersona per = new DatosPersona();
        DatosPersona person = new DatosPersona (d, n, a);
        if(per.ActualizarD(person) == true){
            request.getRequestDispatcher("MConexito.jsp").forward(request, response);
            
        }
        else{
            request.getRequestDispatcher("noexito.jsp").forward(request, response);
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
