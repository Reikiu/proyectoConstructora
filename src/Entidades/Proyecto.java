package Entidades;

/**
 * @author ang14ped16
 */
public class Proyecto {
    private int idProyecto;
    private int idCliente;
    private String nombre;
    private int factura;
    private String estadoProyecto;
    private String fechaInicio;
    private String fechaFin;
    private int montoEmpleado;
    private String direccion;
    private int montoMaquinaria;
    private int montoMateia;
    private double montoTotal;

    public Proyecto() {
    }

    public Proyecto(int idProyecto, int idCliente, String nombre, int factura, String estadoProyecto, String fechaInicio, String fechaFin, int montoEmpleado, String direccion, int montoMaquinaria, int montoMateia, double montoTotal) {
        this.idProyecto = idProyecto;
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.factura = factura;
        this.estadoProyecto = estadoProyecto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.montoEmpleado = montoEmpleado;
        this.direccion = direccion;
        this.montoMaquinaria = montoMaquinaria;
        this.montoMateia = montoMateia;
        this.montoTotal = montoTotal;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFactura() {
        return factura;
    }

    public void setFactura(int factura) {
        this.factura = factura;
    }

    public String getEstadoProyecto() {
        return estadoProyecto;
    }

    public void setEstadoProyecto(String estadoProyecto) {
        this.estadoProyecto = estadoProyecto;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getMontoEmpleado() {
        return montoEmpleado;
    }

    public void setMontoEmpleado(int montoEmpleado) {
        this.montoEmpleado = montoEmpleado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getMontoMaquinaria() {
        return montoMaquinaria;
    }

    public void setMontoMaquinaria(int montoMaquinaria) {
        this.montoMaquinaria = montoMaquinaria;
    }

    public int getMontoMateia() {
        return montoMateia;
    }

    public void setMontoMateia(int montoMateia) {
        this.montoMateia = montoMateia;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
    
    
}
