package event.opening;

import event.EventVisitor;
import event.StringEvent;
import response.Response;

public class OpeningEvent extends StringEvent {
    public OpeningEvent(Object source, String command) {
        super(source, command);
    }

    @Override
    public Response visit(EventVisitor eventVisitor) {
        return null;
    }
}
