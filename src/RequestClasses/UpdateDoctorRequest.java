package RequestClasses;

import Models.Doctor;
import RequestClasses.RequestResponseClasses.BooleanResponse;

public class UpdateDoctorRequest extends Request {
    public UpdateDoctorRequest() {
        this.RequestAction = RequestAction.UPDATEDOCTOR;
    }

    public Doctor Doctor;
    public BooleanResponse Response = new BooleanResponse();
}
