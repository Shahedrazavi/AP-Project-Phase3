package response.settings;

import response.Response;
import response.ResponseVisitor;

public class ChangeActResponse extends Response {
    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.activation();
    }
}
