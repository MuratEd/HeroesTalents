package view.scene;

import controller.CtrlMenuAbilities;
import controller.CtrlMenuStats;
import controller.CtrlMenuTalents;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import model.Model;
import model.hero.Hero;
import view.element.HeroIcon;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class MainScene implements Observer {
    Scene scene;
    Model model;

    FlowPane heroesBox; //CENTER : Pane that contains icons of heroes in main menu
    ScrollPane heroesScrollBox; //CENTER : Scroll of that has the heroesBox FlowPane inside it
    HBox detailBox; //TOP : Box that display information about the hero selected
    HBox bottomBox; //BOT : Box that display information about programm and is current state
    VBox actionBox; //LEFT : Show possible actions to do with selected hero

    public MainScene(Model model) {
        this.model = model;
        BorderPane pane = new BorderPane();
        pane.setPrefSize(1000,600);
        scene = new Scene(pane,1000,600);

        //CENTER : Heroes selection zone
        heroesBox = new FlowPane(Orientation.HORIZONTAL);
        heroesScrollBox = new ScrollPane();

        updateCenter(heroesBox,heroesScrollBox,model);
        pane.setCenter(heroesScrollBox);

        //UPSIDE : Hero description zone
        detailBox = new HBox();
        updateTop(detailBox,model);
        pane.setTop(detailBox);

        //LEFTSIDE : Access button for different menus
        actionBox = new VBox();
        updateLeft(actionBox,model);
        pane.setLeft(actionBox);

        //BOTTOM : Informations
        updateBot();
        pane.setBottom(bottomBox);
    }

    public void updateCenter(FlowPane heroesBox, ScrollPane scrollBox, Model model) {
        VBox box;
        //For each hero in list heroesList from model...
        for(Hero h : model.getHeroesList()) {
            //Create his icon and add it into heroesBox FlowPane
            box = new VBox(); //Box that will be modify in HeroIcon Constructor (adding portrait and name)
            new HeroIcon(new ImageView(h.getIcon()),new Label(h.getName()),box,model);
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

    public void updateTop(HBox detailBox, Model model) {
        VBox namesBox = new VBox();
        StackPane stackBox = new StackPane();
        for(Hero h : model.getHeroesList()) {
            if(h.getName().equals(model.getHeroSelected())) {
                ImageView portraitSelection = new ImageView(h.getIcon());
                Label nameSelection = new Label(h.getName());
                Label titleSelection = new Label(h.getTitle());
                //Button detailButton = new Button("See more  >>");

                detailBox.setMargin(portraitSelection,new Insets(5));
                detailBox.setMargin(namesBox,new Insets(10));
                nameSelection.setFont(new Font(25));
                titleSelection.setFont(new Font(15));
                namesBox.getChildren().addAll(nameSelection,titleSelection);
                namesBox.setAlignment(Pos.CENTER_LEFT);
                //detailButton.setFont(new Font(20));
                stackBox.setAlignment(Pos.CENTER_RIGHT);
                //StackPane.setMargin(detailButton,new Insets(40));
                //stackBox.getChildren().add(detailButton);

                detailBox.getChildren().addAll(portraitSelection,namesBox,stackBox);
                HBox.setHgrow(stackBox, Priority.ALWAYS);
            }
        }
    }

    public void updateLeft(VBox actionBox, Model model) {
        Button statsButton = new Button("Stats");
        statsButton.setAlignment(Pos.CENTER);
        statsButton.setMaxWidth(Double.MAX_VALUE);
        statsButton.setOnAction(new CtrlMenuStats(model));
        Button abilitiesButton = new Button("Abilities");
        abilitiesButton.setAlignment(Pos.CENTER);
        abilitiesButton.setMaxWidth(Double.MAX_VALUE);
        abilitiesButton.setOnAction(new CtrlMenuAbilities(model));
        Button talentsButton = new Button("Talents");
        talentsButton.setAlignment(Pos.CENTER);
        talentsButton.setMaxWidth(Double.MAX_VALUE);
        talentsButton.setOnAction(new CtrlMenuTalents(model));
        actionBox.setMargin(statsButton,new Insets(5));
        actionBox.setMargin(abilitiesButton,new Insets(5));
        actionBox.setMargin(talentsButton,new Insets(5));
        actionBox.getChildren().addAll(statsButton,abilitiesButton,talentsButton);
    }

    public void updateBot() {
        bottomBox = new HBox();
        Label botLabel = new Label("Updated for Patch 25.4 (D.Va)");
        botLabel.setFont(new Font(12));
        HBox.setMargin(botLabel,new Insets(2));
        bottomBox.getChildren().add(botLabel);
    }

    @Override
    public void update(Observable o, Object arg) {
        heroesBox.getChildren().clear();
        updateCenter(heroesBox,heroesScrollBox,model);
        detailBox.getChildren().clear();
        updateTop(detailBox,model);
        updateLeft(actionBox,model);
    }

    public Scene getScene() {
        return scene;
    }

    public FlowPane getHeroesBox() {
        return heroesBox;
    }

    public ScrollPane getHeroesScrollBox() {
        return heroesScrollBox;
    }

    public HBox getDetailBox() {
        return detailBox;
    }

    public HBox getBottomBox() {
        return bottomBox;
    }
}
