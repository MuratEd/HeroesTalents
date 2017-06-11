package view.element;

import controller.CtrlHeroSelection;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import model.Model;
import model.hero.Hero;

import java.util.ArrayList;

public class RatesGraph {

    public RatesGraph(VBox box, Model model) {
        ImageView damageImage = new ImageView(new Image("res/icons/damage.png",25.0,25.0,true,true));
        ImageView utilityImage = new ImageView(new Image("res/icons/utility.png",25.0,25.0,true,true));
        ImageView survivabilityImage = new ImageView(new Image("res/icons/survivability.png",25.0,25.0,true,true));
        ImageView complexityImage = new ImageView(new Image("res/icons/complexity.png",25.0,25.0,true,true));
        HBox damageBox = new HBox();
        HBox utilityBox = new HBox();
        HBox survivabilityBox = new HBox();
        HBox complexityBox = new HBox();
        Label damageValue = new Label(model.getHero().getRatings().getDamage()+"");
        Label utilityValue = new Label(model.getHero().getRatings().getUtility()+"");
        Label survivabilityValue = new Label(model.getHero().getRatings().getSurvivability()+"");
        Label complexityValue = new Label(model.getHero().getRatings().getComplexity()+"");
        damageValue.setFont(new Font(13));
        utilityValue.setFont(new Font(13));
        survivabilityValue.setFont(new Font(13));
        complexityValue.setFont(new Font(13));
        damageValue.setPadding(new Insets(0,0,0,5));
        utilityValue.setPadding(new Insets(0,0,0,5));
        survivabilityValue.setPadding(new Insets(0,0,0,5));
        complexityValue.setPadding(new Insets(0,0,0,5));
        damageBox.setAlignment(Pos.CENTER_LEFT);
        utilityBox.setAlignment(Pos.CENTER_LEFT);
        survivabilityBox.setAlignment(Pos.CENTER_LEFT);
        complexityBox.setAlignment(Pos.CENTER_LEFT);
        Tooltip.install(damageBox,new Tooltip("Damage"));
        Tooltip.install(utilityBox,new Tooltip("Utility"));
        Tooltip.install(survivabilityBox,new Tooltip("Survivability"));
        Tooltip.install(complexityBox,new Tooltip("Complexity"));

        damageBox.getChildren().addAll(damageImage,damageValue);
        utilityBox.getChildren().addAll(utilityImage,utilityValue);
        survivabilityBox.getChildren().addAll(survivabilityImage,survivabilityValue);
        complexityBox.getChildren().addAll(complexityImage,complexityValue);

        box.getChildren().addAll(damageBox,utilityBox,survivabilityBox,complexityBox);
        box.setAlignment(Pos.CENTER_RIGHT);
    }
}
