package response;

public class EmptyResponse extends Response{
    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.getEmptyResponse();
    }
}
