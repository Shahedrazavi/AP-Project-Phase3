package event.settings;

import event.StringEvent;
import model.User;

public class SettingsStringEvent extends StringEvent {

    User user;

    public SettingsStringEvent(Object source, User user, String command) {
        super(source, command);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
