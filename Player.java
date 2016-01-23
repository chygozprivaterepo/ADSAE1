
public class Player implements Comparable<Player>{

	private String surname;
	private boolean gender; //true for male, false for female
	private int highScore;
	
	/*
	 * constructor to initialize a Player object
	 */
	public Player(String line)
	{
		String [] tokens = line.split("[ ]+"); //splits the line parameter into an array of strings
		surname = tokens[0]; //the surname will be contained at index 0 of the array
		gender = tokens[1].equals("(M)"); //the gender string will be contained at index 1 of the array.
						//if gender string is (M), the gender is true, otherwise gender is false
		highScore = Integer.parseInt(tokens[2]); //the high score will be at index 2 of the array
	}
	
	public int compareTo(Player p)
	{
		return this.surname.compareTo(p.surname);
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the gender
	 */
	public boolean getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender =  gender.equals("(M)");
	}

	/**
	 * @return the highScore
	 */
	public int getHighScore() {
		return highScore;
	}

	/**
	 * @param highScore the highScore to set
	 */
	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}

	/** 
	 * method to return a string representation of a player object
	 */
	public String toString() {
		String gen = (gender) ? "(M)" : "(F)";
		return surname + " " + gen + " " +  highScore;
	}
	
}
