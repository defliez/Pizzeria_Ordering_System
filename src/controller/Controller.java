package controller;

import model.*;
import model.MenuItem;
import view.ButtonType;
import view.MainFrame;

import javax.swing.*;
import java.util.ArrayList;

/**
 * This class is the controller of the application.
 * It is responsible for the communication between the model and the view, and the sequences of the application.
 *
 * @author Valentino Glave
 */
public class Controller implements MenuController {

    // View
    private MainFrame view; // View
    private ButtonType currentLeftMenu = ButtonType.NoChoice;
    private ArrayList<MenuItem> foodMenuString;
    private ArrayList<MenuItem> drinkMenuString;
    private double costCurrentOrder = 0; // Cost of current order, default 0
    private ArrayList<MenuItem> currentOrderArray; // Array of current order
    private ArrayList<Order> orderHistoryMenuString; // Array of order history
    Order currentOrder;

    /**
     * Constructor for the controller.
     * It instantiates the instance variables.
     * It also adds the menu items to the menu and enables the buttons.
     */
    public Controller() {
        view = new MainFrame(1000, 500, this);
        foodMenuString = new ArrayList<MenuItem>();
        drinkMenuString = new ArrayList<MenuItem>();
        currentOrderArray = new ArrayList<MenuItem>();
        orderHistoryMenuString = new ArrayList<Order>();

        // Populate menu with example items
        foodMenuString.add(new Pizza("Margherita", 10, "Tomato sauce, mozzarella cheese"));
        foodMenuString.add(new Pizza("Pepperoni", 12, "Tomato sauce, mozzarella cheese, pepperoni"));
        foodMenuString.add(new Pizza("Hawaiian", 12, "Tomato sauce, mozzarella cheese, ham, pineapple"));
        drinkMenuString.add(new Alcohol("Beer", 5, 4.5));
        drinkMenuString.add(new Alcohol("Wine", 8, 12));
        drinkMenuString.add(new Alcohol("Whisky", 10, 40));
        drinkMenuString.add(new NonAlcohol("Soda", 2));
        drinkMenuString.add(new NonAlcohol("Water", 1));

        view.enableAllButtons();
        view.disableAddMenuButton();
        view.disableViewSelectedOrderButton();
    }

    /**
     * Clears both panels and displays a default message.
     */
    public void clearList() {
        ArrayList<MenuItem> defaultList = new ArrayList<>();
        defaultList.add(new DummyMenuItem("Nothing selected"));
        view.populateLeftPanel(defaultList);
        view.populateRightPanel(defaultList);
    }

    /**
     * This method is called by class MainFrame when a button in the GUI is pressed.
     * It is responsible for the communication between the model and the view, and the sequences of the application.
     *
     * @param buttonType The button that was pressed.
     */
    public void buttonPressed(ButtonType button) {

        switch (button) {
            case Add:
                addItemToOrder(view.getSelectionLeftPanel());
                break;

            case Food:
                setToFoodMenu();
                break;

            case Drinks:
                setToDrinkMenu();
                break;

            case MakePizza:
                //addNewFood();
                break;

            case OrderHistory:
                setToOrderHistoryMenu();
                break;

            case Order:
                placeOrder();
                break;

            case ViewOrder:
                viewSelectedOrder(view.getSelectionLeftPanel());
                break;
        }
    }

    /**
     * Adds an item to the current order.
     * It also updates the cost of the current order.
     * @param item The item to be added.
     */
    public void addItemToOrder(int selectionIndex) {
        if (selectionIndex != -1) { // if something is selected in the left menu list
            switch (currentLeftMenu) {
                case Food:
                    MenuItem selectedItem = foodMenuString.get(selectionIndex);
                    currentOrderArray.add(selectedItem);
                    break;
                case Drinks:
                    selectedItem = drinkMenuString.get(selectionIndex);
                    currentOrderArray.add(selectedItem);
                    break;
            }
            costCurrentOrder = costCurrentOrder + currentOrderArray.get(currentOrderArray.size() - 1).getPrice();
            try {
                view.populateRightPanel(currentOrderArray); // update the panel with current order items
            } catch (NullPointerException e) { // if no item is selected
                System.out.println("No item selected");
            }
            view.setTextCostLabelRightPanel("Total cost of order: " + String.valueOf(costCurrentOrder)); //set the text to show cost of current order
        }
    }

    /**
     * Sets the left panel to the food menu.
     */
    public void setToFoodMenu() {
        currentLeftMenu = ButtonType.Food;
        view.populateLeftPanel(foodMenuString);
        try {
            view.populateRightPanel(currentOrderArray); // update the panel with current order items
        } catch (NullPointerException e) { // if current order is empty
            System.out.println("Current order is empty");

        }
        view.setTextCostLabelRightPanel("Total cost of order: " + String.valueOf(costCurrentOrder)); //set the text to show cost of current order
        view.enableAllButtons();
        view.disableFoodMenuButton();
        view.disableViewSelectedOrderButton();
    }

    /**
     * Sets the left panel to the drink menu.
     */
    public void setToDrinkMenu() {
        currentLeftMenu = ButtonType.Drinks;
        view.populateLeftPanel(drinkMenuString);

        try {
            view.populateRightPanel(currentOrderArray); //update left panel with new item - this takes a shortcut in updating the entire information in the panel not just adds to the end
        } catch (NullPointerException e) { // if current order is empty
            System.out.println("Current order is empty");

        }
        view.setTextCostLabelRightPanel("Total cost of order: " + String.valueOf(costCurrentOrder)); //set the text to show cost of current order
        view.enableAllButtons();
        view.disableDrinksMenuButton();
        view.disableViewSelectedOrderButton();
    }

    /**
     * Sets the left panel to the order history menu.
     */
    public void setToOrderHistoryMenu() {
        currentLeftMenu = ButtonType.OrderHistory;
        clearList();
        costCurrentOrder = 0;
        view.setTextCostLabelRightPanel("Total cost of order: " + String.valueOf(costCurrentOrder)); //set the text to show cost of current order
        view.populateLeftPanel(orderHistoryMenuString); // update the panel with all completed orders
        view.enableAllButtons();
        view.disableAddMenuButton();
        view.disableOrderButton();
    }

    /**
     * Places the current order and adds it to the order history.
     * It also clears the current order.
     */
    public void placeOrder() {

        currentOrder = new Order(currentOrderArray);
        if (currentOrder.getOrderItems().size() > 0 && currentOrder.hasPizza()) { // if the order has at least one item and at least one pizza
            if (currentOrder.hasAlcohol()) { // if the order has alcohol
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "This order contains alcohol. Are you over the age of 18?", "Warning", dialogButton);
                if (dialogResult == JOptionPane.NO_OPTION) {
                    currentOrderArray.clear(); // clear the current order
                    clearList(); // clear the right panel
                    costCurrentOrder = 0;  // reset the cost of the current order
                    view.setTextCostLabelRightPanel("Total cost of order: " + String.valueOf(costCurrentOrder)); //set the text to show cost of current order
                    view.enableAllButtons();
                    view.disableAddMenuButton();
                    view.disableViewSelectedOrderButton();
                    return;
                }
            }
            orderHistoryMenuString.add(currentOrder); // add the order to the order history
            currentOrderArray.clear(); // clear the current order
            view.enableAllButtons();
            view.disableAddMenuButton();
            view.disableViewSelectedOrderButton();
            currentOrderArray.clear(); // clear the current order
            costCurrentOrder = 0;  // reset the cost of the current order
            view.setTextCostLabelRightPanel("Total cost of order: " + String.valueOf(costCurrentOrder)); //set the text to show cost of current order
            clearList(); // clear the right panel
            view.enableAllButtons();
            view.disableAddMenuButton();
            view.disableViewSelectedOrderButton();
        } else {
            JOptionPane.showMessageDialog(null, "You must add at least one pizza to place an order");
        }
    }

    /**
     * View the selected order in the order history
     *
     * @param selectionIndex The index of the order to be viewed.
     */
    public void viewSelectedOrder(int selectionIndex) {
        System.out.println("Index selection left panel: " + selectionIndex); //for test purposes  - remove when not needed
        if (selectionIndex != -1) { // if something is selected in the left menu list
            switch (currentLeftMenu) { //This might need to change depending on architecture
                case OrderHistory:
                    Order selectedItem = orderHistoryMenuString.get(selectionIndex);
                    view.populateRightPanel(selectedItem.getOrderItems());
                    view.setTextCostLabelRightPanel("Total cost of order: " + selectedItem.getTotalPrice()); //set the text to show cost of viewed order
                    break;
            }
        }
    }

    /**
     * Main method to run the program.
     */
    public static void main(String[] args) {
        new Controller();
    }
}
