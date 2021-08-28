package listener;

import ui.GraphicalAgent;

public abstract class Listener {
    protected GraphicalAgent graphicalAgent;

    public Listener(GraphicalAgent graphicalAgent) {
        this.graphicalAgent = graphicalAgent;
    }
}
