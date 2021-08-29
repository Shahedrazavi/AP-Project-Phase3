package response;

public class StartClientResponse extends Response{
    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.startClient();
    }
}
