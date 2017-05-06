package model.hero;

import javafx.scene.image.Image;

//Define a hero with his portrait, name, talents and stats
public class Hero {
    private String name;
    private String title;
    private Image portrait;
    private SpellList spell;

    public Hero() {
        //do nothing
    }

    public Hero(String name,String title,Image portrait/*,SpellList spells*/) {
        this.name = name;
        this.title = title;
        this.portrait = portrait;
        //this.spell = spells;
    }

    public String getName() {
        return name;
    }

    public String getTitle() { return title; }

    public Image getPortrait() {
        return portrait;
    }
}
