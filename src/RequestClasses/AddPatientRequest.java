package RequestClasses;

import Models.Patient;
import RequestClasses.RequestResponseClasses.BooleanResponse;

public class AddPatientRequest extends Request {
    public AddPatientRequest() {
        this.RequestAction = RequestAction.ADDPATIENT;
    }

    public Patient Patient;
    public BooleanResponse Response;
}
