package ui.tweetsPage;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import ui.Component;
import ui.FXMLController;
import ui.profile.Profile;

import java.net.URL;
import java.util.ResourceBundle;

public class TweetsPageFXMLController extends FXMLController {
    private TweetsPage component;

    @FXML
    private AnchorPane tweetSection;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setComponent(TweetsPage component) {
        this.component = component;
    }

    @Override
    public void makeContents() {
        super.makeContents();
    }

    public void setTweetSection() {
        tweetSection.getChildren().clear();
        tweetSection.getChildren().add(component.getTweetSection().getRoot());
    }
}
