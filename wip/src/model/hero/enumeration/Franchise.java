package model.hero.enumeration;

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
