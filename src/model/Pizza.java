package model;

// A class representing a pizza menu item.
// This class extends the base model.MenuItem class and includes a list of toppings.
public class Pizza extends MenuItem {
    private String toppings;

    public Pizza(String name, double price, String toppings) {
        super(name, price);
        this.toppings = toppings;
    }
}