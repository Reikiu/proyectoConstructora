package Entidades;

/**
 * @author ang14ped16
 */
public class MateriaPrima {
    private int idMateria;
    private String matUsado;
    private String nombre;
    private double precioUnitario;
    private String existencia;

    public MateriaPrima() {
    }

    public MateriaPrima(int idMateria, String matUsado, String nombre, double precioUnitario, String existencia) {
        this.idMateria = idMateria;
        this.matUsado = matUsado;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.existencia = existencia;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getMatUsado() {
        return matUsado;
    }

    public void setMatUsado(String matUsado) {
        this.matUsado = matUsado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getExistencia() {
        return existencia;
    }

    public void setExistencia(String existencia) {
        this.existencia = existencia;
    }
    
    
    
}
