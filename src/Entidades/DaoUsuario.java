/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class DaoUsuario extends Conexion {

    List<Usuario> lstu = new ArrayList();
    
    public List<Usuario> mostrarUsuario() throws Exception{
        
        return null;
    }
    
    public void insertarUsuario(Usuario us) throws Exception{
        try{
            this.conectar();
            String sql = "INSERT into usuario values (?,?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, us.getIdUsuario());
            pre.setString(2, us.getUsuario());
            pre.setString(3, us.getPassword());
            pre.setInt(4, us.getTipoUsuario());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
}
