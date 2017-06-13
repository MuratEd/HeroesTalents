package model.hero.enumeration;

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
