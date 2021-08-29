package event.component.tweetComponent;

import event.EventVisitor;
import event.StringEvent;
import model.Tweet;
import model.User;
import response.Response;

public class TweetEvent extends StringEvent {
    private Tweet tweet;
    private User loggedInUser;

    public TweetEvent(Object source, String command , User loggedInUser , Tweet tweet) {
        super(source, command);
        this.loggedInUser = loggedInUser;
        this.tweet = tweet;
    }

    @Override
    public Response visit(EventVisitor eventVisitor) {
        if (getCommand().equals("likePressed")) return eventVisitor.likeTweet(this);
        if (getCommand().equals("reportPressed")) return eventVisitor.reportTweet(this);
        if (getCommand().equals("retweetPressed")) return eventVisitor.retweetTweet(this);
        if (getCommand().equals("savePressed")) return eventVisitor.savePressed(this);
        if (getCommand().equals("viewCommentsPressed")) return eventVisitor.showComments(this);
        return null;
    }

    public Tweet getTweet() {
        return tweet;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }
}
