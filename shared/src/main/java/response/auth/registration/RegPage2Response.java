package response.auth.registration;

import response.Response;
import response.ResponseVisitor;

public class RegPage2Response extends Response {
    private boolean isValid;

    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.finalizeRegPage2(this);
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
