package RequestClasses;


import Models.Record;
import RequestClasses.RequestResponseClasses.RecordsResponse;

import java.util.ArrayList;

public class GetRecordsRequest extends Request {
     public GetRecordsRequest() {
          this.RequestAction = RequestAction.GETRECORDS;
     }

     public RecordsResponse RequestResponse;
}
