package model.hero;

/**
 * Class that regroup statistic of a hero, used in Hero class
 */
public class Statistic {
    private double hp;
    private double hpRegen;
    private double mana;
    private double manaRegen;
    private double attackPerSec;
    private double attackRange;
    private double attackDamage;
    private int physicalArmor;
    private int magicalArmor;

    /**
     * Constructor that set all values of Statistic to 0
     */
    public Statistic() {
        this.hp = 0;
        this.hpRegen = 0;
        this.mana = 0;
        this.manaRegen = 0;
        this.attackPerSec = 0;
        this.attackRange = 0;
        this.attackDamage = 0;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }
    public void setHpRegen(double hpRegen) {
        this.hpRegen = hpRegen;
    }
    public void setMana(double mana) {
        this.mana = mana;
    }
    public void setManaRegen(double manaRegen) {
        this.manaRegen = manaRegen;
    }
    public void setAttackPerSec(double attackPerSec) {
        this.attackPerSec = attackPerSec;
    }
    public void setAttackRange(double attackRange) {
        this.attackRange = attackRange;
    }
    public void setAttackDamage(double attackDamage) {
        this.attackDamage = attackDamage;
    }
    public void setPhysicalArmor(int physicalArmor) {
        this.physicalArmor = physicalArmor;
    }
    public void setMagicalArmor(int magicalArmor) {
        this.magicalArmor = magicalArmor;
    }
}
