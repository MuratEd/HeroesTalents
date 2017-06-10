package view.element;

import controller.Controller;
import controller.CtrlHeroSelection;
import controller.CtrlMenuStats;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import model.Model;

//Icon for Heroes with an image and a name
public class StatsIcon {
    private ImageView image;
    private Label name;

    public StatsIcon(HBox box,Model model) {
        this.image = new ImageView(new Image("res/icons/heroes.png"));
        this.name = new Label("Stats");
        box.getChildren().addAll(image,name);
        box.setAlignment(Pos.CENTER);
        name.setFont(new Font(15));
        image.setOnMouseClicked(new CtrlMenuStats(model));
    }
}
