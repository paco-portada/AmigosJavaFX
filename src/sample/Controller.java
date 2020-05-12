package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author JJBH
 */
public class Controller implements Initializable {

    @FXML
    public Label label;

    @FXML
    public Label etiqueta;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @FXML
    private void handleButtonAction2(ActionEvent event) {
        System.out.println("Pulsado el segundo botón!");
        label.setText("Hola bambino!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void accionIncremento(ActionEvent actionEvent) {
        int numero = Integer.parseInt(etiqueta.getText());
        numero ++;
        etiqueta.setText(String.valueOf(numero));
    }
}