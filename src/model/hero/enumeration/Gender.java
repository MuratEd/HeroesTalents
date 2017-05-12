package model.hero.enumeration;

/**
 * Enumeration of gender of heroes, not used
 */
public enum Gender {
    MALE("Male"),
    FEMALE("Female");

    private String gender = "";

    Gender(String gender){
        this.gender = gender;
    }

    public String toString(){
        return gender;
    }
}
