package ui.component.profileHeader;

import model.User;
import ui.Component;
import ui.GraphicalAgent;
import ui.profile.Profile;

public class ProfileHeader extends Component {

    public ProfileHeader(String fxmlName , GraphicalAgent graphicalAgent, Profile parent , User loggedInUser) {
        super(fxmlName,graphicalAgent);
        setParent(parent);
        setLoggedInUser(loggedInUser);
    }
}
