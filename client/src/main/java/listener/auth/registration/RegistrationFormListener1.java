package listener.auth.registration;


import event.auth.registration.RegistrationFormEvent;
import listener.Listener;
import ui.GraphicalAgent;

public class RegistrationFormListener1 extends Listener {
    public RegistrationFormListener1(GraphicalAgent graphicalAgent) {
        super(graphicalAgent);
    }

    public void eventOccurred(RegistrationFormEvent event){
        graphicalAgent.getListener().listen(event);
    }
}
