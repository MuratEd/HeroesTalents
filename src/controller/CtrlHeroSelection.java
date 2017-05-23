package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import model.Model;

/**
 * Controller class that can modify the hero selection
 */
public class CtrlHeroSelection extends Controller implements EventHandler {

    private String name;

    /**
     * Constructor of hero selection controller
     * @param name Name of hero selected
     * @param model Model of the MVC pattern
     */
    public CtrlHeroSelection(String name, Model model) {
        super(model);
        this.name = name;
    }

    /**
     * Handle method of EventHandler implementation
     * @param event Click event
     */
    @Override
    public void handle(Event event) {
        super.getModel().setHeroSelected(name);
    }
}
