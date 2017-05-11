package view;

import controller.Controller;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Model;
import view.scene.MainScene;

import java.util.Observable;
import java.util.Observer;

public class View implements Observer {

    //VARIABLES
        //MVC
    Model model; //MVC's model
    Controller controller; //MVC's controller

    MainScene main;

    //CONSTRUCTOR
    public View(Model model, Controller controller) {
        //Linking MVC elements
        this.controller = controller;
        this.model = model;
        this.main = new MainScene(model);

        Stage stage = new Stage();
        stage.setTitle("Heroes Talents");
        stage.getIcons().add(new Image("res/icon.png"));
        stage.setScene(main.getScene());
        stage.show();
    }

    @Override
    public void update(Observable o, Object arg) {
        main.getHeroesBox().getChildren().clear();
        main.updateCenter(main.getHeroesBox(),main.getHeroesScrollBox(),model);
        main.getDetailBox().getChildren().clear();
        main.updateTop(main.getDetailBox(),model);
        //updateLeft();
    }
}
