/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;
import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 * Clase: 
 * Fecha: 03-sep-2019
 * @author: Amilcar Hernandez
 */
public class DaoCliente extends Conexion{
    public void insertarCLiente(Cliente cli) throws Exception{
        try {
            this.conectar();
            String sql="insert into clientes values (?,?,?,?,?,?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, cli.getIdCliente());
            pre.setString(2, cli.getNombre());
            pre.setString(3, cli.getDireccion());
            pre.setString(4, cli.getDui());
            pre.setString(5, cli.getFechaNacimiento());
            pre.setString(6, cli.getTelefono());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar Cliente");
        }
    }
    public void modificarCliente(Cliente cli) throws Exception{
        try {
            this.conectar();
            String sql="update cliente set nombre='?', direccion='?', dui='?', "
                    + "fechaNacimiento='?', telefono='?' where idCliente='?'";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setString(1, cli.getNombre());
            pre.setString(2, cli.getDireccion());
            pre.setString(3, cli.getDui());
            pre.setString(4, cli.getFechaNacimiento());
            pre.setString(5, cli.getTelefono());
            pre.setInt(6, cli.getIdCliente());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar Cliente");
        }
    }
    public void eliminarCliente(Cliente cli) throws Exception{
        try {
            int var= JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar el "
                    + "registro?", "Confirmacion", JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE);
            if (var == JOptionPane.YES_OPTION) {
                this.conectar();
                String sql = "delete from cliente where idCliente='?'";
                PreparedStatement pre = this.getCon().prepareStatement(sql);
                pre.setInt(1, cli.getIdCliente());
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Error al intentar eliminar el "
                    + "registro.");
        }
    }
    
}
