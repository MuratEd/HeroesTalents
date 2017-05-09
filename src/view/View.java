package view;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.hero.Hero;
import model.Model;
import view.element.HeroIcon;
import view.scene.MainScene;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class View implements Observer {

    //VARIABLES
        //MVC
    Model model; //MVC's model
    Controller controller; //MVC's controller

    //CONSTRUCTOR
    public View(Model model, Controller controller) {
        //Linking MVC elements
        this.controller = controller;
        this.model = model;
        MainScene main = new MainScene(this);
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    public Model getModel() {
        return model;
    }
}
