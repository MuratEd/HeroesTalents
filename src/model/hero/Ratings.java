package model.hero;

/**
 * Class that regroup ratings of a hero, used in Hero class
 */
public class Ratings {
    private int damage;
    private int utility;
    private int survivability;
    private int complexity;

    /**
     * Constructor of Ratings, all values are set to 0
     */
    public Ratings() {
        this.damage = 0;
        this.utility = 0;
        this.survivability = 0;
        this.complexity = 0;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    public void setUtility(int utility) {
        this.utility = utility;
    }
    public void setSurvivability(int survivability) {
        this.survivability = survivability;
    }
    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }
}
