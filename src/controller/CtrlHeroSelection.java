package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import model.Model;

public class CtrlHeroSelection extends Controller implements EventHandler {

    private String name;

    public CtrlHeroSelection(String name, Model model) {
        super(model);
        this.name = name;
    }

    @Override
    public void handle(Event event) {
        super.getModel().setHeroSelected(name);
    }
}
