package model;

/**
 * A class representing a non-alcohol menu item.
 * This class extends the base model.MenuItem class.
 *
 * @author Valentino Glave
 */
public class NonAlcohol extends MenuItem {

    /**
     * Constructs a non-alcoholic menu item with the given name and price.
     *
     * @param name  the name of the menu item
     * @param price the price of the menu item
     */
    public NonAlcohol(String name, double price) {
        super(name, price);
    }
}