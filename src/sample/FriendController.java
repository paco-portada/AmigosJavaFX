package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class FriendController implements Initializable {

    public static final String FICHERO = "recursos/personas.txt";

    @FXML public TextField textNombre;
    @FXML public TextField textMovil;
    @FXML public TextField textEmail;
    @FXML public ComboBox cuadroCiudad;
    @FXML public DatePicker dpFecha;
    @FXML public TextArea textResultado;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cuadroCiudad.getItems().addAll("Málaga", "Sevilla", "Córdoba", "Granada", "Huelva", "Cádiz", "Almería", "Jaen");
        cuadroCiudad.setValue("Málaga");

        dpFecha.setValue(LocalDate.parse("2000-05-11"));
    }
    @FXML
    public void accionGuardar(ActionEvent actionEvent) {
        String nombre = textNombre.getText();
        String movil = textMovil.getText();
        String email = textEmail.getText();
        String ciudad = cuadroCiudad.getValue().toString();
        LocalDate nacimiento;
        Persona persona;
        FileWriter out = null;

        nacimiento = dpFecha.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        nacimiento.format(formatter);

        persona = new Persona(nombre, movil, email, ciudad, nacimiento);

        try {
            out = new FileWriter(FICHERO, true);
            out.write(persona.toString() + "\n");
            textResultado.appendText(persona.toString() + "\n");
            textResultado.appendText("Datos guardados OK \n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    public void accionVer(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("showfriends.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            // stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Lista de amigos");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
