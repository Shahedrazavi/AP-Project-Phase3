package event.update;

import event.Event;
import event.EventVisitor;
import response.Response;

public class UpdateProfileEvent extends Event {

    public UpdateProfileEvent(Object source) {
        super(source);
    }

    @Override
    public Response visit(EventVisitor eventVisitor) {
        return null;
    }
}
