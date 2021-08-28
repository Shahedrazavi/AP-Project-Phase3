package event.sidebar;

import event.EventVisitor;
import event.StringEvent;
import event.auth.registration.RegistrationFormEvent;
import model.User;
import response.Response;

public class SidebarEvent extends StringEvent {
    private User loggedInUser;

    public SidebarEvent(Object source, String command , User loggedInUser) {
        super(source, command);
        this.loggedInUser = loggedInUser;
    }

    @Override
    public Response visit(EventVisitor eventVisitor) {
        if (this.getCommand().equals("logout")){
            return eventVisitor.logOut(loggedInUser);
        }
        return null;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
}
