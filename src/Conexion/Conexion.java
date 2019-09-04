/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author aalej
 */
public class Conexion {
    private Connection con;
    
    public Connection getCon(){
        return con;
    }
    
    public boolean conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectoconstructora", "root", "");
            return true;
        } catch (SQLException |ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar"+e.getMessage());
            return false;
        }
    }
    
    public boolean desconectar(){
        try {
            if (con!=null) {
                if (con.isClosed()==false) {
                    con.close();
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al desconectar"+e.getMessage());
        }
        return true;
    }
}
