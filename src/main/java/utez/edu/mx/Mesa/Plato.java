
package utez.edu.mx.Mesa;

import java.util.ArrayList;

public class Plato {
    private String nombre;
    private String tamanio;
    private String tipo;
    private double precio;
    public Plato() {
    }

    public Plato(String nombre, String tamanio, String tipo, double precio) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.tipo = tipo;
        this.precio = precio;
    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }



    private ArrayList<Alimento> ingredientes = new ArrayList<Alimento>();



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ArrayList<Alimento> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Alimento> ingredientes) {
        this.ingredientes = ingredientes;
    }

}
