package controller;

import model.Model;

/**
 * Main class for controller
 */
public class Controller {

    private Model model;

    /**
     * Link the controller with the model
     * @param model Model of the MVC pattern
     */
    public Controller(Model model) {
        this.model = model;
    }

    /**
     * Get the model
     * @return Model linked
     */
    public Model getModel() {
        return model;
    }
}
