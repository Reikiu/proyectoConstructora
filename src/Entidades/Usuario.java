/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 * Clase: Usuario. (Para registrar Usuarios)
 * Fecha: 03/09/2019
 * @author Amilcar Hernandez
 */
public class Usuario {
    private int idUsuario;
    private String usuario;
    private String password;
    private int tipoUsuario;

    public Usuario() {
    }

    public Usuario(int idUsuario, String usuario, String password, int tipoUsuario) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
