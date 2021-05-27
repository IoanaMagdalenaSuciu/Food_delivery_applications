package BusinessLayer;

import java.io.Serializable;
import java.util.Date;

/**
 * In this class, the data corresponding to an order will be saved and the operations for orders will be implemented
 */
public class Order implements Serializable {
    /**
     * Order Number
     */
    private final int orderId;
    /**
     * Client Id
     */
    private final String clientId;
    /**
     * Date
     */
    private final Date data;
    /**
     * Price
     */
    float price;

    /**
     * This constructor will save the data for the new order
     * @param orderId
     * @param clientId
     * @param data
     */
    public Order(int orderId, String clientId, Date data){
        this.clientId = clientId;
        this.orderId = orderId;
        this.data = data;
    }

    /**
     * This method will return the ClientId
     * @return
     */
    public String getClientId(){return clientId;}

    /**
     * This method will return the order date
     * @return
     */
    public Date getData(){
        return data;
    }

    /**
     * This method will return the orderId
     * @return
     */
    public int getOrderId(){
        return orderId;
    }

    /**
     * This method will compute the price for the order
     * @param newPrice
     */
    public void computePrice(float newPrice){
        price += newPrice;
    }

    /**
     * This method will return the price of the order
     * @return
     */
    public float getPrice(){return price;}

    /**
     * This method will create a string that will contain the object data
     * @return
     */
    public String toString(){
        return "Order number: "+orderId+" for client with clientId: "+clientId+ " \n Date: "+data + "\n Price "+price+"\n";
    }


}
