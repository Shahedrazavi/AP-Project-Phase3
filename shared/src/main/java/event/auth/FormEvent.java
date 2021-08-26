package event.auth;

import event.Event;

public class FormEvent extends Event {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */

    private String name;
    private String email;



    public FormEvent(Object source) {
        super(source);
    }
}
