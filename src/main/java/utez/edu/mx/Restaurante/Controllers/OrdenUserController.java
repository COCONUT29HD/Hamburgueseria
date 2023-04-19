package utez.edu.mx.Restaurante.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import utez.edu.mx.Mesa.Orden;
import utez.edu.mx.Mesa.Plato;
import utez.edu.mx.Restaurante.Hamburgueseria;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class OrdenUserController implements Initializable{
    private Stage stage;
    private LoginController loginController;
    private UserMenuController userMenuController;
    private CartaUserController cartaUserController;
    private static final ArrayList<Plato> aux = new ArrayList<>();
    private static final ArrayList<Orden> productos = new ArrayList<>();
    @FXML
    private Label userName;
    private static double total = 0.0;
    @FXML
    private Label totaltext;
    @FXML
    private TableView<Orden> tablaOrden;
    @FXML
    private TableColumn columnNombre, columnTamanio, columnTipo, columnPrecio,columnCantidad;

    @FXML
    private final ObservableList<Orden> orden = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb){

        columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnTamanio.setCellValueFactory(new PropertyValueFactory<>("tamanio"));
        columnTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        columnPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        columnCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

        for (int i = 0; i < productos.size(); i++) {
            orden.add(productos.get(i));
            tablaOrden.setItems(orden);
        }

        totaltext.setText("Total: "+total);
    }
    public static void setOrden(Plato p){
        if(aux.contains(p)){
           int indice = aux.indexOf(p);
           int cantidad = productos.get(indice).getCantidad();
           productos.get(indice).setCantidad(cantidad+1);
           total+= productos.get(indice).getPrecio()*(productos.get(indice).getCantidad()-1);
       }else{
            aux.add(p);
            Orden producto = new Orden(p.getNombre(), p.getTamanio(),p.getTipo(),p.getPrecio(),1);
            productos.add(producto);
            int indice = productos.indexOf(producto);
            total+= productos.get(indice).getPrecio();
        }

    }

    @FXML
    private void deleteProduct(){
        Orden product = tablaOrden.getSelectionModel().getSelectedItem();

        if(product == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Warning");
            alert.setHeaderText("Error");
            alert.setContentText("Selecciona el producto a elimnar");
            alert.showAndWait();
        }else{
            if(product.getCantidad() > 1){
                int cantidad = product.getCantidad();
                product.setCantidad(cantidad-1);
                total -=product.getPrecio();
            }else{
                orden.remove(product);
                int indice = productos.indexOf(product);
                aux.remove(indice);
                total -=product.getPrecio();
                productos.remove(product);
            }
        }
        tablaOrden.refresh();
        totaltext.setText("Total: "+total);
    }



    @FXML
    private void payOrden(){

    }


    @FXML
    private void inicioButton(){
        stage.close();
        userMenuController.show();
    }

    @FXML
    private void cartaButton() {
        stage.close();
        cartaUserController.show();
    }


    @FXML
    public void logoutButton(){
        stage.close();
        loginController.show();
        getProductos().clear();
        getAux().clear();
    }

    public void setStage(Stage stage, LoginController loginController, UserMenuController userMenuController, CartaUserController cartaUserController){
        this.loginController = loginController;
        this.userMenuController = userMenuController;
        this.cartaUserController = cartaUserController;
        this.stage = stage;
        userName.setText(Hamburgueseria.getUsuarios().get(Hamburgueseria.i));
    }
    public static ArrayList<Plato> getAux(){
        return aux;
    }

    public static ArrayList<Orden> getProductos() {
        return productos;
    }
}
