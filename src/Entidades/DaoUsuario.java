/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Conexion.Conexion;
import java.sql.SQLException;

/**
 *
 * @author Alex
 */
public class DaoUsuario extends Conexion {

    public List<Usuario> mostrarUsuario() throws Exception {
        ResultSet rs;
        List<Usuario> lstu = new ArrayList();

        try {
            this.conectar();
            String sql = "Select * from usuario";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Usuario us = new Usuario();
                us.setIdUsuario(rs.getInt("idUsuario"));
                us.setUsuario(rs.getString("usuario"));
                us.setPassword(rs.getString("password"));
                us.setTipoUsuario(rs.getInt("idTipo"));
                lstu.add(us);
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Error " + e.toString());
        } finally {
            this.desconectar();
        }
        return lstu;
    }

    public void insertarUsuario(Usuario us) throws SQLException {
        try {
            this.conectar();
            ResultSet rs1;
            String sql1 = "Select * from usuario";
            PreparedStatement pst1 = this.getCon().prepareStatement(sql1);
            rs1 = pst1.executeQuery();
            int i = 0;
            while (rs1.next()) {
                if (rs1.getInt("idUsuario") > i) {
                    i = rs1.getInt("idUsuario");
                }
            }
            i = i + 1;
            String sql = "Insert into usuario values (?,?,?,?)";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setInt(1, i);
            pst.setString(2, us.getUsuario());
            pst.setString(3, us.getPassword());
            pst.setInt(4, us.getTipoUsuario());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Oc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.toString());
        }
    }
    
    public void modificarUsuario(Usuario us) throws SQLException {
        try {
            this.conectar();
            ResultSet rs1;
            String sql1 = "Select * from usuario";
            PreparedStatement pst1 = this.getCon().prepareStatement(sql1);
            rs1 = pst1.executeQuery();
            int i = 0;
            while (rs1.next()) {
                if (rs1.getInt("idUsuario") > i) {
                    i = rs1.getInt("idUsuario");
                }
            }
            i = i + 1;
            String sql = "Update usuario set usuario=?,password=?,idTipo=? where idUsuario=?";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setInt(4, us.getIdUsuario());
            pst.setString(1, us.getUsuario());
            pst.setString(2, us.getPassword());
            pst.setInt(3, us.getTipoUsuario());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Oc");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.toString());
        }
    }
    public void eliminarUsuario(Usuario us){
        try{
            String sql = "Delete from usuario where id=?";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setInt(1, us.getIdUsuario());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al borrar "+e.toString()+" pendejo");
        }
    }
}
