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
		Player [] p = (Player[]) players.toArray(); 
		Arrays.sort(p);
		return p[currentSize].getHighScore();
	}
	
}
