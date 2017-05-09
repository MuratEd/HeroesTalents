package model.file;

import model.hero.Hero;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class JSONFile {

    Hero hero;

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        new JSONFile("res/heroes/abathur/data.json");
        System.out.println("\n");
        new JSONFile("res/heroes/alarak/data.json");
        System.out.println("\n");
        new JSONFile("res/heroes/anubarak/data.json");
        System.out.println("\n");
        new JSONFile("res/heroes/artanis/data.json");
        System.out.println("\n");
        new JSONFile("res/heroes/arthas/data.json");
        System.out.println("\n");
        new JSONFile("res/heroes/auriel/data.json");
        System.out.println("\n");
        new JSONFile("res/heroes/azmodan/data.json");
    }

    public JSONFile(String path) {
        this.hero = new Hero();
        readJson(path);
    }

    public void readJson(String path) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(path));
            JSONObject jsonObject = (JSONObject)obj;

            hero.setName((String)jsonObject.get("name"));
            hero.setTitle((String)jsonObject.get("title"));
            hero.setDescription((String)jsonObject.get("description"));
            hero.setIcon((String)jsonObject.get("icon"));
            hero.setRole((String)jsonObject.get("role"));
            hero.setType((String)jsonObject.get("type"));
            hero.setFranchise((String)jsonObject.get("franchise"));
            hero.setDifficulty((String)jsonObject.get("difficulty"));

            //Ratings
            JSONObject ratings = (JSONObject)jsonObject.get("ratings");
            Long damage = (Long)ratings.get("damage");
            Long utility = (Long)ratings.get("utility");
            Long survivabitily = (Long)ratings.get("survivability");
            Long complexity = (Long)ratings.get("complexity");
            hero.setRatings(damage.intValue(),utility.intValue(),survivabitily.intValue(),complexity.intValue());

            //Tags
            ArrayList<String> tagsList = new ArrayList<>();
            JSONArray tags = (JSONArray)jsonObject.get("tags");
            for(Object s : tags) {
                tagsList.add((String)s);
            }

            //Statistics
            JSONObject stats = (JSONObject)jsonObject.get("stats");
            Set<String> keySetStats = stats.keySet();
            double hp = 0;
            double hpRegen = 0;
            double mana = 0;
            double manaRegen = 0;
            double attackPerSecond = 0;
            double attackRange = 0;
            double attackDamage = 0;
            int physicalArmor = 0;
            int magicalArmor = 0;
            for(String s : keySetStats) {
                JSONObject tmp = (JSONObject)stats.get(s);
                hp = ((Double)tmp.get("hp"));
                hpRegen = ((Double)tmp.get("hpRegen"));
                mana = ((Double)tmp.get("mana"));
                manaRegen = ((Double)tmp.get("manaRegen"));
                attackPerSecond = ((Double)tmp.get("attackPerSec"));
                attackRange = ((Double)tmp.get("attackRange"));
                attackDamage = ((Double)tmp.get("attackDamage"));
                physicalArmor = ((Long)tmp.get("physicalArmor")).intValue();
                magicalArmor = ((Long)tmp.get("magicalArmor")).intValue();
            }

            /*System.out.println(
                    "\n"+tagsList
                    +"\n"+hp+" "+hpRegen+" "+mana+" "+manaRegen
                    +"\n"+attackDamage+" "+attackRange+" "+attackPerSecond
                    +"\n"+physicalArmor+" "+magicalArmor);
            */

            //Abilities
            JSONObject abilities = (JSONObject)jsonObject.get("abilities");
            Set<String> keySetAbilities = abilities.keySet();
            for(String s : keySetAbilities) {
                JSONArray jaTmp = (JSONArray)abilities.get(s);
                //System.out.println(s);
                for(int i=0 ; i<jaTmp.size() ; ++i) {
                    JSONObject joTmp = (JSONObject)jaTmp.get(i);
                    //System.out.println(joTmp.get("name"));
                }
            }

            //Talents
            JSONObject talents = (JSONObject)jsonObject.get("talents");
            Set<String> keySetTalentsLevel = talents.keySet();
            for(String s : keySetTalentsLevel) {
                JSONArray jaTmp = (JSONArray)talents.get(s);
                for(int i=0 ; i<jaTmp.size() ; ++i) {
                    JSONObject joTmp = (JSONObject)jaTmp.get(i);
                    //System.out.println(joTmp.get("name"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Hero getHero() {
        return hero;
    }
}
