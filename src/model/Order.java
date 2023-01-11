package model;

import java.util.*;

// A class representing a completed order.
// This class stores a list of menu items and the total price of the order.
public class Order {
    private static int nextId = 1; // static variable to keep track of the next order id
    private int id; // the id of this order
    private List<MenuItem> items; // the list of menu items in this order
    private double totalPrice; // the total price of this order
    private boolean hasPizza = false; // a boolean to keep track of whether this order has a pizza
    private boolean hasAlcohol = false; // a boolean to keep track of whether this order has alcoholic drinks

    public Order(List<MenuItem> items) {
        id = nextId++;
        this.items = new ArrayList<>(items);
        totalPrice = 0;
        for (MenuItem item : items) {
            totalPrice += item.getPrice();
            if (item instanceof Pizza)
                hasPizza = true;
            if (item instanceof Alcohol)
                hasAlcohol = true;
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order " + id + " - $" + totalPrice;
    }

    // returns the list of menu items in this order
    public ArrayList<MenuItem> getOrderItems() {
        ArrayList<MenuItem> orderItems = new ArrayList<>();
        orderItems.addAll(items);
        return orderItems;
    }

    public boolean hasPizza() {
        return hasPizza;
    }

    public boolean hasAlcohol() {
        return hasAlcohol;
    }
}