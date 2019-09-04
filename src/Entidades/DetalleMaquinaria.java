package Entidades;

/**
 *
 * @author ang14ped16
 */
public class DetalleMaquinaria {

    private int idProyecto;
    private int idMaquinaria;
    private int cantidad;

    public DetalleMaquinaria() {
    }

    public DetalleMaquinaria(int idProyecto, int idMaquinaria, int cantidad) {
        this.idProyecto = idProyecto;
        this.idMaquinaria = idMaquinaria;
        this.cantidad = cantidad;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public int getIdMaquinaria() {
        return idMaquinaria;
    }

    public void setIdMaquinaria(int idMaquinaria) {
        this.idMaquinaria = idMaquinaria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
