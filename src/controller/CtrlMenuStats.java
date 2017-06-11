package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import model.Model;
import view.View;
import view.scene.StatisticsScene;

public class CtrlMenuStats extends Controller implements EventHandler {

    String name;
    Node centerNode;

    public CtrlMenuStats(Node centerNode, Model model) {
        super(model);
        this.centerNode = centerNode;
        this.name = model.getHeroSelected();
    }

    @Override
    public void handle(Event event) {
        new StatisticsScene(centerNode,getModel());
    }
}