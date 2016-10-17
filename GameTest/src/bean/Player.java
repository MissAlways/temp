package bean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MissAlways
 */
public class Player {

    private int playerId;
    private String name;
    private int movingSpeed;
    private int healthMax;
    private int healthCurrent;
    private int lvl;
    private List<Item> inventory;
    private List<Item> equipped;

    public Player(int playerId, String name, int movingSpeed, int healthMax, int healthCurrent, int lvl, List<Item> inventory, List<Item> equipped) {
        this.playerId = playerId;
        this.name = name;
        this.movingSpeed = movingSpeed;
        this.healthMax = healthMax;
        this.healthCurrent = healthCurrent;
        this.lvl = lvl;
        this.inventory = inventory;
        this.equipped = equipped;
    }

    public Player() {
        playerId = 0;
        name = "Player";
        movingSpeed = 100;
        healthMax = 100;
        healthCurrent = 100;
        lvl = 0;
        inventory = new ArrayList<Item>();
        equipped = new ArrayList<Item>();
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMovingSpeed() {
        return movingSpeed;
    }

    public void setMovingSpeed(int movingSpeed) {
        this.movingSpeed = movingSpeed;
    }

    public int getHealthMax() {
        return healthMax;
    }

    public void setHealthMax(int healthMax) {
        this.healthMax = healthMax;
    }

    public int getHealthCurrent() {
        return healthCurrent;
    }

    public void setHealthCurrent(int healthCurrent) {
        this.healthCurrent = healthCurrent;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public List<Item> getEquipped() {
        return equipped;
    }

    public void setEquipped(List<Item> equipped) {
        this.equipped = equipped;
    }

    public void equipItem(Item item) {
        equipped.add(item);
    }

    public void unequipItem(Item item) {
        equipped.remove(item);
    }

    @Override
    public String toString() {
        return "Player{" + "playerId=" + playerId + ", name=" + name + ", movingSpeed=" + movingSpeed + ", healthMax=" + healthMax + ", healthCurrent=" + healthCurrent + ", lvl=" + lvl + ", inventory=" + inventory + '}';
    }

}
