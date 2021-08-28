package ui.auth.registration;

import ui.Component;
import ui.GraphicalAgent;
import ui.auth.SignUpPage;

public class RegistrationPage2 extends Component {
    public RegistrationPage2(String fxmlName, GraphicalAgent graphicalAgent, SignUpPage parent) {
        super(fxmlName,graphicalAgent);
        setParent(parent);
        initialize();
    }

    @Override
    public void initialize() {
        ((RegistrationPage2FXMLController)fxmlController).setComponent(this);
        ((RegistrationPage2FXMLController)fxmlController).setListener();
    }
}
