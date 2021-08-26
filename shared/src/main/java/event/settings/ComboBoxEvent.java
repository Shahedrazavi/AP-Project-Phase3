package event.settings;

import event.Event;
import model.User;

public class ComboBoxEvent extends Event {

    private User user;
    private String command;
    private String selectedOption;

    public ComboBoxEvent(Object source,User user, String command, String selectedOption) {
        super(source);
        this.user = user;
        this.command = command;
        this.selectedOption = selectedOption;
    }

    public User getUser() {
        return user;
    }

    public String getCommand() {
        return command;
    }

    public String getSelectedOption() {
        return selectedOption;
    }
}
