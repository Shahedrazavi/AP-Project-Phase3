package response;

public class ExitClientResponse extends Response{
    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.exitClient();
    }
}
