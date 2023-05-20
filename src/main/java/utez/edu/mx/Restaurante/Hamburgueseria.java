package utez.edu.mx.Restaurante;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utez.edu.mx.Mesa.Plato;
import utez.edu.mx.Personas.Cocinero;
import utez.edu.mx.Personas.Mesero;
import utez.edu.mx.Restaurante.Controllers.LoginController;
import utez.edu.mx.Mesa.Alimento;
import java.io.IOException;
import java.util.ArrayList;
public class Hamburgueseria extends Application {
    public static int i;
    private static final ArrayList<Plato> carta = new ArrayList<>();
    private static  final ArrayList<String> usuarios = new ArrayList<>();
    private static  final ArrayList<String> contras = new ArrayList<>();

    private static final ArrayList<Cocinero> cocineros = new ArrayList<>();
    private static final ArrayList<Mesero> meseros = new ArrayList<>();

    public static void main(String[] args){
        usuarios.add("Mauro");
        contras.add("1234");
        usuarios.add("s");
        contras.add("s");
        usuarios.add("Lauro");
        contras.add("1234");
        usuarios.add("Derick Pro");
        contras.add("pornite");
        usuarios.add("Shago");
        contras.add("c2332c");

        Alimento lechuga = new Alimento("Lechuga", "Vegetal");
        Plato marmolBurguer = new Plato("MarmolBurger", "gigante", "Hamburguesa", 3.4);
        Plato coca = new Plato("Coca", "gigante", "Bebida", 4.8);
        carta.add(marmolBurguer);
        carta.add(coca);
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(Hamburgueseria.class.getResource("login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Login");
        stage.setScene(scene);
        LoginController controller = loader.getController();
        controller.setStage(stage);
        stage.show();
    }

    public static boolean login(String usuario, String contra) {
        for (i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).equals(usuario) && contras.get(i).equals(contra)) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<String> getUsuarios() {
        return usuarios;
    }

    public static void setUsuario(String user){
        usuarios.add(user);
    }

    public static ArrayList<String> getContras() {
        return contras;
    }

    public static void setContra(String pass) {
        contras.add(pass);
    }

    public static ArrayList<Plato> getCarta(){
        return carta;
    }

}