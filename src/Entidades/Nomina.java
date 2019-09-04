package Entidades;

/**
 * Clase: Nomina. (Para nomina de emplados)
 * Fecha: 03/09/2019
 * @author Amilcar Hernandez
 */
public class Nomina {
    private int idNomina;
    private int horasTrabajadas;
    private int horasExtras;
    private double sueldo;
    private double anticipo;
    private int idEmpleado;

    public Nomina() {
    }

    public Nomina(int idNomina, int horasTrabajadas, int horasExtras, double sueldo, double anticipo, int idEmpleado) {
        this.idNomina = idNomina;
        this.horasTrabajadas = horasTrabajadas;
        this.horasExtras = horasExtras;
        this.sueldo = sueldo;
        this.anticipo = anticipo;
        this.idEmpleado = idEmpleado;
    }

    public int getIdNomina() {
        return idNomina;
    }

    public void setIdNomina(int idNomina) {
        this.idNomina = idNomina;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(double anticipo) {
        this.anticipo = anticipo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
    
}
