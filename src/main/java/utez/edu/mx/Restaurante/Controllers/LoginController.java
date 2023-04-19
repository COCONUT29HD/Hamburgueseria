package utez.edu.mx.Restaurante.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utez.edu.mx.Restaurante.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController{
    private Stage stage;
    @FXML
    private TextField user, password;
    @FXML
    private Label message;

    @FXML
    public void onLoginButtonClick() throws IOException {
        if(user.getText().isEmpty() || password.getText().isEmpty()){
            message.setText("No pueden quedar campos vacios");
        }else{
            if(Hamburgueseria.login(user.getText().trim(), password.getText().trim())){
                limpiar();
                FXMLLoader fmxloader =new FXMLLoader (Hamburgueseria.class.getResource("userMenu.fxml"));
                Parent root = fmxloader.load();
                Scene scene = new Scene(root);
                Stage menustage = new Stage();
                menustage.setScene(scene);
                UserMenuController menuController = fmxloader.getController();
                menuController.setStage(menustage, this);
                stage.close();
                menustage.show();
            }else if(user.getText().equals("c") && password.getText().equals("c")){
                limpiar();
                FXMLLoader loader = new FXMLLoader(Hamburgueseria.class.getResource("adminMenu.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                AdminMenuController adminMenuControllercontroller = loader.getController();
                adminMenuControllercontroller.setStage(stage, this);
                stage.show();
                this.stage.close();
            }else{
                message.setText("Usuario o contrasenia incorrectos");
            }
        }
    }

    public void onRegisterButtonClick()throws IOException{
        limpiar();
        FXMLLoader loader = new FXMLLoader(Hamburgueseria.class.getResource("register.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        RegisterController registerController = loader.getController();
        registerController.setStage(stage, this);
        stage.show();
        this.stage.close();
    }
    @FXML
    public void messageClean(){
        message.setText("");
    }
    @FXML
    public void clean(){
       limpiar();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void show(){
        stage.show();
    }
    public void limpiar(){
        user.clear();
        password.clear();
        message.setText("");
    }

}

