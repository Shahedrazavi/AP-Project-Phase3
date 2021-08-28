package ui.auth.registration;

import ui.Component;
import ui.GraphicalAgent;
import ui.auth.SignUpPage;

public class RegistrationPage1 extends Component {
    public RegistrationPage1(String fxmlName, GraphicalAgent graphicalAgent, SignUpPage parent) {
        super(fxmlName,graphicalAgent);
        setParent(parent);
        initialize();
    }

    @Override
    public void initialize() {
        ((RegistrationPage1FXMLController)fxmlController).setComponent(this);
        ((RegistrationPage1FXMLController)fxmlController).setListener();
    }
}
