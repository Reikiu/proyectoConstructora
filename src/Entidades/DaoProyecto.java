package Entidades;
import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author ang14ped16
 */
public class DaoProyecto extends Conexion {
     List<Proyecto> lstu = new ArrayList();

    public List<Proyecto> mostrarMateria() throws Exception {

        return null;
    }
    
    public void insertarProyeto(Proyecto pro) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT into proyecto values (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, pro.getIdProyecto());
            pre.setInt(2, pro.getIdCliente());
            pre.setString(3, pro.getNombre());
            pre.setInt(4, pro.getFactura());
            pre.setString(5, pro.getEstadoProyecto());
            pre.setString(6, pro.getFechaInicio());
            pre.setString(7, pro.getFechaFin());
            pre.setInt(8, pro.getMontoEmpleado());
            pre.setString(9, pro.getDireccion());
            pre.setInt(10, pro.getMontoMaquinaria());
            pre.setInt(11, pro.getMontoMaterial());
            pre.setDouble(12, pro.getMontoTotal());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    public void modificarProyecto(Proyecto pro) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE proyecto set idCliente='?',nombre='?',"
                    + "factura='?',estadoProyecto='?',fechaInicio='?',"
                    + "fechaFin='?',montoEmpleados='?',direccion='?',"
                    + "montoMaquinaria='?',montoMateria='?',montoTotal='?' "
                    + "WHERE idProyecto='?'";
            
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, pro.getIdCliente());
            pre.setString(2, pro.getNombre());
            pre.setInt(3, pro.getFactura());
            pre.setString(4, pro.getEstadoProyecto());
            pre.setString(5, pro.getFechaInicio());
            pre.setString(6, pro.getFechaFin());
            pre.setInt(7, pro.getMontoEmpleado());
            pre.setString(8, pro.getDireccion());
            pre.setInt(9, pro.getMontoMaquinaria());
            pre.setInt(110, pro.getMontoMaterial());
            pre.setDouble(11, pro.getMontoTotal());
            pre.setInt(12, pro.getIdProyecto());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    public void eliminarProyecto(Proyecto pro) throws Exception{
        try {
            int var= JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar el "
                    + "registro?", "Confirmacion", JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE);
            if (var == JOptionPane.YES_OPTION) {
                this.conectar();
                String sql = "delete from proyecto where dProyecto='?'";
                PreparedStatement pre = this.getCon().prepareStatement(sql);
                pre.setInt(1, pro.getIdProyecto());
            }
            else if(var==JOptionPane.NO_OPTION){
                JOptionPane.showConfirmDialog(null, "Operacion cancelada");
            }
                
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Error al intentar eliminar el "
                    + "registro.");
        }
    }
}