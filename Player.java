
public class Player implements Comparable<Player>{

	private String surname;
	private boolean gender; //true for male, false for female
	private int highScore;
	
	public Player(String line)
	{
		String [] tokens = line.split("[ ]+");
		surname = tokens[0];
		/*
		if(tokens[1].equals("(M)"))
			gender = true;
		else if(tokens[1].equals("(F)"))
			gender = false;
			*/
		gender = tokens[1].equals("(M)");
		highScore = Integer.parseInt(tokens[2]);
	}
	
	public int compareTo(Player p)
	{
		if (this.highScore > p.highScore)
			return 1;
		else if (this.highScore < p.highScore)
			return -1;
		else		
			return 0;
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
	public void setGender(boolean gender) {
		this.gender = gender;
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
	 * method to return string representation of a player object
	 */
	public String toString() {
		String gen = (gender) ? "(M)" : "(F)";
		return surname + " " + gen + " " +  highScore;
	}
	
}
