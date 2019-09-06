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

    public List<MateriaPrima> mostrarMateria() throws Exception{
        ResultSet rs;
        List<MateriaPrima> list = new ArrayList();
        
        try{
            this.conectar();
            String sql = "Select * from materiaPrima";
            PreparedStatement pst= this.getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                MateriaPrima mat = new MateriaPrima();
                mat.setIdMateria(rs.getInt("idMaterial"));
                mat.setNombre(rs.getString("nombre"));
                mat.setPrecioUnitario(rs.getDouble("precioUnidad"));
                mat.setExistencia(rs.getString("existencia"));
                list.add(mat);
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, "Error "+e.toString());
        }finally{
            this.desconectar();
        }
        return list;
    }

    public void insertarMateria(MateriaPrima mat) throws Exception {
        try {
            this.conectar();
            ResultSet rs1;
            String sql1 = "Select * from materiaprima";
            PreparedStatement pst1 = this.getCon().prepareStatement(sql1);
            rs1 = pst1.executeQuery();
            int i = 0;
            while (rs1.next()) {
                if (rs1.getInt("idMaterial") > i) {
                    i = rs1.getInt("idMaterial");
                }
            }
            i = i + 1;
            String sql = "INSERT into materiaprima values (?,?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, i);
            pre.setString(2, mat.getNombre());
            pre.setDouble(3, mat.getPrecioUnitario());
            pre.setString(4, mat.getExistencia());
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
            pre.setString(1, mat.getNombre());
            pre.setDouble(2, mat.getPrecioUnitario());
            pre.setString(3, mat.getExistencia());
            pre.setInt(4, mat.getIdMateria());
                    
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
