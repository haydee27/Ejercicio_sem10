
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Persona;


public class ActualizarHB extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
            String accion = request.getParameter("accion");
            System.out.println("La accion es: " +accion);
            String Dui = request.getParameter("dui");
            System.out.println("El dui es: " + Dui);
            
            Persona p = new Persona();
            ArrayList<Persona> persona = new ArrayList<>();
        
        if(accion.equals("editar"))
        {
            System.out.println("Pasa por el if: ");
            
            persona = p.ConsultarR(Integer.parseInt(Dui));
            request.getSession().setAttribute("persona", persona); //Asignar valores a la sesion
        
            request.getRequestDispatcher("modificar.jsp").forward(request, response);
        } else if (accion.equals("eliminar"))
        {
            persona = p.ConsultarR(Integer.parseInt(Dui)); // Consulta los registros y los almacena en nuevo array llamado personas
            request.getSession().setAttribute("persona", persona); //Asignar valores a la sesion
            request.getRequestDispatcher("Eliminar.jsp").forward(request, response);
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
