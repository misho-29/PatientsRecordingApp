package RequestClasses;

import RequestClasses.RequestResponseClasses.BooleanResponse;

public class DeleteRecordRequest extends Request {
    public DeleteRecordRequest() {
        this.RequestAction = RequestAction.DELETERECORD;
    }

    public int RecordId;
    public BooleanResponse Response;
}
