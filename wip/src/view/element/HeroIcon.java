package view.element;

import controller.Controller;
import controller.CtrlHeroSelection;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Model;

//Icon for Heroes with an image and a name
public class HeroIcon {
    private ImageView image;
    private Label name;

    public HeroIcon(ImageView image, Label name, VBox box,Model model) {
        this.image = image;
        this.name = name;
        box.getChildren().addAll(image,name);
        box.setAlignment(Pos.CENTER);
        box.addEventHandler(MouseEvent.MOUSE_CLICKED, new CtrlHeroSelection(name.getText(),model));
    }

    public Label getName() {
        return name;
    }
}
