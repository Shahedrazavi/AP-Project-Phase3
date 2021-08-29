package ui.profile;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import ui.FXMLController;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfileFXMLController extends FXMLController {

    private Profile component;

    @FXML
    private Label privateAccountLabel;

    @FXML
    private AnchorPane profileSection;

    @FXML
    private AnchorPane tweetSection;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setComponent(Profile component) {
        this.component = component;
    }

    @Override
    public void makeContents() {
        super.makeContents();
    }

    public void setProfileSection() {
        profileSection.getChildren().clear();
        profileSection.getChildren().add(component.getProfileHeader().getRoot());
    }

    public void setTweetSection() {
        tweetSection.getChildren().clear();
        tweetSection.getChildren().add(component.getTweetSection().getRoot());
    }

    public void hidePrivateLabel(){
        privateAccountLabel.setVisible(false);
    }

    @Override
    public void update() {
    }
}
