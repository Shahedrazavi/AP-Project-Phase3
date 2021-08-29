package event;

import model.User;
import response.EmptyResponse;
import response.Response;

public class AccountEvent extends StringEvent{
    private User targetUser;

    public AccountEvent(Object source, String command , User targetUser) {
        super(source, command);
        this.targetUser = targetUser;
    }

    public User getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(User targetUser) {
        this.targetUser = targetUser;
    }

    @Override
    public Response visit(EventVisitor eventVisitor) {
        if (getCommand().equals("block")) return eventVisitor.blockAcc();
        if (getCommand().equals("mute")) return eventVisitor.muteAcc();
        if (getCommand().equals("viewProfile")) return eventVisitor.viewProfile();
        return new EmptyResponse();
    }
}
