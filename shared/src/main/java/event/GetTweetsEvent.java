package event;

import event.Event;
import event.EventVisitor;
import model.User;
import response.Response;

public class GetTweetsEvent extends StringEvent {
    private User targetUser;
    private User loggedInUser;

    public GetTweetsEvent(Object source, String command ,User loggedInUser, User targetUser) {
        super(source, command);
        this.targetUser = targetUser;
        this.loggedInUser = loggedInUser;
    }

    public User getTargetUser() {
        return targetUser;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    @Override
    public Response visit(EventVisitor eventVisitor) {
        return eventVisitor.getTweetsList(this);
    }
}
