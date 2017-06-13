package model.hero.enumeration;

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
