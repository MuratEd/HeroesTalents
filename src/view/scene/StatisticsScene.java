package view.scene;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import model.Model;

public class StatisticsScene {
    ScrollPane centerBox;
    Model model;

    public StatisticsScene(Node center, Model model) {
        this.centerBox = (ScrollPane)center;
        this.model = model;

        Label stats = new Label("Name : "+model.getHero().getName());
        centerBox.setContent(stats);
    }
}
