package ui.newTweet;

import model.User;
import ui.Component;
import ui.GraphicalAgent;
import ui.mainView.MainPage;

public class NewTweet extends Component {
    public NewTweet(String fxmlName, GraphicalAgent graphicalAgent, MainPage parent , User loggedInUser) {
        super(fxmlName , graphicalAgent);
        setParent(parent);
        setLoggedInUser(loggedInUser);
        initialize();
    }

    @Override
    public void initialize() {
        NewTweetFXMLController controller = (NewTweetFXMLController) fxmlController;
        controller.setComponent(this);
        controller.setListener();
    }
}
