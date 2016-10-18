/**
 * 
 */
package bean;

/**
 * @author MissAlways
 *
 */
public class Course {
	private int courseId;
	private String name;
	private String description;
	private int done;
	private int have;
	private double cost;

	/**
	 * @param courseId
	 *            identify course
	 * @param name
	 *            title of course
	 * @param description
	 *            description of course
	 * @param done
	 *            how much player have studied this course
	 * @param have
	 *            how much player need to study this course
	 * @param cost
	 *            how much this course cost from player
	 */
	public Course(int courseId, String name, String description, int done,
			int have, double cost) {
		this.courseId = courseId;
		this.name = name;
		this.description = description;
		this.done = done;
		this.have = have;
		this.cost = cost;
	}

	/**
	 * 
	 */
	public Course() {
		courseId = 0;
		name = "";
		description = "";
		done = 0;
		have = 10;
		cost = 200;
	}

	/**
	 * @return the courseId
	 */
	public int getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId
	 *            the courseId to set
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the done
	 */
	public int getDone() {
		return done;
	}

	/**
	 * @param done
	 *            the done to set
	 */
	public void setDone(int done) {
		this.done = done;
	}

	/**
	 * @return the have
	 */
	public int getHave() {
		return have;
	}

	/**
	 * @param have
	 *            the have to set
	 */
	public void setHave(int have) {
		this.have = have;
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
		return "Course [courseId=" + courseId + ", name=" + name
				+ ", description=" + description + ", done=" + done + ", have="
				+ have + ", cost=" + cost + "]";
	}

}
