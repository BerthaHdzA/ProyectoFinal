/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usosockets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;
/**
 *
 * @author BETY
 */
public class Conexion {
    static Connection contacto=null;
    public static Connection getConexion()
    {
        String conexionUrl = "jdbc:sqlserver://LAPTOP-3HULPECQ:1433;databaseName=Project";
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
        }catch(ClassNotFoundException e){
          JOptionPane.showMessageDialog(null, "No se puedo establecer la conexión...revisar Driver"
                    +e.getMessage(),"Error de conexión",JOptionPane.ERROR_MESSAGE);
        }
        try{
            contacto=DriverManager.getConnection(conexionUrl,"as","123");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR!!"+e.getMessage(),
                    "Error de conexión",JOptionPane.ERROR_MESSAGE);
        }
            return contacto;
    }
    
    public static ResultSet Consulta(String consulta){
        Connection con=getConexion();
        Statement declara;
        try{
            declara=con.createStatement();
            ResultSet respuesta=declara.executeQuery(consulta);
            return respuesta;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR!!"+e.getMessage(),
                    "Error de conexión",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
}
