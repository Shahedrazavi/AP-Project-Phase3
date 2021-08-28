package ui.auth.signIn;

import event.auth.signIn.SignInFormEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import listener.auth.signIn.SignInFormListener;
import model.User;
import response.auth.signIn.SignInResponse;
import ui.FXMLController;
import ui.auth.SignInPageFXMLController;

import java.net.URL;
import java.util.ResourceBundle;

public class SignInCenterFXMLController extends FXMLController{

    SignInFormListener listener;

    private SignInCenter component;

    @FXML
    private AnchorPane backButton;

    @FXML
    private Label signInLabel;

    @FXML
    private Button signInButton;

    @FXML
    private TextField usernameBox;

    @FXML
    private TextField passwordBox;

    @FXML
    private Label errorLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorLabel.setVisible(false);

        listener = new SignInFormListener(component.getGraphicalAgent());
    }

    @Override
    public void makeContents() {
        setBackButton();
    }

    public void setBackButton(){
        backButton.getChildren().add(component.getBackButton().getRoot());
    }

    public void setComponent(SignInCenter component) {
        this.component = component;
    }

    @FXML
    void signInPressed(ActionEvent event) {
        listener.eventOccurred(new SignInFormEvent(this,usernameBox.getText(), passwordBox.getText()));
    }

    public void finalizeComp(SignInResponse response){
        if (response.isValid()){
            goToHomePage();
        }
        else {
            setErrors(response);
        }
    }

    public Label getErrorLabel() {
        return errorLabel;
    }

    public void goToHomePage(User loggedInUser){
        ((SignInPageFXMLController)component.getParent().getFxmlController()).goToHomePage(loggedInUser);
    }
}
