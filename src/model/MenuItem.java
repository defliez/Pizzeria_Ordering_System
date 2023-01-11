package model;

/**
 * A class representing a menu item.
 * This class represents a menu item with a name and price.
 * @author Valentino Glave
 */
public abstract class MenuItem {
    private String name;
    private double price;

    /**
     * Constructs a menu item with the given name and price.
     * @param name the name of the menu item
     * @param price the price of the menu item
     */
    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Returns the name of the menu item.
     * @return the name of the menu item
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the a String representation of the menu item, including the name and price.
     * @return the name and price of the menu item.
     */
    @Override
    public String toString() {
        return name + " - $" + price;
    }
}