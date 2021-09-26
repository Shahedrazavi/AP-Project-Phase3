package event;

import event.Event;
import event.EventVisitor;
import model.Tweet;
import model.User;
import response.Response;

public class GetTweetsEvent extends StringEvent {
    private User targetUser;
    private User loggedInUser;
    private Tweet targetTweet;

    public GetTweetsEvent(Object source, String command) {
        super(source, command);
        this.targetUser = null;
        this.loggedInUser = null;
        this.targetTweet = null;
    }

    public GetTweetsEvent(Object source, String command, User loggedInUser) {
        super(source, command);
        this.loggedInUser = loggedInUser;
        this.targetUser = null;
        this.targetTweet = null;
    }

    public GetTweetsEvent(Object source, String command , User loggedInUser, User targetUser) {
        super(source, command);
        this.targetUser = targetUser;
        this.loggedInUser = loggedInUser;
        this.targetTweet = null;
    }

    public GetTweetsEvent(Object source, String command, User loggedInUser, Tweet targetTweet) {
        super(source, command);
        this.loggedInUser = loggedInUser;
        this.targetUser = null;
        this.targetTweet = targetTweet;
    }

    public User getTargetUser() {
        return targetUser;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public Tweet getTargetTweet() {
        return targetTweet;
    }

    @Override
    public Response visit(EventVisitor eventVisitor) {
        return eventVisitor.getTweetsList(this);
    }
}
