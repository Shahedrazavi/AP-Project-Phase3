package event;

import response.Response;

import java.util.EventObject;

public abstract class Event extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public Event(Object source) {
        super(source);
    }

    public void setSource(Object source){
        this.source = source;
    }

    public abstract Response visit(EventVisitor eventVisitor);

}