package RequestClasses;

import Models.Doctor;
import RequestClasses.RequestResponseClasses.DoctorsResponse;

import java.util.ArrayList;

public class GetDoctorsRequest extends Request {
    public GetDoctorsRequest() {
        this.RequestAction = RequestAction.GETDOCTORS;
    }

    public DoctorsResponse RequestResponse;
}
