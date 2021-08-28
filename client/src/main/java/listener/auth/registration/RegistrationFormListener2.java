package listener.auth.registration;

import event.auth.registration.RegistrationFormEvent;
import listener.Listener;
import ui.GraphicalAgent;

public class RegistrationFormListener2 extends Listener {

    public RegistrationFormListener2(GraphicalAgent graphicalAgent) {
        super(graphicalAgent);
    }

    public void eventOccurred(RegistrationFormEvent formEvent){
        graphicalAgent.getListener().listen(formEvent);
    }
}
