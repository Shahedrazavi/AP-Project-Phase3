package event.settings;

import event.Event;
import model.User;

public class ChangePassEvent extends Event {

    private User user;
    private String currentPass;
    private String newPass;

    public ChangePassEvent(Object source ,User user, String currentPass , String newPass) {
        super(source);
        this.user = user;
        this.currentPass = currentPass;
        this.newPass = newPass;
    }

    public User getUser() {
        return user;
    }

    public String getCurrentPass() {
        return currentPass;
    }

    public String getNewPass() {
        return newPass;
    }
}
