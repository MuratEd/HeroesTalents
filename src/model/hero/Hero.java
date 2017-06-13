package model.hero;

import javafx.scene.image.Image;
import model.hero.enumeration.*;

import java.util.ArrayList;

public class Hero {
    private String name;
    private String title;
    private String description;
    private Image icon;
    private Role role;
    private Type type;
    private Franchise franchise;
    private Difficulty difficulty;
    private Ratings ratings;
    private ArrayList<String> tags;
    private Statistic stats;
    private AbilityList abilities;
    private TalentTree talents;

    public Hero() {
        this.name = null;
        this.title = null;
        this.description = null;
        this.icon = null;
        this.role = null;
        this.type = null;
        this.franchise = null;
        this.difficulty = null;
        this.ratings = null;
        this.tags = null;
        this.stats = null;
        this.abilities = null;
        this.talents = null;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", role=" + role +
                ", type=" + type +
                ", franchise=" + franchise +
                ", difficulty=" + difficulty +
                ", ratings=" + ratings +
                ", tags=" + tags +
                ", stats=" + stats +
                ", abilities=" + abilities +
                ", talents=" + talents +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setIcon(String pathIcon) {
        this.icon = new Image("res/heroes/"+pathIcon);
    }
    public void setRole(String role) {
        switch(role) {
            case "Warrior":
                this.role = Role.WARRIOR;
                break;
            case "Assassin":
                this.role = Role.ASSASSIN;
                break;
            case "Support":
                this.role = Role.SUPPORT;
                break;
            case "Specialist":
                this.role = Role.SPECIALIST;
                break;
            case "Multiclass":
                this.role = Role.MULTICLASS;
                break;
        }
    }
    public void setType(String type) {
        switch(type) {
            case "Melee":
                this.type = Type.MELEE;
                break;
            case "Ranged":
                this.type = Type.RANGED;
                break;
        }
    }
    public void setFranchise(String franchise) {
        switch(franchise) {
            case "Warcraft":
                this.franchise = Franchise.WARCRAFT;
                break;
            case "Diablo":
                this.franchise = Franchise.DIABLO;
                break;
            case "Starcraft":
                this.franchise = Franchise.STARCRAFT;
                break;
            case "Overwatch":
                this.franchise = Franchise.OVERWATCH;
                break;
            case "Classic":
                this.franchise = Franchise.CLASSIC;
                break;
        }
    }
    public void setDifficulty(String difficulty) {
        switch(difficulty) {
            case "Easy":
                this.difficulty = Difficulty.EASY;
                break;
            case "Medium":
                this.difficulty = Difficulty.MEDIUM;
                break;
            case "Hard":
                this.difficulty = Difficulty.HARD;
                break;
            case "Very Hard":
                this.difficulty = Difficulty.VERY_HARD;
                break;
        }
    }
    public void setRatings(int damage,int utility,int survivability,int complexity) {
        this.ratings = new Ratings();
        this.ratings.setDamage(damage);
        this.ratings.setUtility(utility);
        this.ratings.setSurvivability(survivability);
        this.ratings.setComplexity(complexity);
    }
    public void setTags(ArrayList<String> tags) {
        for(String s : tags) {
            this.tags.add(s);
        }
    }
    public void setStats(double hp,double hpRegen,double mana,double manaRegen,double attackPerSec,double attackRange,double attackDamage,int physicalArmor,int magicalArmor) {
        Statistic tmp = new Statistic();
        tmp.setHp(hp);
        tmp.setHpRegen(hpRegen);
        tmp.setMana(mana);
        tmp.setManaRegen(manaRegen);
        tmp.setAttackPerSec(attackPerSec);
        tmp.setAttackRange(attackRange);
        tmp.setAttackDamage(attackDamage);
        tmp.setPhysicalArmor(physicalArmor);
        tmp.setMagicalArmor(magicalArmor);
    }
    public void setAbilities(AbilityList abilities) {
        this.abilities = abilities;
    }
    public void setTalents(TalentTree talents) {
        this.talents = talents;
    }

    public String getName() {
        return name;
    }
    public String getTitle() {
        return title;
    }
    public Image getIcon() {
        return icon;
    }
    public Ratings getRatings() {
        return ratings;
    }
}
