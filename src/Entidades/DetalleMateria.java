package Entidades;

/**
 *
 * @author ang14ped16
 */
public class DetalleMateria {

    private int idProyecto;
    private int idMateria;
    private double cantidad;

    public DetalleMateria() {
    }

    public DetalleMateria(int idProyecto, int idMateria, double cantidad) {
        this.idProyecto = idProyecto;
        this.idMateria = idMateria;
        this.cantidad = cantidad;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

}
