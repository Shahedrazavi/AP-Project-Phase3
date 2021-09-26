package ui.component.tweetComponent;


import event.AccountEvent;
import event.component.tweetComponent.TweetEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import listener.component.tweetComponent.TweetComponentListener;
import model.Tweet;
import ui.FXMLController;

import java.net.URL;
import java.util.ResourceBundle;

public class TweetComponentFXMLController extends FXMLController{

    private TweetComponentListener listener;

//    private TweetComponentLogic logic;

    private TweetComponent component;

    @FXML
    private ImageView profilePhoto;

    @FXML
    private ImageView tweetPhoto;


    @FXML
    private Label ProfileNameLabel;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label tweetTextLabel;

    @FXML
    private Label replyingToLabel;

    @FXML
    private Label retweetedLabel;

    @FXML
    private Button muteButton;

    @FXML
    private Button blockButton;

    @FXML
    private Button viewProfileButton;

    @FXML
    private Button likeButton;

    @FXML
    private Button commentButton;

    @FXML
    private Button retweetButton;

    @FXML
    private Button viewCommentsButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button forwardButton;

    @FXML
    private Button reportButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        profilePhoto.setPickOnBounds(true); // allows click on transparent areas
//        profilePhoto.setOnMouseClicked((MouseEvent e) -> {
//            System.out.println("Clicked!"); // change functionality
//            viewTweetPhotoPressed();
//        });
    }
    public void setTweetInfo(String retweeter, String profileName, String username, String replyingTo){

        Tweet tweet = component.getTweet();
//        usernameLabel.setText(logic.getUsername(tweet.getWriterID()));
        tweetTextLabel.setText(tweet.getText());
        usernameLabel.setText(username);
        ProfileNameLabel.setText(profileName);
        if(retweeter.equals("")){
            retweetedLabel.setVisible(false);
        }
        else {
            retweetedLabel.setVisible(true);
            retweetedLabel.setText(retweeter);
        }

        if(replyingTo.equals("")){
            replyingToLabel.setVisible(false);
        }
        else {
            replyingToLabel.setVisible(false);
            replyingToLabel.setText(replyingTo);
        }

    }

    public void configButtons(){
//        if (logic.isMuted()){
//            muteButton.setDisable(true);
//        }
//        if (logic.isBlocked()){
//            blockButton.setDisable(true);
//        }
//        if (logic.isReported()){
//            reportButton.setDisable(true);
//        }
//        if (logic.isRetweeted()){
//            retweetButton.setDisable(true);
//        }
    }

//    public void initializeLogic(TweetComponentLogic logic){
//        this.logic = logic;
//    }

    public void setListener(){
        listener = new TweetComponentListener(component.getGraphicalAgent());
    }

    @FXML
    void blockPressed(ActionEvent event) {
        listener.eventOccurred(new AccountEvent(this,"block",component.getLoggedInUser(), component.getTweet()));
    }

    @FXML
    void commentPressed(ActionEvent event) {
        listener.eventOccurred(new TweetEvent(this,"commentPressed", component.getLoggedInUser(), component.getTweet()));
    }

    @FXML
    void forwardPressed(ActionEvent event) {
        listener.eventOccurred(new TweetEvent(this,"forwardPressed", component.getLoggedInUser(), component.getTweet()));
    }

    @FXML
    void likePressed(ActionEvent event) {
        listener.eventOccurred(new TweetEvent(this,"likePressed", component.getLoggedInUser(), component.getTweet()));
    }

    @FXML
    void mutePressed(ActionEvent event) {
        listener.eventOccurred(new AccountEvent(this,"mute",component.getLoggedInUser(), component.getTweet()));
    }

    @FXML
    void reportPressed(ActionEvent event) {
        listener.eventOccurred(new TweetEvent(this,"reportPressed", component.getLoggedInUser(), component.getTweet()));
    }

    @FXML
    void retweetPressed(ActionEvent event) {
        listener.eventOccurred(new TweetEvent(this,"retweetPressed", component.getLoggedInUser(), component.getTweet()));
    }

    @FXML
    void savePressed(ActionEvent event) {
        listener.eventOccurred(new TweetEvent(this,"savePressed", component.getLoggedInUser(), component.getTweet()));
    }

    @FXML
    void viewCommentsPressed(ActionEvent event) {
        listener.eventOccurred(new TweetEvent(this,"viewCommentsPressed", component.getLoggedInUser(), component.getTweet()));
    }

    @FXML
    void viewProfilePressed(ActionEvent event) {
        listener.eventOccurred(new AccountEvent(this,"viewProfile",component.getLoggedInUser(), component.getTweet()));
    }



    public void setComponent(TweetComponent component) {
        this.component = component;
    }

    //    void viewTweetPhotoPressed(){
//        listener.eventOccurred(new TweetEvent(this,"viewTweetPhotoPressed"));
//    }
}
