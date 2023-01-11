package model;

/**
 * A class representing a dummy menu item.
 * This class extends the base model.MenuItem class and is used to instantiate a dummy item after clearing
 * the panels in the view, since MenuItem is an abstract class.
 * @author Valentino Glave
 */
public class DummyMenuItem extends MenuItem {

    /**
     * Constructs a dummy menu item with the given name and price.
     * @param name the name of the menu item
     * @param price the price of the menu item
     */
    public DummyMenuItem(String name) {
        super(name, 0.0);
    }
}
