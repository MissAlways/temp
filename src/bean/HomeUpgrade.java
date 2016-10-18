package bean;

/**
 * @author MissAlways
 *
 */
public class HomeUpgrade {
	private int upgradeId;
	private String name;
	private String description;

	/**
	 * @param upgradeId
	 *            identify home upgrade
	 * @param name
	 *            title for this upgrade
	 * @param description
	 *            descriotion for home upgrade
	 */
	public HomeUpgrade(int upgradeId, String name, String description) {
		super();
		this.upgradeId = upgradeId;
		this.name = name;
		this.description = description;
	}

	public HomeUpgrade() {
		upgradeId = 0;
		name = "";
		description = "";
	}

	/**
	 * @return the upgradeId
	 */
	public int getUpgradeId() {
		return upgradeId;
	}

	/**
	 * @param upgradeId the upgradeId to set
	 */
	public void setUpgradeId(int upgradeId) {
		this.upgradeId = upgradeId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HomeUpgrade [upgradeId=" + upgradeId + ", name=" + name
				+ ", description=" + description + "]";
	}
	
}
