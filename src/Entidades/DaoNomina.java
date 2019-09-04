/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Clase: DaoNomina ()
 * Fecha: 04-sep-2019
 * @author: Amilcar Hernandez
 */
public class DaoNomina extends Conexion{
    public void insertarNomina(Nomina no) throws Exception{
        try {
            this.conectar();
            String sql="insert into nomina values (?,?,?,?,?,?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, no.getIdNomina());
            pre.setInt(2, no.getHorasTrabajadas());
            pre.setInt(3, no.getHorasExtras());
            pre.setDouble(4, no.getSueldo());
            pre.setDouble(5, no.getAnticipo());
            pre.setInt(6, no.getIdEmpleado());
        } catch (SQLException e) {
            
        }
    }

    
}
