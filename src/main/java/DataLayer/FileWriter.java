package DataLayer;


import BusinessLayer.Order;
import BusinessLayer.MenuItem;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class FileWriter implements Serializable {

    File myFile;
    java.io.FileWriter writer;

    /**
     * This method write the statistic data for Statistic 2 in Statistic2.txt
     * @param frequencyMap
     */
    public void writeStatistic2( Map<MenuItem, Long> frequencyMap){
         myFile = new File("Statistic2.txt");
        try {
            myFile.createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }
        try { writer = new java.io.FileWriter(myFile.getName()); } catch (IOException e) { e.printStackTrace(); }
        try { if (writer != null) {
            writer.write(frequencyMap.toString());
            writer.close();}
        } catch (IOException e) { e.printStackTrace(); }
    }
    /**
     * This method write the statistic data for Statistic 1 in Statistic1.txt
     * @param result
     */
    public void writeStatistic1(List<Order> result){
        myFile = new File("Statistic1.txt");
        try {
            myFile.createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }

        try { writer = new java.io.FileWriter(myFile.getName()); } catch (IOException e) { e.printStackTrace(); }
        try { if (writer != null) {
            writer.write(result.toString());
            writer.close();}
        } catch (IOException e) { e.printStackTrace(); }
    }

    /**
     * This method write the statistic data for Statistic 3 in Statistic3.txt
     * @param clients
     */

    public void writeStatistic3(List<String> clients){
        myFile = new File("Statistic3.txt");
        try {
            myFile.createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }

        try { writer = new java.io.FileWriter(myFile.getName()); } catch (IOException e) { e.printStackTrace(); }
        try { if (writer != null) {
            writer.write(clients.toString());
            writer.close();}
        } catch (IOException e) { e.printStackTrace(); }
    }

    /**
     * This method write the statistic data for Statistic 4 in Statistic4.txt
     * @param items
     */
    public void writeStatistic4( Map<MenuItem, Long>items){
        myFile = new File("Statistic4.txt");
        try {
            myFile.createNewFile();
        }catch (IOException e){
            e.printStackTrace(); }
        try { writer = new java.io.FileWriter(myFile.getName()); } catch (IOException e) { e.printStackTrace(); }
        try { if (writer != null) {
            writer.write(items.toString());
            writer.close();}
        } catch (IOException e) { e.printStackTrace(); }
    }

    /**
     * This method will generate the bill order
     * @param message
     */
    public void writeBill(String message){
        myFile = new File("Bill.txt");
        try {
            myFile.createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }
        try { writer = new java.io.FileWriter(myFile.getName()); } catch (IOException e) { e.printStackTrace(); }
        try { if (writer != null) {
            writer.write(message);
            writer.close();}
        } catch (IOException e) { e.printStackTrace(); }
    }

}
