package RequestClasses;

import Models.Record;
import RequestClasses.RequestResponseClasses.BooleanResponse;

public class DeleteRecordRequest extends Request {
    public DeleteRecordRequest() {
        this.RequestAction = RequestAction.DELETERECORD;
    }

    public Record Record = new Record();
    public BooleanResponse Response = new BooleanResponse();
}
