package model.hero;

import javafx.scene.image.Image;

public class Talent {
    private String name;
    private Image icon;
    private String description;
    private String questDescription;
    private String rewardDescription;

    public Talent() {
        this.name = "";
        this.icon = null;
        this.description = "";
        this.questDescription = "";
        this.rewardDescription = "";
    }
}
