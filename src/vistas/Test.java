/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Conexion.Conexion;
import javax.swing.JOptionPane;

/**
 *
 * @author aalej
 */
public class Test {

    public static void main(String[] args){
        Conexion con=new Conexion();
        
        JOptionPane.showMessageDialog(null, con.conectar());
    }
}
