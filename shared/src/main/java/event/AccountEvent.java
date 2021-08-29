package event;

import model.Tweet;
import model.User;
import response.EmptyResponse;
import response.Response;

public class AccountEvent extends StringEvent{
    private Tweet targetTweet;
    private User loggedInUser;

    public AccountEvent(Object source, String command ,User loggedInUser, Tweet tweet ) {
        super(source, command);
        this.targetTweet = tweet;
        this.loggedInUser = loggedInUser;
    }

    public Tweet getTargetTweet() {
        return targetTweet;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    @Override
    public Response visit(EventVisitor eventVisitor) {
        if (getCommand().equals("block")) return eventVisitor.blockAcc(this);
        if (getCommand().equals("mute")) return eventVisitor.muteAcc(this);
        if (getCommand().equals("viewProfile")) return eventVisitor.viewProfile(this);
        return new EmptyResponse();
    }
}
