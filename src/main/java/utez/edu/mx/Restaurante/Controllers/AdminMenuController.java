package utez.edu.mx.Restaurante.Controllers;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class AdminMenuController {
    private Stage stage;
    private LoginController loginController;

    @FXML
    private void logoutButton(){
        loginController.show();
        stage.close();
    }

    public void setStage(Stage stage, LoginController loginController){
        this.loginController = loginController;
        this.stage = stage;
    }
}
