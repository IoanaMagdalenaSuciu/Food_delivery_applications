package BusinessLayer;
import PresentationLayer.Observer;

import java.io.Serializable;

/**
 * This abstract class defines the methods that will link employees to the status of orders
 */
public abstract class Observable implements Serializable {
    /**
     * This method will add a new Observer
     * @param observer Observer to be added
     */
    public abstract void registerObserver(Observer observer);

    /**
     * This method will notify all Observers when a order is placed
     * @param message the data of the new order
     */
    public abstract void notifyOrder(String message);

    /**
     * This method will delete the observer
     * @param observer Observer to be deleted
     */
    public abstract void deleteObserver(Observer observer);
}
