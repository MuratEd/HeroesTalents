package model.hero.enumeration;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_HARD_LIGHTPeer;

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
