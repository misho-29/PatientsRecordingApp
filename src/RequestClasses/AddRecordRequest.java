package RequestClasses;

import Models.Record;
import RequestClasses.RequestResponseClasses.BooleanResponse;

public class AddRecordRequest extends Request {
    public AddRecordRequest() {
        this.RequestAction = RequestAction.ADDRECORD;
    }

    public Record Record;
    public BooleanResponse Response = new BooleanResponse();
}
