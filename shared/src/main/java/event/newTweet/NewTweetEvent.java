package event.newTweet;

import event.StringEvent;
import model.User;

import java.awt.image.BufferedImage;

public class NewTweetEvent extends StringEvent {
    private String text;
    private BufferedImage image;
    private User loggedInUser;

    public NewTweetEvent(Object source, String command , String text , BufferedImage image , User loggedInUser) {
        super(source, command);
        this.text = text;
        this.image = image;
        this.loggedInUser=loggedInUser;
    }

    public String getText() {
        return text;
    }

    public BufferedImage getImage() {
        return image;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }
}
