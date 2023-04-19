package utez.edu.mx.Personas;


public class Mesero extends Empleado {

    private int idMesero;

    public Mesero() {
    }

    public Mesero(String nombre, int edad, double salario, String rfc, String nacionalidad, int horasTrabajo, int idMesero) {
        super(nombre, edad, salario, rfc, nacionalidad, horasTrabajo);
        this.idMesero = idMesero;
    }

    public int getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(int idMesero) {
        this.idMesero = idMesero;
    }

    public void traerOrden() {

    }

    public void entregarCuenta() {

    }
}
