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

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class View implements Observer {

    //VARIABLES
        //MVC
    Model model; //MVC's model
    Controller controller; //MVC's controller
        //Center
    FlowPane heroesBox; //Pane that contains icons of heroes in main menu
    ScrollPane heroesScrollBox; //Scroll of that has the heroesBox FlowPane inside it
        //Top
    HBox detailBox; //Box that display information about the hero selected
        //Bot
    HBox bottomBox; //Box that display information about programm and is current state
        //Left
    ListView<String> listBuild;

    //CONSTRUCTOR
    public View(Model model, Controller controller) {
        //Linking MVC elements
        this.controller = controller;
        this.model = model;
        setupView();
    }

    //Method that prepare and show the view
    public void setupView() {
        //Initialising main scene
        Stage stage = new Stage();
        BorderPane pane = new BorderPane();
        pane.setPrefSize(1000,600);
        Scene scene = new Scene(pane,1000,600);

        //CENTER : Heroes selection zone
        heroesBox = new FlowPane(Orientation.HORIZONTAL);
        heroesScrollBox = new ScrollPane();
        updateCenter(heroesBox,heroesScrollBox);
        pane.setCenter(heroesScrollBox);

        //UPSIDE : Hero description zone
        detailBox = new HBox();
        updateTop(detailBox);
        pane.setTop(detailBox);

        //LEFTSIDE : List of build saved for hero selected
        //updateLeft();
        //pane.setLeft(listBuild);

        //BOTTOM : Informations
        updateBot();
        pane.setBottom(bottomBox);

        //Parameters of the stage and display
        stage.setTitle("Heroes Talents");
        stage.getIcons().add(new Image("res/icon.png"));
        stage.setScene(scene);
        stage.show();
    }

    private void updateCenter(FlowPane heroesBox, ScrollPane scrollBox) {
        VBox box;
        //For each hero in list heroesList from model...
        for(Hero h : model.getHeroesList()) {
            //Create his icon and add it into heroesBox FlowPane
            box = new VBox(); //Box that will be modify in HeroIcon Constructor (adding portrait and name)
            new HeroIcon(new ImageView(h.getPortrait()),new Label(h.getName()),box,model);
            heroesBox.setMargin(box,new Insets(5));
            heroesBox.getChildren().add(box);
        }
        //Insert heroesBox FlowPane into a ScrollPane
        heroesScrollBox.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);    // Horizontal scroll bar
        heroesScrollBox.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        //Listener to change bounds of pane when window's size is modified
        heroesScrollBox.viewportBoundsProperty().addListener(new ChangeListener<Bounds>()
        {
            @Override
            public void changed(ObservableValue<? extends Bounds> ov, Bounds oldBounds, Bounds bounds) {
                heroesBox.setPrefWidth(bounds.getWidth());
                heroesBox.setPrefHeight(bounds.getHeight());
            }
        });
        heroesScrollBox.setContent(heroesBox);
    }

    private void updateTop(HBox detailBox) {
        VBox namesBox = new VBox();
        StackPane stackBox = new StackPane();
        for(Hero h : model.getHeroesList()) {
            if(h.getName().equals(model.getHeroSelected())) {
                ImageView portraitSelection = new ImageView(h.getPortrait());
                Label nameSelection = new Label(h.getName());
                Label titleSelection = new Label(h.getTitle());
                Button detailButton = new Button("See more  >>");

                detailBox.setMargin(portraitSelection,new Insets(5));
                detailBox.setMargin(namesBox,new Insets(10));
                nameSelection.setFont(new Font(25));
                titleSelection.setFont(new Font(15));
                namesBox.getChildren().addAll(nameSelection,titleSelection);
                namesBox.setAlignment(Pos.CENTER_LEFT);
                detailButton.setFont(new Font(20));
                stackBox.setAlignment(Pos.CENTER_RIGHT);
                StackPane.setMargin(detailButton,new Insets(40));
                stackBox.getChildren().add(detailButton);

                detailBox.getChildren().addAll(portraitSelection,namesBox,stackBox);
                HBox.setHgrow(stackBox, Priority.ALWAYS);
            }
        }
    }

    private void updateLeft() {
        listBuild = new ListView<String>();
        ObservableList<String> list = FXCollections.observableArrayList();
        for(int i = 0; i<new Random().nextInt(8)+1; ++i) {
            list.add("Saved build n°"+(i+1));
        }
        //Read builds saved of the hero selected
        listBuild.setItems(list);
    }

    private void updateBot() {
        bottomBox = new HBox();
        Label botLabel = new Label("Updated for Patch 24.4 (Cassia)");
        botLabel.setFont(new Font(12));
        HBox.setMargin(botLabel,new Insets(2));
        bottomBox.getChildren().add(botLabel);
    }

    @Override
    public void update(Observable o, Object arg) {
        heroesBox.getChildren().clear();
        updateCenter(heroesBox,heroesScrollBox);
        detailBox.getChildren().clear();
        updateTop(detailBox);
        //updateLeft();
    }
}
