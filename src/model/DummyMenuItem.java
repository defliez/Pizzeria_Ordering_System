package model;

// Used to instantiate a dummy item after clearing the panels in the view, since MenuItem is an abstract class.
public class DummyMenuItem extends MenuItem {

    public DummyMenuItem(String name) {
        super(name, 0.0);
    }
}
