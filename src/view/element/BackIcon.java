package view.element;

import controller.CtrlMenuTalents;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import model.Model;

public class BackIcon {
    private ImageView image;
    private Label name;

    public BackIcon(HBox box, Model model) {
        this.image = new ImageView(new Image("res/icons/mounts.png"));
        this.name = new Label("Back");
        box.getChildren().addAll(image,name);
        box.setAlignment(Pos.CENTER);
        name.setFont(new Font(15));
        image.setOnMouseClicked(event -> System.out.println("GO BACK"));
    }
}

