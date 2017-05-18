package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import model.Model;

public class CtrlMenuAbilities extends Controller implements EventHandler {

    String name;

    public CtrlMenuAbilities(Model model) {
        super(model);
        this.name = model.getHeroSelected();
    }

    @Override
    public void handle(Event event) {
        System.out.println("Access : Abilities menu for "+name);
    }
}
