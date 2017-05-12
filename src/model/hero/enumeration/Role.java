package model.hero.enumeration;

/**
 * Enumeration of role of heroes, used in Hero class
 */
public enum Role {
    WARRIOR("Warrior"),
    ASSASSIN("Assassin"),
    SUPPORT("Support"),
    SPECIALIST("Specialist"),
    MULTICLASS("Multiclass");

    private String role = "";

    Role(String role){
        this.role = role;
    }

    public String toString(){
        return role;
    }
}
