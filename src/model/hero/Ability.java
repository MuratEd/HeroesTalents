package model.hero;

import javafx.scene.image.Image;

public class Ability {
    private String name;
    private Image icon;
    private String description;
    private int manaCost;
    private int cooldown;

    public Ability() {
        this.name = "";
        this.icon = null;
        this.description = "";
        this.manaCost = 0;
        this.cooldown = 0;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setIcon(String pathIcon) {
        this.icon = new Image(pathIcon);
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }
    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }
}
