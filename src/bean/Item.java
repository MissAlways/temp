/**
 * 
 */
package bean;

/**
 * @author MissAlways
 *
 */
public class Item {
	private int itemId;
	private String name;
	private String incase;
	private int incaseAmount;
	private double cost;

	/**
	 * @param itemId
	 *            identify item
	 * @param name
	 *            name of item
	 * @param incase
	 *            what buff it gives (hp/food/fun)
	 * @param incaseAmount
	 *            how much buff will it give
	 * @param cost
	 *            how much item cost
	 */
	public Item(int itemId, String name, String incase, int incaseAmount,
			double cost) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.incase = incase;
		this.incaseAmount = incaseAmount;
		this.cost = cost;
	}

	public Item() {
		itemId = 0;
		name = "";
		incase = "";
		incaseAmount = 0;
		cost = 0;
	}

	/**
	 * @return the itemId
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * @param itemId
	 *            the itemId to set
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
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
	 * @return the incase
	 */
	public String getIncase() {
		return incase;
	}

	/**
	 * @param incase
	 *            the incase to set
	 */
	public void setIncase(String incase) {
		this.incase = incase;
	}

	/**
	 * @return the incaseAmount
	 */
	public int getIncaseAmount() {
		return incaseAmount;
	}

	/**
	 * @param incaseAmount
	 *            the incaseAmount to set
	 */
	public void setIncaseAmount(int incaseAmount) {
		this.incaseAmount = incaseAmount;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost
	 *            the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", incase="
				+ incase + ", incaseAmount=" + incaseAmount + ", cost=" + cost
				+ "]";
	}

}
