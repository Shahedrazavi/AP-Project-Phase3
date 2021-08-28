package ui.settings;

import config.Config;
import event.settings.ChangePassEvent;
import event.settings.ComboBoxEvent;
import event.settings.SettingsStringEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import listener.settings.ChangePassListener;
import listener.settings.ComboBoxListener;
import listener.settings.SettingsListener;
import response.settings.ChangePassResponse;
import ui.FXMLController;
import ui.mainView.MainPage;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsFXMLController extends FXMLController {

    private ComboBoxListener comboBoxListener;

    private SettingsListener settingsListener;

    private ChangePassListener changePassListener;

    private Settings component;

    @FXML
    private AnchorPane backButton;

    @FXML
    private Label settingsLabel;

    @FXML
    private Label authenticationLabel;

    @FXML
    private Label currentPassLabel;

    @FXML
    private Label newPassLabel;

    @FXML
    private Label privacyLabel;

    @FXML
    private Label accountTypeLabel;

    @FXML
    private Label lastSeenLabel;

    @FXML
    private Button changPassButton;

    @FXML
    private Button deactivateButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button saveAccountTypeButton;

    @FXML
    private Button saveLastSeenButton;

    @FXML
    private ComboBox<String> accountTypeBox;

    @FXML
    private ComboBox<String> lastSeenBox;

    @FXML
    private TextField currentPassBox;

    @FXML
    private TextField newPassBox;

    @FXML
    private Label passErrorLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Config config = Config.getConfig("settings");

        accountTypeBox.getItems().addAll(config.getProperty("public")
                ,config.getProperty("private"));
        lastSeenBox.getItems().addAll(config.getProperty("everyone"),
                config.getProperty("follow"),
                config.getProperty("no_one"));

        passErrorLabel.setVisible(false);
    }

    public Label getPassErrorLabel() {
        return passErrorLabel;
    }

    @FXML
    void changePassPressed(ActionEvent event) {
        changePassListener.eventOccurred(new ChangePassEvent(this,
                component.getLoggedInUser(),
                currentPassBox.getText(),
                newPassBox.getText()));
    }

    @FXML
    void saveAccountTypePressed(ActionEvent event) {
        String selectedOption = accountTypeBox.getValue();
        comboBoxListener.eventOccurred(new ComboBoxEvent(this,
                component.getLoggedInUser(),
                "changeAccountType",
                selectedOption));
    }

    @FXML
    void saveLastSeenPressed(ActionEvent event) {
        String selectedOption = lastSeenBox.getValue();
        comboBoxListener.eventOccurred(new ComboBoxEvent(this,
                component.getLoggedInUser(),
                "changeLastSeen",
                selectedOption));
    }

    @FXML
    void deactivatePressed(ActionEvent event) {
        settingsListener.eventOccurred(new SettingsStringEvent(this, component.getLoggedInUser(), "deactivate"));
    }

    @FXML
    void deletePressed(ActionEvent event) {
        settingsListener.eventOccurred(new SettingsStringEvent(this, component.getLoggedInUser(), "delete"));
    }

    public void setComponent(Settings component) {
        this.component = component;
    }

    public void setListeners(){
        comboBoxListener = new ComboBoxListener(component.getGraphicalAgent());
        settingsListener = new SettingsListener(component.getGraphicalAgent());
        changePassListener = new ChangePassListener(component.getGraphicalAgent());
    }

    public void exit(){
        ((MainPage)component.getParent()).exit();
    }

    @Override
    public void update() {
        component.updateApp();
    }

    public void showLabel(ChangePassResponse changePassResponse) {
        passErrorLabel.setVisible(!changePassResponse.isValid());
    }
}
