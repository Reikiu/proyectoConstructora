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
            JOptionPane.showMessageDialog(null, "Error al ingresar Nomina"+e.getMessage());
        }
    }

    public void modificarNomina(Nomina no) throws Exception{
        try {
            this.conectar();
            String sql="update nomina set horasTrabajadas='?', horasExtras='?',"
                    + "sueldo='?', anticipo='?', idEmpleado='?' "
                    + "where idNomina=?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, no.getHorasTrabajadas());
            pre.setInt(2, no.getHorasExtras());
            pre.setDouble(3, no.getSueldo());
            pre.setDouble(4, no.getAnticipo());
            pre.setInt(5, no.getIdEmpleado());
            pre.setInt(6, no.getIdNomina());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar datos de la"
                    + " nomina"+e.getMessage());
        }
    }
    
    public void eliminarNomina(Nomina no) throws Exception{
        try {
            int var= JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar el "
                    + "registro?", "Confirmacion", JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE);
            if (var == JOptionPane.YES_OPTION) {
                this.conectar();
                String sql = "delete from nomina where idNomina='?'";
                PreparedStatement pre = this.getCon().prepareStatement(sql);
                pre.setInt(1, no.getIdNomina());
            }
            else if(var==JOptionPane.NO_OPTION){
                JOptionPane.showConfirmDialog(null, "Operacion cancelada");
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Error al intentar eliminar el "
                    + "registro."+e.getMessage());
        }
    }
    
    public void mostrarNomina(Nomina no) throws Exception{
        try {
            
        } catch (Exception e) {
        }
    }
}
