package RequestClasses;


import Models.Patient;
import RequestClasses.RequestResponseClasses.BooleanResponse;

public class UpdatePatientRequest extends Request {
    public UpdatePatientRequest() {
        this.RequestAction = RequestAction.UPDATEPATIENT;
    }

    public Patient Patient = new Patient();
    public BooleanResponse Response = new BooleanResponse();
}
