import Models.Doctor;
import org.w3c.dom.ls.LSOutput;

public class DataAccess {
    public static void main(String[] args) {
        System.out.println("aa");
    }

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
