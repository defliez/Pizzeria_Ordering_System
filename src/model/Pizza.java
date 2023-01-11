package model;

/**
 * A class representing a pizza menu item.
 * This class extends the base model.MenuItem class and includes a list of toppings.
 *
 * @author Valentino Glave
 */
public class Pizza extends MenuItem {
    private String toppings;

    /**
     * Constructs a pizza menu item with the given name, price, and toppings.
     *
     * @param name     the name of the pizza
     * @param price    the price of the pizza
     * @param toppings the toppings of the pizza
     */
    public Pizza(String name, double price, String toppings) {
        super(name, price);
        this.toppings = toppings;
    }
}