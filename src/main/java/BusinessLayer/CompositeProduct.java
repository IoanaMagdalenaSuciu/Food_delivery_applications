package BusinessLayer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements operations performed on a composite product
 */
public class CompositeProduct extends MenuItem implements Serializable {
    /**
     * The list of products that compose the composite product
     */
    private List<MenuItem>productItems = new ArrayList<MenuItem>();

    /**
     * Call the super constructor to add data for the new product
     * @param rating rating
     * @param price price
     * @param name name
     * @param calories calories
     * @param protein protein
     * @param fat fat
     * @param sodium soium
     */
    public CompositeProduct(float rating, float price, String name, int calories, int protein, int fat, int sodium) {
        super(rating,price,name, calories,protein,fat,sodium);
    }

    /**
     * Will add a new base product to  list
     * @param item new base product
     */
    public void addItem(MenuItem item){
        productItems.add(item);
    }

    /**
     * Will compute the data for the product
     */
    public void compute(){
        float price = 0;
        int calories = 0;
        int protein = 0;
        int fat = 0;
        int sodium = 0;
        for(MenuItem item : productItems){
           price += item.getPrice();
           calories += item.getCalories();
           protein += item.getProtein();
           fat += item.getFat();
           sodium += item.getSodium();

        }
        super.setPrice(price);
        super.setCalories(calories);
        super.setFat(fat);
        super.setProtein(protein);
        super.setSodium(sodium);

    }

    /**
     *This method will create a string that will contain the product data
     * @return the product in a form of a String
     */
    public String toString(){

        String result = " ";
        result += super.toString();
        for(MenuItem item: productItems){
            result += item.toString();
        }
        return result;
    }
}
