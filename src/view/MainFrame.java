package view;

import controller.Controller;
import model.MenuItem;
import javax.swing.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private MainPanel mainPanel;
    private Controller controller;


    public MainFrame(int width, int height, Controller controller) {
        super("Restaurant");
        this.controller = controller;
        this.setResizable(false);
        this.setSize(width, height);
        this.mainPanel = new MainPanel(width, height, this);
        this.setContentPane(mainPanel);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * This method sets the information in the LEFT panel of the main window.
     *
     * @param informationArray An array of String where each element will be shown
     *                        one line in the panel.
     */
    /*
    public void populateLeftPanel(ArrayList<MenuItem> informationArray){
        mainPanel.getLeftPanel().populateList(informationArray);

    }

     */

    /**
     * This method sets the information in the RIGHT panel of the main window.
     *
     * @param informationArray An array of String where each element will be shown
     *                         one line in the panel.
     */
    public void populateRightPanel(ArrayList<MenuItem> informationArray) {
        mainPanel.getRightPanel().populateList(informationArray);
    }

    public <T> void populateLeftPanel(ArrayList<T> informationArray) {
        mainPanel.getLeftPanel().populateList(informationArray);
    }


    /**
     * This method returns the index value as an int of the selected row
     * in the list in the left panel of the main window.
     *
     * @return the index of the selected row as an int. If no selection exists -1 is returned.
     */
    public int getSelectionLeftPanel() {
        return mainPanel.getLeftPanel().getLeftPanelList().getSelectedIndex();
    }

    /**
     * This method sets a text that shows to the farthest right in
     * the window above the right listpanel.
     *
     * @param newText the text that is shown in the GUI
     */
    public void setTextCostLabelRightPanel(String newText) {
        mainPanel.getRightPanel().setTextCostLabel(newText);
    }

    /**
     * This method disables the possibility to press the button labeled "Food".
     */
    public void disableFoodMenuButton() {
        mainPanel.getLeftPanel().getBtnShowFood().setEnabled(false);
    }


    /**
     * This method disables the possibility to press the button labeled "Drinks".
     */
    public void disableDrinksMenuButton() {
        mainPanel.getLeftPanel().getBtnShowDrinks().setEnabled(false);
    }


    /**
     * This method disables the possibility to press the button labeled "Add".
     */
    public void disableAddMenuButton() {
        mainPanel.getLeftPanel().getBtnAddSelectionToOrder().setEnabled(false);
    }

    /**
     * This method disables the possibility to press the button labeled "Order".
     */
    public void disableOrderButton() {
        mainPanel.getRightPanel().getBtnCreateOrder().setEnabled(false);
    }

    /**
     * This method disables the possibility to press the button labeled "View order".
     */
    public void disableViewSelectedOrderButton() {
        mainPanel.getRightPanel().getBtnViewSelectedOrder().setEnabled(false);
    }

    /**
     * This method enables all buttons in the GUI to be pressed.
     */
    public void enableAllButtons() {
        mainPanel.getLeftPanel().getBtnShowFood().setEnabled(true);
        mainPanel.getLeftPanel().getBtnShowDrinks().setEnabled(true);
        mainPanel.getLeftPanel().getBtnCreateNewPizzaType().setEnabled(true);
        mainPanel.getLeftPanel().getBtnAddSelectionToOrder().setEnabled(true);
        mainPanel.getLeftPanel().getShowOrderHistory().setEnabled(true);
        mainPanel.getRightPanel().getBtnCreateOrder().setEnabled(true);
        mainPanel.getRightPanel().getBtnViewSelectedOrder().setEnabled(true);
    }

    /**
     * This method is called by other parts of the Gui when a button is pressed.
     * The method buttonPressed in class Controller is called and the type of
     * pressed button is sent as an argument.
     *
     * @param pressedButton the type of button
     * @see ButtonType
     */
    public void buttonPressed(ButtonType pressedButton) {
        controller.buttonPressed(pressedButton);
    }
}
