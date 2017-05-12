package model.hero.enumeration;

/**
 * Enumeration of combat style of heroes, used in Hero class
 */
public enum Type {
    MELEE("Melee"),
    RANGED("Ranged");

    private String type = "";

    Type(String type){
        this.type = type;
    }

    public String toString(){
        return type;
    }
}
