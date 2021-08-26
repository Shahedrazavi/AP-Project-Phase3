package event;

public class StringEvent extends Event {
    private String command;

    public StringEvent(Object source, String command) {
        super(source);
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
