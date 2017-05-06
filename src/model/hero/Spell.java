package model.hero;

import javafx.scene.image.Image;

public class Spell {
    private String hero;
    private String keyAffected;
    private boolean primary;
    private String name;
    private Image icon;
    private String description;
    private int manaCost;
    private int cooldown;

    public Spell(String hero, String keyAffected, boolean primary, String name, Image icon, String description, int manaCost, int cooldown) {
        this.hero = hero;
        this.keyAffected = keyAffected;
        this.primary = primary;
        this.name = name;
        this.icon = icon;
        this.description = description;
        this.manaCost = manaCost;
        this.cooldown = cooldown;
    }

    public String getHero() {
        return hero;
    }
    public String getName() {
        return name;
    }
    public boolean isPrimary() {
        return primary;
    }
    public String getKeyAffected() {
        return keyAffected;
    }
}
