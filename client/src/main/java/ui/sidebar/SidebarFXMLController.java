package ui.sidebar;

import event.StringEvent;
import event.sidebar.SidebarEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import listener.sidebar.SidebarListener;
import ui.FXMLController;
import ui.GraphicalAgent;

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
        listener.eventOccurred(new SidebarEvent(this, "explore", component.getLoggedInUser()));
    }

    @FXML
    void homePressed(ActionEvent event) {
        listener.eventOccurred(new SidebarEvent(this, "timeline", component.getLoggedInUser()));
    }

    @FXML
    void logoutPressed(ActionEvent event) {
        listener.eventOccurred(new SidebarEvent(this, "logout", component.getLoggedInUser()));
    }

    @FXML
    void messagesPressed(ActionEvent event) {
        listener.eventOccurred(new SidebarEvent(this, "messages", component.getLoggedInUser()));
    }

    @FXML
    void notifsPressed(ActionEvent event) {
        listener.eventOccurred(new SidebarEvent(this, "notifs", component.getLoggedInUser()));
    }

    @FXML
    void profilePressed(ActionEvent event) {
        listener.eventOccurred(new SidebarEvent(this, "profile", component.getLoggedInUser()));
    }

    @FXML
    void searchPressed(ActionEvent event) {
        listener.eventOccurred(new SidebarEvent(this, "search", component.getLoggedInUser()));
    }

    @FXML
    void settingsPressed(ActionEvent event) {
        listener.eventOccurred(new SidebarEvent(this, "settings", component.getLoggedInUser()));
    }

    @FXML
    void tweetPressed(ActionEvent event) {
        listener.eventOccurred(new SidebarEvent(this, "tweet", component.getLoggedInUser()));
    }

    @FXML
    void backPressed(ActionEvent event) {
        listener.eventOccurred(new SidebarEvent(this, "back", component.getLoggedInUser()));
    }

    public void setComponent(Sidebar component) {
        this.component = component;
    }

    public void setListener(){
        listener = new SidebarListener(component.getGraphicalAgent());
    }

    public Sidebar getComponent() {
        return component;
    }
}
