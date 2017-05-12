package model.hero;

import java.util.ArrayList;

/**
 * Class that regroup some Ability object in List, separated into primary, secondary, ultimate and trait abilities
 */
public class AbilityList {
    private ArrayList<Ability> primary;
    private ArrayList<Ability> secondary;
    private ArrayList<Ability> ultimate;
    private Ability trait;

    /**
     * Constructor that initialize lists
     */
    public AbilityList() {
        this.primary = new ArrayList<Ability>(3);
        this.secondary = new ArrayList<Ability>(3);
        this.ultimate = new ArrayList<Ability>(2);
        this.trait = new Ability();
    }

    public void addToPrimary(Ability ability) {
        this.primary.add(ability);
    }
    public void addToSecondary(Ability ability) {
        this.secondary.add(ability);
    }
    public void addToUltimate(Ability ability) {
        this.ultimate.add(ability);
    }
}
