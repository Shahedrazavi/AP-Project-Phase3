package ui.component.tweetViewer;

//import controller.component.tweetViewer.TweetViewerLogic;
import event.component.tweetViewer.TweetViewerEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
//import listener.component.tweetViewer.TweetViewerListener;
import ui.FXMLController;
import ui.component.tweetComponent.TweetComponent;

import java.net.URL;
import java.util.ResourceBundle;

public class TweetViewerFXMLController extends FXMLController{

//    private TweetViewerLogic logic;

//    private TweetViewerListener listener;

    private TweetViewer component;

    @FXML
    private AnchorPane componentPane;

    @FXML
    private Label emptyLabel;

    @FXML
    private Button previousButton;

    @FXML
    private Button nextButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        emptyLabel.setVisible(false);
    }

    public void initializeLogic(TweetViewerLogic logic){
        this.logic = logic;
    }

    public void initializeListener(){
        listener = new TweetViewerListener(logic);
    }

    public void disableButtons(){
        disableNext();
        disablePrevious();
    }

    public void disablePrevious(){
        previousButton.setDisable(true);
    }

    public void disableNext(){
        nextButton.setDisable(true);
    }

    public void enablePrevious(){
        previousButton.setDisable(false);
    }

    public void enableNext(){
        nextButton.setDisable(false);
    }

    public void showEmptyLabel(){
        emptyLabel.setVisible(true);
    }

    public void hideEmptyLabel(){
        emptyLabel.setVisible(false);
    }

    @FXML
    void nextPressed(ActionEvent event) {
        listener.EventOccurred(new TweetViewerEvent(this,"nextPressed"));
    }

    @FXML
    void previousPressed(ActionEvent event) {
        listener.EventOccurred(new TweetViewerEvent(this,"previousPressed"));
    }

    public void setComponent(TweetViewer component) {
        this.component = component;
    }

    public TweetViewer getComponent() {
        return component;
    }

    public void setComponentPane(TweetComponent tweetComponent) {
        componentPane.getChildren().clear();
        componentPane.getChildren().add(tweetComponent.getRoot());
    }
}
