package RequestClasses;

import Models.Doctor;
import RequestClasses.RequestResponseClasses.BooleanResponse;


public class AddDoctorRequest extends Request {
    public AddDoctorRequest() {
        this.RequestAction = RequestAction.ADDDOCTOR;
    }

    public Doctor Doctor;
    public BooleanResponse Response = new BooleanResponse();
}
