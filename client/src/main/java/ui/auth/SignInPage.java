package ui.auth;

import javafx.fxml.FXML;
import ui.Component;
import ui.GraphicalAgent;
import ui.Page;
import ui.auth.signIn.SignInCenter;

public class SignInPage extends Page {

    @FXML
    private Component signInCenter;

    public SignInPage(String fxmlName, GraphicalAgent graphicalAgent) {
        super(fxmlName , graphicalAgent);
        initialize();
    }

    @Override
    public void initialize() {
        SignInPageFXMLController controller = (SignInPageFXMLController)fxmlController;
        signInCenter = new SignInCenter("signInCenter",graphicalAgent, this);
        controller.setPage(this);
        controller.makeContents();
    }

    public Component getSignInCenter() {
        return signInCenter;
    }
}
