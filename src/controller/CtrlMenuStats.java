package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import model.Model;

public class CtrlMenuStats extends Controller implements EventHandler {

    String name;

    public CtrlMenuStats(Model model) {
        super(model);
        this.name = model.getHeroSelected();
    }

    @Override
    public void handle(Event event) {
        System.out.println("Access : Statistic menu for "+name);
    }
}