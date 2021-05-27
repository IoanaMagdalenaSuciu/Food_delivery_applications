package DataLayer;

import BusinessLayer.*;



import java.io.*;

/**
 * This class will serialize and deserialize the objects
 */
public class Serialization {
    static FileOutputStream fileOut ;
    static ObjectOutputStream out;
    static FileInputStream fileIn;
    static ObjectInputStream in;
    static FileOutputStream fileOutUsers;
    static FileInputStream fileInUsers;

    /**
     * This method will Serialize the objects of type DeliveryService
     * @param service
     */
    public static void Serialize (DeliveryService service){
        try {
            fileOut = new FileOutputStream("file.txt");
            out = new ObjectOutputStream(fileOut);
            out.writeObject(service);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in file.txt");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * This method Deserialize the object from file.txt and returns a  DeliveryService object
     * @return
     */
    public static DeliveryService Deserialize(){
       DeliveryService service = null;
        try {
            fileIn = new FileInputStream("file.txt");
            in = new ObjectInputStream(fileIn);
             service =  (DeliveryService) in.readObject();
            in.close();
            fileIn.close();

        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
        System.out.println(service.toString());
        return service;
    }
    /**
     * This method will Serialize the objects of type Users
     * @param users
     */
    public static void Serialize (Users users){
        try {
            fileOutUsers = new FileOutputStream("fileUsers.txt");
            out = new ObjectOutputStream(fileOutUsers);
            out.writeObject(users);
            out.close();
            fileOutUsers.close();
            System.out.println("Serialized data is saved in fileUsers.txt");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    /**
     * This method Deserialize the object from fileUsers.txt and returns a  Users object
     * @return
     */
    public static Users DeserializeUsers(){

       Users users = null;
        try {
            fileInUsers = new FileInputStream("fileUsers.txt");
            in = new ObjectInputStream(fileInUsers);
            users =  (Users) in.readObject();
            in.close();
            fileInUsers.close();

        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
        return users;
    }
}
