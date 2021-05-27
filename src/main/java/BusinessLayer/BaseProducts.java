package BusinessLayer;

import java.io.Serializable;

/**
 * This class implements operations performed on a composite product
 */
public class BaseProducts extends MenuItem implements Serializable {
    /**
     * Creates a new base product by calling the super constructor
     * @param rating rating
     * @param price price
     * @param name name
     * @param calories calories
     * @param protein protein
     * @param fat fat
     * @param sodium sodium
     */
    public BaseProducts(float rating, float price, String name, int calories, int protein, int fat, int sodium) {
        super(rating,price,name, calories,protein,fat,sodium);
    }
    /**
     *This method will create a string that will contain the product data
     * @return the product in a form of a String
     */
    public String toString(){
        return super.toString();
    }
}
