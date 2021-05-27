package BusinessLayer;

import java.io.Serializable;
import java.util.HashMap;

/**
 * This class will save the userId and password pairs
 */
public class IdPassword implements Serializable {
    private final HashMap<String,String> logininfo = new HashMap<String,String>();

    /**
     * Ad a new pair to map
     * @param id userId
     * @param password password
     */
    public void addInfo(String id, String password){
       logininfo.put(id,password);
    }

    /**
     * Return the pairs
     * @return the pairs of userId and password
     */
    public HashMap getLoginInfo(){
        return logininfo;
    }
}
