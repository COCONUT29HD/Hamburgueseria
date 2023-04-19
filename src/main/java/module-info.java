module utez.edu.mx.hamburgueseria {
    requires javafx.controls;
    requires javafx.fxml;


    opens utez.edu.mx.Restaurante to javafx.fxml;
    exports utez.edu.mx.Restaurante;
    exports utez.edu.mx.Restaurante.Controllers;
    opens utez.edu.mx.Restaurante.Controllers to javafx.fxml;
    exports utez.edu.mx.Mesa;
    opens utez.edu.mx.Mesa to javafx.fxml;
}