package ui.settings;

import model.User;
import ui.Component;
import ui.GraphicalAgent;
import ui.mainView.MainPage;

public class Settings extends Component {

    public Settings(String fxmlName, GraphicalAgent graphicalAgent, MainPage parent , User user) {
        super(fxmlName,graphicalAgent);
        setParent(parent);
        setLoggedInUser(user);
        initialize();
    }

    @Override
    public void initialize() {
        SettingsFXMLController controller = (SettingsFXMLController)fxmlController;
        controller.setComponent(this);
        controller.setListeners();
        update();
    }
}
