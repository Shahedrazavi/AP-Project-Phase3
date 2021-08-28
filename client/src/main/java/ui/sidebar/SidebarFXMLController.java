package ui.sidebar;

import event.StringEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import listener.sidebar.SidebarListener;
import ui.FXMLController;

import java.net.URL;
import java.util.ResourceBundle;

public class SidebarFXMLController extends FXMLController {

    private SidebarListener listener;

    private Sidebar component;

    @FXML
    private Button timelineButton;

    @FXML
    private Button exploreButton;

    @FXML
    private Button notifsButton;

    @FXML
    private Button searchButton;

    @FXML
    private Button messagesButton;

    @FXML
    private Button profileButton;

    @FXML
    private Button settingsButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Button tweetButton;

    @FXML
    private Button backButton;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void hideOrUnhideButtons(){
        if(!component.getLoggedInUser().isActive()){
            timelineButton.setDisable(true);
            tweetButton.setDisable(true);
        }
        else {
            timelineButton.setDisable(false);
            tweetButton.setDisable(false);
        }
    }

    @FXML
    void explorePressed(ActionEvent event) {
        listener.eventOccurred(new StringEvent(this, "explore"));
    }

    @FXML
    void homePressed(ActionEvent event) {
        listener.eventOccurred(new StringEvent(this, "home"));
    }

    @FXML
    void logoutPressed(ActionEvent event) {
        listener.eventOccurred(new StringEvent(this, "logout"));
    }

    @FXML
    void messagesPressed(ActionEvent event) {
        listener.eventOccurred(new StringEvent(this, "messages"));
    }

    @FXML
    void notifsPressed(ActionEvent event) {
        listener.eventOccurred(new StringEvent(this, "notifs"));
    }

    @FXML
    void profilePressed(ActionEvent event) {
        listener.eventOccurred(new StringEvent(this, "profile"));
    }

    @FXML
    void searchPressed(ActionEvent event) {
        listener.eventOccurred(new StringEvent(this, "search"));
    }

    @FXML
    void settingsPressed(ActionEvent event) {
        listener.eventOccurred(new StringEvent(this, "settings"));
    }

    @FXML
    void tweetPressed(ActionEvent event) {
        listener.eventOccurred(new StringEvent(this, "tweet"));
    }

    @FXML
    void backPressed(ActionEvent event) {
        listener.eventOccurred(new StringEvent(this, "back"));
    }

    public void setComponent(Sidebar component) {
        this.component = component;
    }

    public void setListener(){
        listener = new SidebarListener();
    }

    public Sidebar getComponent() {
        return component;
    }
}
