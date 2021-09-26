package response;

public class StringResponse extends Response{
    private String command;

    public StringResponse(String command) {
        this.command = command;
    }

    @Override
    public void visit(ResponseVisitor responseVisitor) {
    }

    public String getCommand() {
        return command;
    }
}
