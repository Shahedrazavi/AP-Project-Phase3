package ui.component.backButton;

import ui.Component;
import ui.GraphicalAgent;

public class BackButton extends Component {



    public BackButton(String fxmlName , GraphicalAgent graphicalAgent) {
        super(fxmlName , graphicalAgent);
        initialize();
    }

    @Override
    public void initialize() {
        BackButtonFXMLController controller = (BackButtonFXMLController)fxmlController;
        controller.setComponent(this);
    }
}
