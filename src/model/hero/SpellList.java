package model.hero;

import model.Model;

import java.util.HashMap;

public class SpellList {
    private HashMap<String,Spell> primarySpellList;
    private HashMap<String,Spell> secondarySpellList;

    public SpellList(Model model, String name) {
        for(Spell s : model.getSpellList()) {
            if(name.equals(s.getHero()) && s.isPrimary()) {
                primarySpellList.put(s.getKeyAffected(),s);
            }
            else if(name.equals(s.getHero()) && !(s.isPrimary())) {
                secondarySpellList.put(s.getKeyAffected(),s);
            }
        }
    }
}
