package Entidades;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author ang14ped16
 */
public class DaoMaquinaria extends Conexion{
    List<Maquinaria> lstu = new ArrayList();
    
    public List<Maquinaria> mostrarMaquinaria() throws Exception{
        
        return null;
    }
    
    public void insertarMaquinaria(Maquinaria ma) throws Exception{
        try{
            this.conectar();
            String sql = "INSERT into maquinaria values (?,?,?,?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, ma.getIdMaquinaria());
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
}
