package model;

// A class representing an alcohol menu item.
// This class extends the base model.MenuItem class and includes an alcohol content.
public class Alcohol extends MenuItem {
    private double alcoholContent;

    public Alcohol(String name, double price, double alcoholContent) {
        super(name, price);
        this.alcoholContent = alcoholContent;
    }

    @Override
    public String toString() {
        return super.toString() + " Alc: " + alcoholContent;
    }
}