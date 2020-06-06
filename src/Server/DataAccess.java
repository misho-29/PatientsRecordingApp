package Server;

import Models.Doctor;

public class DataAccess {
    private static final DataAccess instance = new DataAccess();

    //private constructor to avoid client applications to use constructor
    private DataAccess(){}

    public static DataAccess getInstance(){
        return instance;
    }

    public boolean AddDoctor (Doctor doctor){
        // TODO - adding operations

        // if operations completed successfully return true
        return true;
    }
}
