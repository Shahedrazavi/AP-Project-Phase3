package response.settings;

import response.Response;
import response.ResponseVisitor;

public class ChangePassResponse extends Response {
    private boolean isValid;

    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.changePass(this);
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
