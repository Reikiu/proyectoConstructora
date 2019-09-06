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
public class DaoMaquinaria extends Conexion{

    public List<Maquinaria> mostrarProyecto() throws Exception{
        ResultSet rs;
        List<Maquinaria> lis = new ArrayList();
        
        try{
            this.conectar();
            String sql = "Select * from usuario";
            PreparedStatement pst= this.getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                Maquinaria ma = new Maquinaria();
                ma.setIdMaquinaria(rs.getInt("idMateria"));
                ma.setNombreMaquinaria(rs.getString("nombreMaquinaria"));
                ma.setTipoMaquinaria(rs.getString("tipoMaquinaria"));
                ma.setModelo(rs.getString("modelo"));
                ma.setAnioAdquirido(rs.getInt("anioAdquirido"));
                ma.setEstado(rs.getString("estado"));
                lis.add(ma);
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, "Error "+e.toString());
        }finally{
            this.desconectar();
        }
        return lis;
    }
    
    public void insertarMaquinaria(Maquinaria ma) throws Exception{
        try{
            this.conectar();
            ResultSet rs1;
            String sql1 = "Select * from maquinaria";
            PreparedStatement pst1 = this.getCon().prepareStatement(sql1);
            rs1 = pst1.executeQuery();
            int i = 0;
            while (rs1.next()) {
                if (rs1.getInt("idMaquinaria") > i) {
                    i = rs1.getInt("idMaquinaria");
                }
            }
            i = i + 1;
            String sql = "INSERT into maquinaria values (?,?,?,?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, i);
            pre.setString(2, ma.getNombreMaquinaria());
            pre.setString(3, ma.getTipoMaquinaria());
            pre.setString(4, ma.getModelo());
            pre.setInt(5, ma.getAnioAdquirido());
            pre.setString(6, ma.getEstado());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    public void modificarMaquinaria (Maquinaria ma) throws Exception{
        try{
            this.conectar();
            String sql="UPDATE maquinaria set nombreMaquinaria='?',"
                    + "tipoMaquinaria='?',modelo='?',anioAdquirido='?',"
                    + "estado='?' WHERE idMaquinaria='?'";
            
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, ma.getNombreMaquinaria());
            pre.setString(2, ma.getTipoMaquinaria());
            pre.setString(3, ma.getModelo());
            pre.setInt(4, ma.getAnioAdquirido());
            pre.setString(5, ma.getEstado());
            pre.setInt(6, ma.getIdMaquinaria());
                    
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    public void eliminarMaquinaria(Maquinaria ma) throws Exception{
        try {
            int var= JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar el "
                    + "registro?", "Confirmacion", JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE);
            if (var == JOptionPane.YES_OPTION) {
                this.conectar();
                String sql = "delete from maquinaria where idMaquinaria='?'";
                PreparedStatement pre = this.getCon().prepareStatement(sql);
                pre.setInt(1, ma.getIdMaquinaria());
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
