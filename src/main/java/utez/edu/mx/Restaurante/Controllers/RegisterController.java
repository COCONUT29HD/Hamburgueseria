package utez.edu.mx.Restaurante.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utez.edu.mx.Restaurante.Hamburgueseria;

public class RegisterController {
    private Stage stage;
    @FXML
    private TextField user, password;
    @FXML
    private Label message, message2;
    private LoginController loginController;



    public void setStage(Stage stage, LoginController loginController) {
        this.loginController = loginController;
        this.stage = stage;
    }
    @FXML
    public void Register() {

        if(Hamburgueseria.getUsuarios().contains(user.getText().trim()) || user.getText().equals("Admin")){
            message.setText("   El usuario ya existe, escoge otro nombre");
        }else if(user.getText().trim().isEmpty() || password.getText().trim().isEmpty()){
            message.setText("              No puedes dejar campos vacios");
        }else if(user.getText().trim().length() > 15 || !esSoloLetras(user.getText()) || user.getText().trim().length() < 2){
            message2.setText("Usario debe tener de 2 a 15 letras, sin numeros");
        }else if(password.getText().trim().length()>8 || password.getText().trim().length() < 4){
            message.setText("Contraseña debe tener de 4 a 8 caracteres");
        }else{
            Hamburgueseria.setUsuario(user.getText().trim());
            Hamburgueseria.setContra(password.getText().trim());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Confirmacion");
            alert.setHeaderText("INICIO DE SESION ");
            alert.setContentText("Ya pueddes iniciar sesion");
            alert.showAndWait();
            limpiar();
            loginController.show();
            stage.close();
        }


    }
    @FXML
    public void cancel(){
        loginController.show();
        stage.close();
    }

    @FXML
    public void clean(){
        limpiar();
    }
    public static boolean esSoloLetras(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            if(caracter == ' '){
                continue;
            }
            if (!Character.isLetter(caracter)) {
                return false;
            }
        }
        return true;
    }
    @FXML
    public void messageClean(){
        message.setText("");
    }

    private void limpiar(){
        user.clear();
        password.clear();
        message.setText("");
        message2.setText("");
    }
}
