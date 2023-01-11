package view;

import javax.swing.*;
import java.util.ArrayList;

public class LPanel extends JPanel {
    private JList<Object> leftPanelList;
    private JButton btnShowDrinks;
    private JButton btnShowFood;
    private JButton btnShowOrderHistory;
    private JButton btnCreateNewPizzaType;
    private JButton btnAddSelectionToOrder;
    private JLabel titleLeftPanel;
    private int width;
    private int height;
    private MainFrame mainFrame;

    public LPanel(int width, int height, MainFrame mainFrame) {
        // Instantiate the variables
        this.mainFrame = mainFrame;
        this.setLayout(null);
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        setLocation(0, 0);
        setUp();
    }

    // Set up the left panel
    private void setUp() {
        titleLeftPanel = new JLabel("Make menu choice with buttons");
        titleLeftPanel.setLocation(20, 0);
        titleLeftPanel.setSize(width / 2, 20);
        this.add(titleLeftPanel);

        leftPanelList = new JList<>();
        leftPanelList.setLocation(0, 23);
        leftPanelList.setSize(width, height - 100);
        this.add(leftPanelList);

        btnShowFood = new JButton("Food");
        btnShowFood.setEnabled(true);
        btnShowFood.setSize(width / 5, 30);
        btnShowFood.setLocation(0, height - 75);
        btnShowFood.addActionListener(l -> mainFrame.buttonPressed(ButtonType.Food));
        this.add(btnShowFood);

        btnShowDrinks = new JButton("Drinks");
        btnShowDrinks.setEnabled(true);
        btnShowDrinks.setSize(width / 5, 30);
        btnShowDrinks.setLocation(width / 5, height - 75);
        btnShowDrinks.addActionListener(l -> mainFrame.buttonPressed(ButtonType.Drinks));
        this.add(btnShowDrinks);

        btnAddSelectionToOrder = new JButton("Add");
        btnAddSelectionToOrder.setEnabled(true);
        btnAddSelectionToOrder.setSize(width / 5, 30);
        btnAddSelectionToOrder.addActionListener(l -> mainFrame.buttonPressed(ButtonType.Add));
        btnAddSelectionToOrder.setLocation((width / 5) * 3, height - 75);
        this.add(btnAddSelectionToOrder);

        btnShowOrderHistory = new JButton("Order history");
        btnShowOrderHistory.setEnabled(true);
        btnShowOrderHistory.setSize(width / 5, 30);
        btnShowOrderHistory.setLocation((width / 5) * 4, height - 75);
        btnShowOrderHistory.addActionListener(l -> mainFrame.buttonPressed(ButtonType.OrderHistory));
        this.add(btnShowOrderHistory);

        btnCreateNewPizzaType = new JButton("Make Pizza");
        btnCreateNewPizzaType.setEnabled(true);
        btnCreateNewPizzaType.setSize(width / 5, 30);
        btnCreateNewPizzaType.setLocation((width / 5) * 2, height - 75);
        btnCreateNewPizzaType.addActionListener(l -> {
            mainFrame.buttonPressed(ButtonType.MakePizza); //fog grade VG: what happens if this button is pressed ultiple times?
        });
        this.add(btnCreateNewPizzaType);
    }

    /**
     * This method sets the information in the panel's list view.
     *
     * @param informationArray An arraylist of either menu items or orders where each element will be shown
     *                         one line in the panel.
     */
    protected <T> void populateList(ArrayList<T> informationArray) {
        DefaultListModel<T> listModel = new DefaultListModel<>();
        for (T item : informationArray) {
            listModel.addElement(item);
        }
        leftPanelList.setModel((ListModel<Object>) listModel);
    }

    protected JList<Object> getLeftPanelList() {
        return leftPanelList;
    }

    protected JButton getShowOrderHistory() {
        return btnShowOrderHistory;
    }

    protected JButton getBtnShowDrinks() {
        return btnShowDrinks;
    }

    protected JButton getBtnShowFood() {
        return btnShowFood;
    }

    protected JButton getBtnAddSelectionToOrder() {
        return btnAddSelectionToOrder;
    }

    protected JButton getBtnCreateNewPizzaType() {
        return btnCreateNewPizzaType;
    }
}
