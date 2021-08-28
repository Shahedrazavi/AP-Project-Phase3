package ui.auth.signIn;

import ui.Component;
import ui.GraphicalAgent;
import ui.auth.SignInPage;
import ui.component.backButton.BackButton;

public class SignInCenter extends Component {
    private Component backButton;

    public SignInCenter(String fxmlName, GraphicalAgent graphicalAgent, SignInPage parent) {
        super(fxmlName,graphicalAgent);
        setParent(parent);
        initialize();
    }

    @Override
    public void initialize() {
        SignInCenterFXMLController controller = (SignInCenterFXMLController)fxmlController;
        backButton = new BackButton("backButton",graphicalAgent);
        controller.setComponent(this);
        controller.makeContents();
        controller.setListener();
    }

    public Component getBackButton() {
        return backButton;
    }
}
