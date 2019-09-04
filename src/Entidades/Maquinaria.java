
package Entidades;

/**
 * @author ang14ped16
 */
public class Maquinaria {
    private int idMaquinaria;
    private String nombreMaquinaria;
    private String tipoMaquinaria;
    private String modelo;
    private int anioAdquirido;
    private String estado;

    public Maquinaria() {
    }

    public Maquinaria(int idMaquinaria, String nombreMaquinaria, String tipoMaquinaria, String modelo, int anioAdquirido, String estado) {
        this.idMaquinaria = idMaquinaria;
        this.nombreMaquinaria = nombreMaquinaria;
        this.tipoMaquinaria = tipoMaquinaria;
        this.modelo = modelo;
        this.anioAdquirido = anioAdquirido;
        this.estado = estado;
    }

    public int getIdMaquinaria() {
        return idMaquinaria;
    }

    public void setIdMaquinaria(int idMaquinaria) {
        this.idMaquinaria = idMaquinaria;
    }

    public String getNombreMaquinaria() {
        return nombreMaquinaria;
    }

    public void setNombreMaquinaria(String nombreMaquinaria) {
        this.nombreMaquinaria = nombreMaquinaria;
    }

    public String getTipoMaquinaria() {
        return tipoMaquinaria;
    }

    public void setTipoMaquinaria(String tipoMaquinaria) {
        this.tipoMaquinaria = tipoMaquinaria;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnioAdquirido() {
        return anioAdquirido;
    }

    public void setAnioAdquirido(int anioAdquirido) {
        this.anioAdquirido = anioAdquirido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
