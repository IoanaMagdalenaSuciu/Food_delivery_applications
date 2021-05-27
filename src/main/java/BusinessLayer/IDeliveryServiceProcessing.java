package BusinessLayer;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * This interface defines the operations that can be performed by the administrator and the client
 */
public interface IDeliveryServiceProcessing {
    /**
     * Delete a product from menu
     * @param name the name of the product
     */
    void deleteFromMenu(String name);

    /**
     * Update a product in menu
     * @param price the new price
     * @param name the name of the product
     */
    void updateInMenu(float price, String name);

    /**
     * Add a product to menu
     * @param item the new item to be added
     */
    void addInMenu(MenuItem item);

    /**
     * Import the menu
     * @throws IOException
     */
    void importProducts() throws IOException;

    /**
     * Generate Statistic 1
     * @param start start hour
     * @param end end hour
     */
    void getStatistic1(Long start, Long end);

    /**
     * Generate Statistic 2
     * @param times times
     */
    void getStatistic2 (Long times);

    /**
     * Generate Statistic 3
     * @param times times
     * @param value  value
     */
    void getStatistic3(int times, float value);

    /**
     * Generate Statistic 4
     * @param date date
     */
    void getStatistic4(Date date);

    /**
     * Add a base product to a composite product
     * @param compose the composite product
     * @param base the base product
     */
    void addToComposite(CompositeProduct compose, MenuItem base);

    /**
     * Create a new order
     * @param client name of client who ordered
     * @param date date order
     * @return order number
     */
    int createOrder(String client, Date date);

    /**
     * Add a product to an order
     * @param name name of the product
     * @param orderId number of the order
     */
    void addItemsToOrder(String name, int orderId);

    /**
     * Filter menu by type
     * @param name type
     * @return new menu
     */
    List<MenuItem> filterByType(String name);

    /**
     *  Filter menu by price
     * @param price price
     * @return new menu
     */
    List<MenuItem> filterByPrice(Float price);

    /**
     *  Filter menu by rating
     * @param rating rating
     * @return new menu
     */
    List<MenuItem> filterByRating(Float rating);

    /**
     *  Filter menu by amount of fat
     * @param fat amount of fat
     * @return new menu
     */
    List<MenuItem> filterByFat(int fat);

    /**
     * Filter menu by amount of calories
     * @param calories amount of fat
     * @return new menu
     */
    List<MenuItem> filterByCalories(int calories);

    /**
     *  Filter menu by amount of sodium
     * @param sodium sodium
     * @return new menu
     */
    List<MenuItem>  filterBySodium(int sodium);

    /**
     * Filter menu by amount of protein
     * @param protein protein
     * @return new menu
     */
    List<MenuItem>  filterByProtein(int protein);
}
