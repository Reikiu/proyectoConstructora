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
 * Clase: 
 * Fecha: 03-sep-2019
 * @author: Amilcar Hernandez
 */
public class DaoCliente extends Conexion{
    public void insertarCLiente(Cliente cli) throws Exception{
        try {
            this.conectar();
            ResultSet rs1;
            String sql1 = "Select * from cliente";
            PreparedStatement pst1 = this.getCon().prepareStatement(sql1);
            rs1 = pst1.executeQuery();
            int i = 0;
            while (rs1.next()) {
                if (rs1.getInt("idCliente") > i) {
                    i = rs1.getInt("idCliente");
                }
            }
            i = i + 1;
            
            String sql="insert into cliente values (?,?,?,?,?,?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, i);
            pre.setString(2, cli.getNombre());
            pre.setString(3, cli.getDireccion());
            pre.setString(4, cli.getDui());
            pre.setString(5, cli.getFechaNacimiento());
            pre.setString(6, cli.getTelefono());
            pre.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar Cliente"
                    +e.getMessage());
        }
    }
    
    public void modificarCliente(Cliente cli) throws SQLException {
        try {
            this.conectar();

            String sql = "Update cliente set nombre=?,direccion=?,dui=?,"
                    + "fechaNacimiento=?,telefono=? where idCliente=?";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            pst.setInt(6, cli.getIdCliente());
            pst.setString(1, cli.getNombre());
            pst.setString(2, cli.getDireccion());
            pst.setString(3, cli.getDui());
            pst.setString(4, cli.getFechaNacimiento());
            pst.setString(5, cli.getTelefono());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modificado exitosamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar modificar" + e.toString());
        }
    }
    
    public void eliminarCliente(Cliente cli) throws Exception {
        int var = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar el "
                + "registro?", "Confirmacion", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (var == JOptionPane.YES_OPTION) {
            try {
                this.conectar();
                String sql = "Delete from cliente where idCliente=?";
                PreparedStatement pst = this.getCon().prepareStatement(sql);
                pst.setInt(1, cli.getIdCliente());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "El registro ha sido eliminado.");
            } catch (SQLException e) {
                JOptionPane.showConfirmDialog(null, "Error al intentar eliminar el "
                        + "registro." + e.getMessage());
            }
        } else if (var == JOptionPane.NO_OPTION) {
            JOptionPane.showConfirmDialog(null, "Operacion cancelada", "Eliminado",
                    JOptionPane.OK_OPTION);
        }
    }
    
    public List<Cliente> mostrarCliente() throws Exception {
        ResultSet rs;
        List<Cliente> lstu = new ArrayList();

        try {
            this.conectar();
            String sql = "Select * from cliente";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setIdCliente(rs.getInt("idCliente"));
                cli.setNombre(rs.getString("nombre"));
                cli.setDireccion(rs.getString("direccion"));
                cli.setDui(rs.getString("dui"));
                cli.setFechaNacimiento(rs.getString("fechaNacimiento"));
                cli.setTelefono(rs.getString("telefono"));
                lstu.add(cli);
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Error " + e.toString());
        } finally {
            this.desconectar();
        }
        return lstu;
    }
    
}
