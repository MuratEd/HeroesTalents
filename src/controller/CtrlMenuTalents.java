package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import model.Model;

public class CtrlMenuTalents extends Controller implements EventHandler {

    String name;

    public CtrlMenuTalents(Model model) {
        super(model);
        this.name = model.getHeroSelected();
    }

    @Override
    public void handle(Event event) {
        System.out.println("Access : Talents menu for "+name);
    }
}