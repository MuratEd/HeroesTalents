package model.hero.enumeration;

public enum Difficulty {
    EASY("Easy"),
    MEDIUM("Medium"),
    HARD("Hard"),
    VERY_HARD("Very Hard");

    private String difficulty = "";

    Difficulty(String difficulty){
        this.difficulty = difficulty;
    }

    public String toString(){
        return difficulty;
    }
}
