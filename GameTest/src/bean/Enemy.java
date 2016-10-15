package bean;

/**
 *
 * @author MissAlways
 */
public class Enemy {

    private String name;
    private String description;
    private int helthMax;
    private int helthCurrent;
    private int attack;
    private int lvl;

    public Enemy(String name, String description, int helthMax, int helthCurrent, int attack, int lvl) {
        this.name = name;
        this.description = description;
        this.helthMax = helthMax;
        this.helthCurrent = helthCurrent;
        this.attack = attack;
        this.lvl = lvl;
    }

    public Enemy() {
        name = "";
        description = "";
        helthMax = 100;
        helthCurrent = 100;
        attack = 0;
        lvl = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHelthMax() {
        return helthMax;
    }

    public void setHelthMax(int helthMax) {
        this.helthMax = helthMax;
    }

    public int getHelthCurrent() {
        return helthCurrent;
    }

    public void setHelthCurrent(int helthCurrent) {
        this.helthCurrent = helthCurrent;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    @Override
    public String toString() {
        return "Enemy{" + "name=" + name + ", description=" + description + ", helthMax=" + helthMax + ", helthCurrent=" + helthCurrent + ", attack=" + attack + ", lvl=" + lvl + '}';
    }

}
