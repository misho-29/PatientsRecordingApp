package RequestClasses;

import Models.Patient;
import RequestClasses.RequestResponseClasses.PatientsResponse;

import java.util.ArrayList;

public class GetPatientsRequest extends Request {
    public GetPatientsRequest() {
        this.RequestAction = RequestAction.GETPATIENTS;
    }

    public PatientsResponse Response = new PatientsResponse();
}
