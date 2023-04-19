
package utez.edu.mx.Personas;

public class Empleado extends Persona{
    private double salario;
    private String rfc;
    private String nacionalidad;
    private int horasTrabajo;

    public Empleado() {
    }

    public Empleado(String nombre, int edad, double salario, String rfc, String nacionalidad, int horasTrabajo) {
        super(nombre, edad);
        this.salario = salario;
        this.rfc = rfc;
        this.nacionalidad = nacionalidad;
        this.horasTrabajo = horasTrabajo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getHorasTrabajo() {
        return horasTrabajo;
    }

    public void setHorasTrabajo(int horasTrabajo) {
        this.horasTrabajo = horasTrabajo;
    }
    
    
    
}
