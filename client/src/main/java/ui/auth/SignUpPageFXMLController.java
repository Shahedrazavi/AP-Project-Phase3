package ui.auth;

import event.auth.registration.RegistrationFormEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import ui.FXMLController;
import ui.GraphicalAgent;
import ui.auth.registration.RegistrationPage2FXMLController;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpPageFXMLController extends FXMLController {

    private SignUpPage page;

    @FXML
    private AnchorPane backButton;

    @FXML
    private AnchorPane registrationSection;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void makeContents(){
        setBackButton();
        setRegistrationSection();
    }

    public void setPage(SignUpPage page) {
        this.page = page;
    }

    public void setBackButton(){
        backButton.getChildren().add(page.getBackButton().getRoot());
    }

    public void setRegistrationSection(){
        registrationSection.getChildren().add(page.getPage1().getRoot());
    }

    public void goToPage2(RegistrationFormEvent primaryEvent){
        registrationSection.getChildren().clear();
        registrationSection.getChildren().add(page.getPage2().getRoot());
        ((RegistrationPage2FXMLController)page.getPage2().getFxmlController()).initializePrimaryEvent(primaryEvent);
    }

    public void backToOpeningPage(){
        page.getGraphicalAgent().goToOpeningPage();
    }

}
