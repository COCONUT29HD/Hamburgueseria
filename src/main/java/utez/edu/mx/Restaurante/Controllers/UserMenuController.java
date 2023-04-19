package utez.edu.mx.Restaurante.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.stage.Stage;

import utez.edu.mx.Restaurante.Hamburgueseria;

import java.io.IOException;


public class UserMenuController {
    private Stage stage;
    private LoginController loginController;

    @FXML
    private Label userName;




    @FXML
    public void logoutButton(){
        loginController.show();
        stage.close();
        OrdenUserController.getProductos().clear();
        OrdenUserController.getAux().clear();
    }

    @FXML
    private void cartaButton() throws IOException {
        FXMLLoader loader = new FXMLLoader(Hamburgueseria.class.getResource("cartaUser.fxml"));
        Parent root = loader.load();
        Scene cartaScene = new Scene(root);
        Stage cartaStage = new Stage();
        cartaStage.setScene(cartaScene);
        CartaUserController cartaUserController = loader.getController();
        cartaUserController.setStage(cartaStage, this, loginController);
        stage.close();
        cartaStage.show();
    }




    public void setStage(Stage stage, LoginController loginController){
        this.loginController = loginController;
        this.stage = stage;
        userName.setText(Hamburgueseria.getUsuarios().get(Hamburgueseria.i));
    }

    public void show(){
        stage.show();
    }
}
