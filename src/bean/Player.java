/**
 * 
 */
package bean;

import java.util.List;

/**
 * @author MissAlways
 *
 */
public class Player {
	private int playerId;
	private String name;
	private int hunger;
	private int health;
	private int happiness;
	private double money;
	private List<Item> inventory;
	private List<Course> courses;
	private List<HomeUpgrade> homeUpgrades;

	/**
	 * @param playerId
	 *            identify player
	 * @param name
	 *            name of player
	 * @param hunger
	 *            how hungry player is
	 * @param health
	 *            how how much health player have
	 * @param happiness
	 *            how happy player is
	 * @param money
	 *            how much money player have
	 * @param inventory
	 *            list of items that player have
	 * @param courses
	 *            list of courses that player study
	 * @param homeUpgrades
	 *            list of home upgrades that player bought
	 */
	public Player(int playerId, String name, int hunger, int health, int happiness, double money, List<Item> inventory,
			List<Course> courses, List<HomeUpgrade> homeUpgrades) {
		this.playerId = playerId;
		this.name = name;
		this.hunger = hunger;
		this.health = health;
		this.happiness = happiness;
		this.money = money;
		this.inventory = inventory;
		this.courses = courses;
		this.homeUpgrades = homeUpgrades;
	}

	public Player() {
		playerId = 0;
		name = "";
		hunger = 100;
		health = 100;
		happiness = 100;
		money = 100;
		inventory = null;
		courses = null;
		homeUpgrades = null;
	}

	/**
	 * @return the playerId
	 */
	public int getPlayerId() {
		return playerId;
	}

	/**
	 * @param playerId
	 *            the playerId to set
	 */
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the hunger
	 */
	public int getHunger() {
		return hunger;
	}

	/**
	 * @param hunger
	 *            the hunger to set
	 */
	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @param health
	 *            the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * @return the happiness
	 */
	public int getHappiness() {
		return happiness;
	}

	/**
	 * @param happiness
	 *            the happiness to set
	 */
	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}

	/**
	 * @return the money
	 */
	public double getMoney() {
		return money;
	}

	/**
	 * @param money
	 *            the money to set
	 */
	public void setMoney(double money) {
		this.money = money;
	}

	/**
	 * @return the inventory
	 */
	public List<Item> getInventory() {
		return inventory;
	}

	/**
	 * @param inventory
	 *            the inventory to set
	 */
	public void setInventory(List<Item> inventory) {
		this.inventory = inventory;
	}

	/**
	 * @return the courses
	 */
	public List<Course> getCourses() {
		return courses;
	}

	/**
	 * @param courses
	 *            the courses to set
	 */
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	/**
	 * @return the homeUpgrades
	 */
	public List<HomeUpgrade> getHomeUpgrades() {
		return homeUpgrades;
	}

	/**
	 * @param homeUpgrades
	 *            the homeUpgrades to set
	 */
	public void setHomeUpgrades(List<HomeUpgrade> homeUpgrades) {
		this.homeUpgrades = homeUpgrades;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", name=" + name + ", hunger=" + hunger + ", health=" + health
				+ ", happiness=" + happiness + ", money=" + money + ", inventory=" + inventory + ", courses=" + courses
				+ ", homeUpgrades=" + homeUpgrades + "]";
	}

}
