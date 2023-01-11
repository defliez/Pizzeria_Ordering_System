package model;

/**
 * A class representing an alcohol menu item.
 * This class extends the base model.MenuItem class and includes an alcohol content.
 * @author Valentino Glave
 */
public class Alcohol extends MenuItem {
    private double alcoholContent;

    /**
     * Constructs an alcohol menu item with the given name, price, and alcohol content.
     * @param name the name of the drink
     * @param price the price of the drink
     * @param alcoholContent the alcohol content of the drink
     */
    public Alcohol(String name, double price, double alcoholContent) {
        super(name, price);
        this.alcoholContent = alcoholContent;
    }

    /**
     * Returns the toString of the parent class, MenuItem, and the alcohol content of the drink.
     * @return the alcohol content of the drink
     */
    @Override
    public String toString() {
        return super.toString() + " Alc: " + alcoholContent;
    }
}