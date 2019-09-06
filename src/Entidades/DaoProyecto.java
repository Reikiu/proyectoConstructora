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
     public List<Proyecto> mostrarProyecto() throws Exception{
        ResultSet rs;
        List<Proyecto> lista = new ArrayList();
        
        try{
            this.conectar();
            String sql = "Select * from proyecto";
            PreparedStatement pst= this.getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                Proyecto pro = new Proyecto();
                pro.setIdProyecto(rs.getInt("idProyecto"));
                pro.setIdCliente(rs.getInt("idCliente"));
                pro.setNombre(rs.getString("nombre"));
                pro.setFactura(rs.getInt("factura"));
                pro.setEstadoProyecto(rs.getString("estadoProyecto"));
                pro.setFechaInicio(rs.getString("fechaInicio"));
                pro.setFechaFin(rs.getString("fechaFin"));
                pro.setMontoEmpleado(rs.getInt("montoEmpleados"));
                pro.setDireccion(rs.getString("direccion"));
                pro.setMontoMaquinaria(rs.getInt("montoMaquinaria"));
                pro.setMat_uti(rs.getInt("mat_uti"));
                pro.setMontoMaterial(rs.getInt("montoMateria"));
                pro.setMontoTotal(rs.getDouble("montoTotal"));
                lista.add(pro);
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, "Error "+e.toString());
        }finally{
            this.desconectar();
        }
        return lista;
    }
    
    public void insertarProyeto(Proyecto pro) throws Exception {
        try {
            this.conectar();
            ResultSet rs1;
            String sql1 = "Select * from proyecto";
            PreparedStatement pst1 = this.getCon().prepareStatement(sql1);
            rs1 = pst1.executeQuery();
            int i = 0;
            while (rs1.next()) {
                if (rs1.getInt("idProyecto") > i) {
                    i = rs1.getInt("idProyecto");
                }
            }
            i = i + 1;
            String sql = "INSERT into proyecto values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, i);
            pre.setInt(2, pro.getIdCliente());
            pre.setString(3, pro.getNombre());
            pre.setInt(4, pro.getFactura());
            pre.setString(5, pro.getEstadoProyecto());
            pre.setString(6, pro.getFechaInicio());
            pre.setString(7, pro.getFechaFin());
            pre.setInt(8, pro.getMontoEmpleado());
            pre.setString(9, pro.getDireccion());
            pre.setInt(10, pro.getMontoMaquinaria());
            pre.setInt(11, pro.getMat_uti());
            pre.setInt(12, pro.getMontoMaterial());
            pre.setDouble(13, pro.getMontoTotal());
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
                    + "montoMaquinaria='?',montoMateria='?',mat_uti='?',montoTotal='?' "
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
            pre.setInt(10, pro.getMontoMaterial());
            pre.setInt(11, pro.getMat_uti());
            pre.setDouble(12, pro.getMontoTotal());
            pre.setInt(13, pro.getIdProyecto());
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
