package model;

import java.util.*;

/**
 * A class representing a completed order.
 * This class stores a list of menu items and the total price of the order.
 *
 * @author Valentino Glave
 */
public class Order {
    private static int nextId = 1; // static variable to keep track of the next order id
    private int id; // the id of this order
    private List<MenuItem> items; // the list of menu items in this order
    private double totalPrice; // the total price of this order
    private boolean hasPizza = false; // a boolean to keep track of whether this order has a pizza
    private boolean hasAlcohol = false; // a boolean to keep track of whether this order has alcoholic drinks

    /**
     * Constructs an order with the given list of menu items.
     *
     * @param items the list of menu items in this order
     */
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

    /**
     * Returns the id of this order.
     *
     * @return the id of this order
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Returns the list of menu items in this order, including the name and price of each item.
     *
     * @return the list of menu items in this order
     */
    @Override
    public String toString() {
        return "Order " + id + " - $" + totalPrice;
    }

    /**
     * Returns the list of menu items in this order.
     *
     * @return the list of menu items in this order
     */
    public ArrayList<MenuItem> getOrderItems() {
        ArrayList<MenuItem> orderItems = new ArrayList<>();
        orderItems.addAll(items);
        return orderItems;
    }

    /**
     * Returns whether this order has a pizza.
     *
     * @return whether this order has a pizza
     */
    public boolean hasPizza() {
        return hasPizza;
    }

    /**
     * Returns whether this order has alcoholic drinks.
     *
     * @return whether this order has alcoholic drinks
     */
    public boolean hasAlcohol() {
        return hasAlcohol;
    }
}