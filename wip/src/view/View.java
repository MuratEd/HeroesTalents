package view;

import controller.Controller;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Model;

import java.util.Observable;

public class View {

    Model model;
    Controller controller;

    public View(Model model, Controller controller) {
        Stage stage = new Stage();
        BorderPane pane = new BorderPane();
        pane.setPrefSize(1000, 600);

        Scene scene = new MainScene(model, pane, 1000, 600);
        stage.setScene(scene);

        stage.setTitle("Heroes Talents");
        stage.getIcons().add(new Image("res/icon.png"));
        stage.setScene(scene);
        stage.show();
    }
}
