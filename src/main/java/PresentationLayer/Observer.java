package PresentationLayer;

import java.io.Serializable;

/**
 * This interface is used for notify the employee when an order is placed
 */
public interface Observer {
        /**
         * This method will update the message with the data of the new order
         * @param message
         */
        public void update(String message);


}
