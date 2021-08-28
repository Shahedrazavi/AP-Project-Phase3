package ui.opening;

import ui.GraphicalAgent;
import ui.Page;

public class OpeningPage extends Page {
    public OpeningPage(String fxmlName , GraphicalAgent graphicalAgent) {
        super(fxmlName ,graphicalAgent);
        initialize();
    }

    @Override
    public void initialize() {
        OpeningPageFXMLController controller = (OpeningPageFXMLController)fxmlController;
        controller.setPage(this);
        controller.setListener();
    }
}
