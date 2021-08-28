package response.settings;

import response.Response;
import response.ResponseVisitor;

public class DeleteAccResponse extends Response {
    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.deleteAcc();
    }
}
