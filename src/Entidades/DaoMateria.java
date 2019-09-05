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
public class DaoMateria extends Conexion {

    List<MateriaPrima> lstu = new ArrayList();

    public List<MateriaPrima> mostrarMateria() throws Exception {

        return null;
    }

    public void insertarMateria(MateriaPrima mat) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT into materiaprima values (?,?,?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, mat.getIdMateria());
            pre.setString(2, mat.getMatUsado());
            pre.setString(3, mat.getNombre());
            pre.setDouble(4, mat.getPrecioUnitario());
            pre.setString(5, mat.getExistencia());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    public void modificarMateria (MateriaPrima mat) throws Exception{
        try{
            this.conectar();
            String sql="UPDATE materiaprima set mat_uilizado='?',"
                    + "nombre='?',precioUnidad='?',existencia='?' "
                    + "WHERE idMaterial='?'";
            
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, mat.getMatUsado());
            pre.setString(2, mat.getNombre());
            pre.setDouble(3, mat.getPrecioUnitario());
            pre.setString(4, mat.getExistencia());
            pre.setInt(5, mat.getIdMateria());
                    
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
       public void eliminarMateria(MateriaPrima mat) throws Exception{
        try {
            int var= JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar el "
                    + "registro?", "Confirmacion", JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE);
            if (var == JOptionPane.YES_OPTION) {
                this.conectar();
                String sql = "delete from materiaprima where idMaterial='?'";
                PreparedStatement pre = this.getCon().prepareStatement(sql);
                pre.setInt(1, mat.getIdMateria());
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
