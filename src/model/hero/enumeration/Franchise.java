package model.hero.enumeration;

/**
 * Enumeration of franchise of heroes, used in Hero class
 */
public enum Franchise {
    WARCRAFT("Warcraft"),
    DIABLO("Diablo"),
    STARCRAFT("Starcraft"),
    OVERWATCH("Overwatch"),
    CLASSIC("Blizzard Classic");

    private String franchise = "";

    Franchise(String franchise){
        this.franchise = franchise;
    }

    public String toString(){
        return franchise;
    }
}
