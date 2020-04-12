package ChosenClass;

public abstract class ChosenClass {
	private Skills skills;
	private ClassesType chosenClass;
	private RaceType raceType;
	private Background background;
	/**
	 * @return the skills
	 */
	public Skills getSkills() {
		return skills;
	}
	/**
	 * @return the chosenClass
	 */
	public ClassesType getChosenClass() {
		return chosenClass;
	}
	/**
	 * @return the raceType
	 */
	public RaceType getRaceType() {
		return raceType;
	}
	/**
	 * @return the background
	 */
	public Background getBackground() {
		return background;
	}
	/**
	 * @param skills the skills to set
	 */
	public void setSkills(Skills skills) {
		this.skills = skills;
	}
	/**
	 * @param chosenClass the chosenClass to set
	 */
	public void setChosenClass(ClassesType chosenClass) {
		this.chosenClass = chosenClass;
	}
	/**
	 * @param raceType the raceType to set
	 */
	public void setRaceType(RaceType raceType) {
		this.raceType = raceType;
	}
	/**
	 * @param background the background to set
	 */
	public void setBackground(Background background) {
		this.background = background;
	}
	
	
	
}
