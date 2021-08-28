package ui.auth.registration;

import event.auth.registration.RegistrationFormEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import listener.auth.registration.RegistrationFormListener2;
import response.auth.registration.RegPage2Response;
import ui.FXMLController;
import ui.auth.SignUpPageFXMLController;

import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationPage2FXMLController extends FXMLController {

    private RegistrationFormListener2 listener;

    private RegistrationPage2 component;

    private RegistrationFormEvent primaryEvent;

    @FXML
    private Label enterInformationLabel;

    @FXML
    private Label setLaterLabel;

    @FXML
    private Label willBeUsernameLabel;

    @FXML
    private Label birthdayError;

    @FXML
    private TextField phoneNumberBox;

    @FXML
    private TextField bdYearBox;

    @FXML
    private TextField bdMonthBox;

    @FXML
    private TextField bdDayBox;

    @FXML
    private TextField profileNameBox;

    @FXML
    private Button createButton;

    public Label getBirthdayError() {
        return birthdayError;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        birthdayError.setVisible(false);
        System.out.println("created page2");
    }

    public void initializePrimaryEvent(RegistrationFormEvent primaryEvent){
        this.primaryEvent = primaryEvent;
    }

    public void setComponent(RegistrationPage2 component) {
        this.component = component;
    }

    public void setListener(){
        listener = new RegistrationFormListener2(component.getGraphicalAgent());
    }

    public void finalizePage(RegPage2Response response){
        if (response.isValid()){
            backToOpeningPage();
        }
        else {
            setErrors(response);
        }
    }

    private void setErrors(RegPage2Response response){
        birthdayError.setVisible(!response.isValid());
    }

    public void backToOpeningPage(){
        ((SignUpPageFXMLController)component.getParent().getFxmlController()).backToOpeningPage();
    }

    @FXML
    void createPressed(ActionEvent event) {
        primaryEvent.setPhoneNumber(phoneNumberBox.getText());
        primaryEvent.setBirthdayYear(bdYearBox.getText());
        primaryEvent.setBirthdayMonth(bdMonthBox.getText());
        primaryEvent.setBirthdayDay(bdDayBox.getText());
        primaryEvent.setProfileName(profileNameBox.getText());
        primaryEvent.setLevel(RegistrationFormEvent.RegFormEventLevel.LAST);
        primaryEvent.setSource(this);
        listener.eventOccurred(primaryEvent);
    }

}
