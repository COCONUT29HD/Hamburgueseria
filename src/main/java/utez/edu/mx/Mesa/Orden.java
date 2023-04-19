package utez.edu.mx.Mesa;

public class Orden extends Plato {

    private int cantidad;

    public Orden(){
    }

    public Orden(int numero) {
        this.cantidad = numero;
    }

    public Orden(String nombre, String tamanio, String tipo, double precio, int cantidad){
        super(nombre, tamanio, tipo, precio);
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }



}
