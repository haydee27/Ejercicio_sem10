
package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Persona {

    String dui;
    String apellido;
    String nombre;

    Connection cnn; 
    Statement state;
    ResultSet result;

       public Persona(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd__recurso_humano?zeroDateTimeBehavior=convertToNull","root","");
        } catch (ClassNotFoundException ex) {
                 System.out.println("Conexion Fallida!");
                 java.util.logging.Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (SQLException ex) {
                  System.out.println("Conexion fallida!");
                  java.util.logging.Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
          }
       }
        
           public Persona(String dui, String apellido, String nombre) {
              this.dui = dui;
              this.apellido = apellido;
              this.nombre = nombre;
          }
      
           public boolean InsertarDatos(){
            try{
                String miQuery="insert into tb_persona values('" + dui + "','" + apellido + "','" + nombre + "');";
                int es=0;
                state=cnn.createStatement();
                es=state.executeUpdate(miQuery);
                if (es==1){
                    return true;
                }
            }catch (SQLException ex){
                    Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
                }
            return false;
        }
       
      
     public ArrayList<Persona> ConsultarR(){
        ArrayList<Persona> person = new ArrayList(); // Crear el arrat de almacenamiento de tipo persona
        try{
            String miQuery = "SELECT * FROM tb_persona;";
            state = cnn.createStatement();
            result = state.executeQuery(miQuery);
            while(result.next()){
                person.add(new Persona(result.getString("dui_persona"), result.getString("apellidos_persona"), result.getString("nombre_persona")));
            }
        }catch(SQLException ex){
            java.util.logging.Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return person;
    }
    
     public ArrayList ConsultarR(int dui){
        ArrayList<Persona> person = new ArrayList(); // Crear el arrat de almacenamiento de tipo persona
        try{
            String miQuery = "SELECT * FROM tb_persona where dui_persona = " + dui;
            state = cnn.createStatement();
            result = state.executeQuery(miQuery);
            while(result.next()){
                person.add(new Persona(result.getString("dui_persona"), result.getString("apellidos_persona"), result.getString("nombre_persona")));
            }
        }catch(SQLException ex){
            java.util.logging.Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return person;
    }
     public boolean Actualizar(Persona person) {
        try{
                String miQuery = "Update tb_persona set nombre_persona = '" + person.getNombre() + "', apellidos_persona = '" + person.getApellido() + "' where dui_persona = '" + person.getDui() + "';";
                int es = 0;
                state = cnn.createStatement();
                es = state.executeUpdate(miQuery);
                if (es ==1 ){
                    return true;
                }
                } catch (SQLException ex){
            java.util.logging.Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
                }
                return false;
            }
     
     public boolean eliminar(int dui){
        try{
            String miQuery = "Delete From tb_persona where dui_persona = '" + dui + "';";
            int estado = 0; //Estado de la inserción
            state = cnn.createStatement();
            estado = state.executeUpdate(miQuery);
            if(estado == 1){
                return true;
            }
        }catch(SQLException ex){
            java.util.logging.Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
      public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}


