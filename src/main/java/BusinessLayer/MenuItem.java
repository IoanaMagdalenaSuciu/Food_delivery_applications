package BusinessLayer;

import java.io.Serializable;

/**
 * In this class, the data corresponding the products will be saved and the operations for products will be implemented
 */
public abstract class MenuItem implements Serializable {
    /**
     * Name
     */
    String name;
    /**
     * Price
     */
    private float price;
    /**
     * Calories
     */
    int calories;
    /**
     * Protein
     */
    int protein;
    /**
     * Fat
     */
    int fat;
    /**
     * Sodium
     */
    int sodium;
    /**
     * Rating
     */
    float rating;

    /**
     * Set the data for the new product
     * @param rating
     * @param price
     * @param name
     * @param calories
     * @param protein
     * @param fat
     * @param sodium
     */
    public MenuItem(float rating, float price, String name, int calories, int protein, int fat, int sodium)
    {
        this.name = name;
        this.price = price;
        this.calories= calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.rating = rating;
    }

    /**
     * Return the name of the product
     * @return product name
     */
    public String getName(){
        return name;
    }

    /**
     * Return the price of the product
     * @return price product
     */
    public float getPrice(){
        return price;
    }

    /**
     * Set a new price for the product
     * @param newPrice the new price
     */
    public void setPrice(float newPrice){
        price = newPrice;
    }

    /**
     *This method will create a string that will contain the product data
     * @return the product in a form of a String
     */
    public String toString(){
        return name + ' ' + price + ' '+ rating +' '+calories+' '+protein+' '+fat +' ' + sodium +' ' +'\n';
    }

    /**
     * Returns the amount of calories of the product
     * @return amount of calories
     */
    public int getCalories() {
        return calories;
    }

    /**
     * Returns the amount of protein of the product
     * @return amount of calories
     */
    public int getProtein() {
        return protein;
    }

    /**
     * Returns the amount of fat of the product
     * @return amount of fat
     */
    public int getFat() {
        return fat;
    }
    /**
     * Returns the rating of the product
     * @return product rating
     */
    public float getRating() {
        return rating;
    }
    /**
     * Returns the amount of sodium of the product
     * @return amount of sodium
     */
    public int getSodium() {
        return sodium;
    }

    /**
     * Set a new amount of calories for the product
     * @param calories new amount of calories
     */
    public void setCalories(int calories){this.calories = calories;}

    /**
     * Set a new amount of sodium for the product
     * @param sodium new amount of sodium
     */
    public void setSodium(int sodium){this.sodium = sodium;}

    /**
     * Set a new amount of protein for the product
     * @param protein new amount of protein
     */
    public void setProtein(int protein){this.protein = protein;}

    /**
     * Set a new amount of fat for the product
     * @param fat new amount of fat
     */
    public void setFat(int fat){this.fat = fat;}
}
