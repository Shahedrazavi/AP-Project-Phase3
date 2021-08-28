package response.auth.sidebar;

import response.Response;
import response.ResponseVisitor;

public class LogOutResponse extends Response {

    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.logOut();
    }
}
