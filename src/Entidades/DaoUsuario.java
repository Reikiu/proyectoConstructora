/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class DaoUsuario extends Conexion {

    
    
    public List<Usuario> mostrarUsuario() throws Exception{
        ResultSet rs;
        List<Usuario> lstu = new ArrayList();
        
        try{
            this.conectar();
            String sql = "Select * from usuario";
            PreparedStatement pst= this.getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                Usuario us = new Usuario();
                us.setIdUsuario(rs.getInt("idUsuario"));
                us.setUsuario(rs.getString("usuario"));
                us.setPassword(rs.getString("password"));
                us.setTipoUsuario(rs.getInt("idTipo"));
                lstu.add(us);
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, "Error "+e.toString());
        }finally{
            this.desconectar();
        }
        return lstu;
    }
    
    public void insertarUsuario(Usuario us){
        try{
            this.conectar();
            String sql = "insert into usuario values (?,?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, us.getIdUsuario());
            pre.setString(2, us.getUsuario());
            pre.setString(3, us.getPassword());
            pre.setInt(4, us.getTipoUsuario());
            pre.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario ingresado correctamente");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR "+e.toString()+" pendejo");
        }finally{
            this.desconectar();
        }
    }
    
}
