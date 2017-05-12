package model.hero;

import javafx.scene.image.Image;

/**
 * Class that describe one talent
 */
public class Talent {
    private String name;
    private Image icon;
    private String description;
    private String questDescription;
    private String rewardDescription;

    /**
     * Constructor of Talent, values are set to null or ""
     */
    public Talent() {
        this.name = "";
        this.icon = null;
        this.description = "";
        this.questDescription = "";
        this.rewardDescription = "";
    }
}
