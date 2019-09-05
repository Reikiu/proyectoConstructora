/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

import Conexion.Conexion;
import java.sql.PreparedStatement;

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
}
