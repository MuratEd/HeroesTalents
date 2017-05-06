package model.hero;

import javafx.scene.image.Image;

public class Talent {
    private String hero;
    private String name;
    private Image icon;
    private String description;
    private String questDescription;
    private String rewardDescription;
    private int tier;
    private char keyAffected;
    private boolean activable;

    public Talent(String hero, int tier, String name, Image icon, String description, char keyAffected, boolean activable) {
        this.hero = hero;
        this.tier = tier;
        this.name = name;
        this.icon = icon;
        this.description = description;
        this.keyAffected = keyAffected;
        this.activable = activable;
    }


}
