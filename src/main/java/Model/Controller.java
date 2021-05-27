package Model;

import BusinessLayer.DeliveryService;
import BusinessLayer.Users;
import DataLayer.Serialization;
import PresentationLayer.LogIn;

import java.io.*;

public class Controller implements Serializable {

    public static void main (String[] args ) throws IOException {
        Serialization serialization = new Serialization();
        Controller controller = new Controller();
        Users users = serialization.DeserializeUsers();
       DeliveryService service = serialization.Deserialize();

     /*  Users users = new Users();
        users.setSerialization(serialization);
        DeliveryService service  = new DeliveryService();

        users.addClient("client", "123");
        users.addAdmin("admin","123");
        users.addEmployee("emp", "123");*/

      System.out.println(service.toString());
      LogIn logIn = new LogIn(users, service);
       service.setSerialization(serialization);





    }


}
