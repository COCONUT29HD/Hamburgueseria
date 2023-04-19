
package utez.edu.mx.Personas;

public class Cocinero extends Empleado{
    private String certificacion;

    public Cocinero() {
    }
public Cocinero(String nombre, int edad, double salario, String rfc, String nacionalidad, int horasTrabajo, String certificacion) {
        super(nombre, edad, salario, rfc, nacionalidad, horasTrabajo);
        this.certificacion = certificacion;
    }

    public String getCertificacion() {
        return certificacion;
    }

    public void setCertificacion(String certificacion) {
        this.certificacion = certificacion;
    }
    

}
