package BusinessLayer;
import DataLayer.Serialization;
import java.io.Serializable;
/**
 * This class will store data for each type of user
 */
public class Users implements Serializable {

    private final IdPassword passClient = new IdPassword();
    private final IdPassword passAdmin = new IdPassword();
    private final IdPassword passEmp = new IdPassword();
    private static Serialization serialization = new Serialization();

    /**
     * This method will set the Serialization type attribute that is used for serialization
     * @param serialization serialization
     */
    public void setSerialization(Serialization serialization){this.serialization = serialization;}

    /**
     * This method will call the method that serialize object of type Users
     */
    public void getSerialize(){serialization.Serialize(this);}

    /**
     * This method will return an object of type IdPassword for the Clients
     * @return
     */
    public IdPassword getClients(){
        return passClient;
    }

    /**
     *  This method will return an object of type IdPassword for the Administrator
     * @return
     */
    public IdPassword getAdmin(){
        return passAdmin;
    }

    /**
     *  This method will return an object of type IdPassword for the Employees
     * @return
     */
    public IdPassword getEmployee(){
        return passEmp;
    }

    /**
     *  This method add a new pair of userId and password in the login credentials hashmap for the Clients user
     * @param name
     * @param password
     */
    public  void addClient(String name, String password){
        passClient.addInfo(name, password);
        getSerialize();
    }

    /**
     * This method add  a new pair of userId and password in the login credentials hashmap for Administrator user
     * @param name
     * @param password
     */
    public  void addAdmin(String name, String password){
        passAdmin.addInfo(name, password);
        getSerialize();
    }

    /**
     * This method add  a new pair of userId and password in the login credentials hashmap for Employee user
     * @param name
     * @param password
     */
    public void addEmployee(String name, String password){
        passEmp.addInfo(name, password);
        getSerialize();
    }
}
