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
 * Clase: DaoEmpleado ()
 * Fecha: 04-sep-2019
 * @author: Amilcar Hernandez
 */
public class DaoEmpleado extends Conexion{
    public void insertarEmpleado(Empleado emp) throws Exception{
        this.conectar();
        String sql="insert into empleado values (?,?,?,?,?,?,?,?)";
        PreparedStatement pre=this.getCon().prepareStatement(sql);
        pre.setInt(1, emp.getIdEmpleado());
        pre.setInt(2, emp.getIdProyecto());
        pre.setString(3, emp.getNombreEmpleado());
        pre.setString(4, emp.getDireccionEmpleado());
        pre.setString(5, emp.getTelefonoEmpleado());
        pre.setString(6, emp.getSexo());
        pre.setString(7, emp.getPuesto());
        pre.setString(8, emp.getFechaContratacion());
        pre.executeUpdate();
    }
    
    public List<Proyecto> mostrarCmbProyecto() throws Exception {
        ResultSet rs;
        List<Proyecto> lstu = new ArrayList();

        try {
            this.conectar();
            String sql = "Select * from usuario";
            PreparedStatement pst = this.getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Proyecto pro = new Proyecto();
                pro.setNombre(rs.getString("nombre"));
                lstu.add(pro);
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Error " + e.toString());
        } finally {
            this.desconectar();
        }
        return lstu;
    }
}
