package event;

import response.Response;

public class StringEvent extends Event {
    private String command;

    public StringEvent(Object source, String command) {
        super(source);
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    @Override
    public Response visit(EventVisitor eventVisitor) {
        return null;
    }
}
