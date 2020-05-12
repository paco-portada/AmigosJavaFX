package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ShowFriendsController implements Initializable {

    public static final String FICHERO = "recursos/personas.txt";
    File fichero;
    Scanner scanner;
    String linea;

    @FXML public TextArea textAmigos;
    @FXML public Button botonCerrar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        textAmigos.setEditable(false);

        try {
            fichero = new File(FICHERO);
            scanner = new Scanner(fichero);
            while (scanner.hasNextLine()) {
                linea = scanner.nextLine();
                textAmigos.appendText(linea + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    @FXML
    public void accionCerrar(ActionEvent actionEvent) {
        Stage stage = (Stage) botonCerrar.getScene().getWindow();
        stage.close();
    }
}
