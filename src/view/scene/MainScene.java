package view.scene;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Model;
import model.hero.Hero;
import view.element.*;

import java.util.Observable;
import java.util.Observer;

public class MainScene implements Observer, MakeScene {
    Scene scene;
    Model model;
    BorderPane pane;

    FlowPane heroesBox; //CENTER : Pane that contains icons of heroes in main menu
    ScrollPane heroesScrollBox; //CENTER : Scroll of that has the heroesBox FlowPane inside it
    HBox detailBox; //TOP : Box that display information about the hero selected
    HBox bottomBox; //BOT : Box that display information about programm and is current state
    VBox actionBox; //LEFT : Show possible actions to do with selected hero

    public MainScene(Model model) {
        this.model = model;
        pane = new BorderPane();
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
        if(model.getHeroSelected()!=null) {
            updateLeft(actionBox,pane.getCenter() , model);
        }
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
        heroesScrollBox.viewportBoundsProperty().addListener((ov, oldBounds, bounds) -> {
            heroesBox.setPrefWidth(bounds.getWidth());
            heroesBox.setPrefHeight(bounds.getHeight());
        });
        heroesScrollBox.setContent(heroesBox);
    }

    public void updateTop(HBox detailBox, Model model) {
        VBox namesBox = new VBox();
        VBox ratesBox = new VBox();
        Pane blank = new Pane();
        for(Hero h : model.getHeroesList()) {
            if(h.getName().equals(model.getHeroSelected())) {
                ImageView portraitSelection = new ImageView(h.getIcon());
                Label nameSelection = new Label(h.getName());
                Label titleSelection = new Label(h.getTitle());
                new RatesGraph(ratesBox,model);
                detailBox.setMargin(portraitSelection,new Insets(5));
                detailBox.setMargin(namesBox,new Insets(10));
                nameSelection.setFont(new Font(25));
                titleSelection.setFont(new Font(15));
                namesBox.getChildren().addAll(nameSelection,titleSelection);
                namesBox.setAlignment(Pos.CENTER_LEFT);
                blank.setMinWidth(scene.getWidth()-310);
                scene.widthProperty().addListener((ov, oldBounds, bounds) -> blank.setMinWidth(scene.getWidth()-310));
                detailBox.getChildren().addAll(portraitSelection,namesBox,blank,ratesBox);
            }
        }
    }


    public void updateLeft(VBox actionBox, Node center , Model model) {
        HBox statsBox = new HBox();
        StatsIcon statsIcon = new StatsIcon(statsBox,center,model);
        statsBox.setAlignment(Pos.CENTER_LEFT);
        statsBox.setMaxWidth(Double.MAX_VALUE);

        HBox abilitiesBox = new HBox();
        AbilitiesIcon abilitiesIcon = new AbilitiesIcon(abilitiesBox,model);
        abilitiesBox.setAlignment(Pos.CENTER_LEFT);
        abilitiesBox.setMaxWidth(Double.MAX_VALUE);

        HBox talentsBox = new HBox();
        TalentsIcon talentsIcon = new TalentsIcon(talentsBox,model);
        talentsBox.setAlignment(Pos.CENTER_LEFT);
        talentsBox.setMaxWidth(Double.MAX_VALUE);

        HBox backBox = new HBox();
        BackIcon backIcon = new BackIcon(backBox,model);
        backBox.setAlignment(Pos.CENTER_LEFT);
        backBox.setMaxWidth(Double.MAX_VALUE);

        actionBox.setMargin(statsBox,new Insets(15,5,5,5));
        actionBox.setMargin(abilitiesBox,new Insets(5));
        actionBox.setMargin(talentsBox,new Insets(5));
        actionBox.setMargin(backBox,new Insets(5));
        actionBox.setPrefWidth(scene.getWidth() * 0.15);
        scene.widthProperty().addListener((ov, oldBounds, bounds) -> actionBox.setPrefWidth(scene.getWidth() * 0.15));
        actionBox.getChildren().addAll(statsBox,abilitiesBox,talentsBox,backBox);
    }

    public void updateBot() {
        bottomBox = new HBox();
        Label botLabel = new Label("Updated for Patch 25.4 (D.Va)");
        botLabel.setFont(new Font(12));
        HBox.setMargin(botLabel,new Insets(2));
        /*
        Label about = new Label("About");
        about.setAlignment(Pos.CENTER_RIGHT);
        about.setOnMouseClicked(event -> {
            Stage stage = new Stage();
            Pane root = new Pane();
            Scene scene = new Scene(root,240,120);
            Label label = new Label("Heroes Talents\n\nDeveloped by Edouard Murat\n\n\nUpdated for Patch 25.4 (D.Va)");
            label.setAlignment(Pos.CENTER);
            root.getChildren().add(label);
            stage.setScene(scene);
            stage.setTitle("About");
            stage.show();
        });
        */
        bottomBox.getChildren().addAll(botLabel);
    }

    @Override
    public void update(Observable o, Object arg) {
        heroesBox.getChildren().clear();
        updateCenter(heroesBox,heroesScrollBox,model);
        detailBox.getChildren().clear();
        updateTop(detailBox,model);
        if(model.getHeroSelected()!=null) {
            actionBox.getChildren().clear();
            updateLeft(actionBox,pane.getCenter() ,model);
        }
    }

    public Scene getScene() {
        return scene;
    }
}
