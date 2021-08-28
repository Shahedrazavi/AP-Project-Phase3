package ui.opening;

import event.opening.OpeningEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import listener.opening.OpeningListener;
import ui.FXMLController;

import java.net.URL;
import java.util.ResourceBundle;

public class OpeningPageFXMLController extends FXMLController {

    private OpeningListener openingListener;

    private OpeningPage page;
    
    @FXML
    private Label label;

    @FXML
    private Button signInButton;

    @FXML
    private Button signUpButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void setPage(OpeningPage page){
        this.page = page;
    }

    public void setListener() {
        openingListener = new OpeningListener(page.getGraphicalAgent());
    }

    @FXML
    void signInPressed(ActionEvent event) {
        openingListener.eventOccurred(new OpeningEvent(this,"signingIn"));
    }

    @FXML
    void signUpPressed(ActionEvent event) {
        openingListener.eventOccurred(new OpeningEvent(this,"registration"));
    }
}