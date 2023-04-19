package utez.edu.mx.Restaurante.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import utez.edu.mx.Mesa.Plato;
import utez.edu.mx.Restaurante.*;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class CartaUserController implements Initializable {
    private  Stage stage;
    private UserMenuController userMenuController;
    private LoginController loginController;
    @FXML
    private Label messsageProduct;
    @FXML
    private Label userName;
    @FXML
    private TableView <Plato> tablaCarta;
    @FXML
    private TableColumn columnNombre, columnTamanio, columnTipo, columnPrecio;


    @FXML
    private ObservableList <Plato> carta;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        carta = FXCollections.observableArrayList();

        columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnTamanio.setCellValueFactory(new PropertyValueFactory<>("tamanio"));
        columnTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        columnPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        for (int i = 0; i < Hamburgueseria.getCarta().size(); i++) {
            carta.add(Hamburgueseria.getCarta().get(i));
            tablaCarta.setItems(carta);
        }
    }


    @FXML
    private void addOrden(){
        Plato p = this.tablaCarta.getSelectionModel().getSelectedItem();

        if(p == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Warning");
            alert.setHeaderText("Error");
            alert.setContentText("Debes seleccionar un producto");
            alert.showAndWait();
        }else{
            OrdenUserController.setOrden(p);
            messsageProduct.setAlignment(Pos.CENTER);
            messsageProduct.setText("El producto ha sido agregado a su orden");
        }
    }

    @FXML
    private void logoutButton(){
        stage.close();
        loginController.show();
        OrdenUserController.getProductos().clear();
        OrdenUserController.getAux().clear();
    }
    @FXML
    private void ordenButton() throws IOException {
        FXMLLoader loader = new FXMLLoader(Hamburgueseria.class.getResource("ordenUsuario.fxml"));
        Parent root = loader.load();
        Scene ordenScene = new Scene(root);
        Stage ordenStage = new Stage();
        ordenStage.setScene(ordenScene);
        OrdenUserController userController = loader.getController();
        userController.setStage(ordenStage, loginController, userMenuController, this);
        stage.close();
        ordenStage.show();
    }

    @FXML
    private void inicioButton(){
        stage.close();
        userMenuController.show();
    }
    public void setStage(Stage stage, UserMenuController userMenuController, LoginController loginController) {
        this.userMenuController = userMenuController;
        this.loginController = loginController;
        this.stage = stage;
        userName.setText(Hamburgueseria.getUsuarios().get(Hamburgueseria.i));
    }
    public void show(){
        stage.show();
    }
}
