package response.auth.registration;

import response.Response;
import response.ResponseVisitor;

import java.util.LinkedList;

public class RegPage1Response extends Response {
    private boolean isValid;
    private boolean isBlank;
    private LinkedList<Boolean> emptyErrorLabels;
    private LinkedList<Boolean> errorLabels;

    public RegPage1Response() {
        isValid = false;
        emptyErrorLabels = new LinkedList<>();
        errorLabels = new LinkedList<>();
    }

    public boolean isBlank() {
        return isBlank;
    }

    public void setBlank(boolean blank) {
        isBlank = blank;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public LinkedList<Boolean> getEmptyErrorLabels() {
        return emptyErrorLabels;
    }

    public LinkedList<Boolean> getErrorLabels() {
        return errorLabels;
    }

    @Override
    public void visit(ResponseVisitor responseVisitor) {
        responseVisitor.finalizeRegPage1(this);
    }
}
