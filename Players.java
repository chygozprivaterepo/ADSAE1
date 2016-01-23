import java.util.*;

public class Players {
	
	private List<Player> players;
	private int currentSize;
	
	public Players()
	{
		players = new ArrayList<Player>();
	}
	
	/**
	 * @param p the player to be added
	 */
	public void add(Player p)
	{
		players.add(p);
		currentSize++;
	}
	
	public void remove(Player p)
	{
		players.remove(p);
		currentSize--;
	}

	/**
	 * @return the players
	 */
	public List<Player> getPlayers() {
		return players;
	}

	/**
	 * @param players the players to set
	 */
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	/**
	 * @return the currentSize
	 */
	public int getCurrentSize() {
		return currentSize;
	}

	/**
	 * @param currentSize the currentSize to set
	 */
	public void setCurrentSize(int currentSize) {
		this.currentSize = currentSize;
	}
	
	/**
	 * @return the current high score
	 */
	public int getHighScore()
	{
		int highest = 0;
		for(Player p: players)
			if(p.getHighScore() > highest)
				highest = p.getHighScore();
		return highest;
	}
	
	/**
	 * sort list in alphabetical order of surname
	 */
	/*public List<Player> sortBySurname()
	{
		
	}
	*/
	
	/**
	 * method to return all the player information in String format
	 */
	public String toString()
	{
		String output = "";
		for(Player p: players)
			output += p + "\n";
		return output;
	}

}
