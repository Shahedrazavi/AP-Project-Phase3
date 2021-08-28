package ui.component.backButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import ui.FXMLController;
import ui.GraphicalAgent;

import java.net.URL;
import java.util.ResourceBundle;

public class BackButtonFXMLController extends FXMLController implements Initializable {

    private BackButton component;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private Button backButton;

    public void setComponent(BackButton component) {
        this.component = component;
    }

    @FXML
    void backPressed(ActionEvent event) {
        component.getGraphicalAgent().goToOpeningPage();
    }
}
