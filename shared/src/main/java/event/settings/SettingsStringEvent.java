package event.settings;

import event.EventVisitor;
import event.StringEvent;
import model.User;
import response.Response;

public class SettingsStringEvent extends StringEvent {

    User user;

    public SettingsStringEvent(Object source, User user, String command) {
        super(source, command);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public Response visit(EventVisitor eventVisitor) {
        if (getCommand().equals("delete")) return eventVisitor.deleteAcc(this);
        else return eventVisitor.deactivateAcc(this);
    }
}
