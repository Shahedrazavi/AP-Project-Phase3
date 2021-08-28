package ui.auth.registration;

import event.auth.registration.RegistrationFormEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import listener.auth.registration.RegistrationFormListener1;
import response.auth.registration.RegPage1Response;
import ui.FXMLController;
import ui.auth.SignUpPageFXMLController;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class RegistrationPage1FXMLController extends FXMLController {

    private RegistrationFormListener1 listener;

    private LinkedList<Label> pageEmptyErrors = new LinkedList<>();

    private LinkedList<Label> pageErrors = new LinkedList<>();

    private RegistrationPage1 component;

    private RegistrationFormEvent formEvent;

    @FXML
    private Label enterInformationLabel;

    @FXML
    private Label willBeUsernameLabel;

    @FXML
    private TextField firstNameBox;

    @FXML
    private TextField lastNameBox;

    @FXML
    private TextField emailBox;

    @FXML
    private TextField usernameBox;

    @FXML
    private TextField passwordBox;

    @FXML
    private TextField passwordConfirmationBox;

    @FXML
    private Button proceedButton;

    @FXML
    private Label emailError;

    @FXML
    private Label usernameError;

    @FXML
    private Label passwordError;

    @FXML
    private Label firstNameEmpty;

    @FXML
    private Label lastNameEmpty;

    @FXML
    private Label emailEmpty;

    @FXML
    private Label usernameEmpty;

    @FXML
    private Label passwordEmpty;

    @FXML
    private Label password2Empty;

    public Label getEmailError() {
        return emailError;
    }

    public Label getUsernameError() {
        return usernameError;
    }

    public Label getPasswordError() {
        return passwordError;
    }

    public Label getFirstNameEmpty() {
        return firstNameEmpty;
    }

    public Label getLastNameEmpty() {
        return lastNameEmpty;
    }

    public Label getEmailEmpty() {
        return emailEmpty;
    }

    public Label getUsernameEmpty() {
        return usernameEmpty;
    }

    public Label getPasswordEmpty() {
        return passwordEmpty;
    }

    public Label getPassword2Empty() {
        return password2Empty;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        emailError.setVisible(false);
        usernameError.setVisible(false);
        passwordError.setVisible(false);
        firstNameEmpty.setVisible(false);
        lastNameEmpty.setVisible(false);
        emailEmpty.setVisible(false);
        usernameEmpty.setVisible(false);
        passwordEmpty.setVisible(false);
        password2Empty.setVisible(false);

        pageErrors.add(passwordError);
        pageErrors.add(emailError);
        pageErrors.add(usernameError);

        pageEmptyErrors.add(firstNameEmpty);
        pageEmptyErrors.add(lastNameEmpty);
        pageEmptyErrors.add(emailEmpty);
        pageEmptyErrors.add(usernameEmpty);
        pageEmptyErrors.add(passwordEmpty);
        pageEmptyErrors.add(password2Empty);

    }

    public void setListener(){
        this.listener = new RegistrationFormListener1(component.getGraphicalAgent());
    }

    public void showLabel(Label label){
        label.setVisible(true);
    }
    public void hideLabel(Label label){
        label.setVisible(false);
    }

    public LinkedList<Label> getPageEmptyErrors() {
        return pageEmptyErrors;
    }

    public void setComponent(RegistrationPage1 component) {
        this.component = component;
    }

    public void finalizePage(RegPage1Response response){
        if (response.isValid()){
            goToPage2();
        }
        else {
            setErrors(response);
        }
    }

    private void setErrors(RegPage1Response response){
        if (response.isBlank()){
            for (int i = 0 ; i < 6 ; i++){
                if (!response.getEmptyErrorLabels().get(i)){
                    showLabel(pageEmptyErrors.get(i));
                }
                else {
                    hideLabel(pageEmptyErrors.get(i));
                }
            }
        }
        else {
            for (int i = 0 ; i < 3  ;i++){
                if (!response.getErrorLabels().get(i)){
                    showLabel(pageErrors.get(i));
                }
                else {
                    hideLabel(pageErrors.get(i));
                }
            }
        }
    }

    public void goToPage2(){
        System.out.println("going to page 2");
        ((SignUpPageFXMLController)component.getParent().getFxmlController()).goToPage2(formEvent);
    }

    @FXML
    void proceedPressed(ActionEvent event) {
        String firstName = firstNameBox.getText();
        String lastName = lastNameBox.getText();
        String email = emailBox.getText();
        String username = usernameBox.getText();
        String password1 = passwordBox.getText();
        String password2 = passwordConfirmationBox.getText();
        formEvent = new RegistrationFormEvent(this, firstName,lastName,email,username,password1,password2);
        listener.eventOccurred(formEvent);
    }
}
