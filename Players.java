import java.util.*;

public class Players {
	
	//instance variables
	private List<Player> players;
	private int currentSize;
	
	//constructor to initialize a Players object
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
	
	/**
	 * @param p the player to be removed
	 */
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
	public void sortBySurname()
	{
		Collections.sort(players);
	}
	
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
	
	public void sortByHighScore()
	{
		Player [] temp = new Player[currentSize];
		mergeSortR(players,0,currentSize-1,temp);
	}
	
	/*
	 * recursive method to sort list in descending order of high score
	 */
	private void mergeSortR(List<Player> a, int first, int last, Player [] temp)
	{
		//base condition of recursion.
		if(first == last)
			return;
		
		//split list into 2 parts
		int mid = (first + last) / 2;
		mergeSortR(a,first,mid,temp); //sort first half recursively
		mergeSortR(a,mid+1,last,temp); //sort second half recursively
		
		//merge a half of the list
		int l1 = first, l2 = mid+1, l3 = first;
		while(l1 <= mid && l2 <= last)
		{
			if(a.get(l1).getHighScore() > a.get(l2).getHighScore())
				temp[l3++] = a.get(l1++);
			else
				temp[l3++] = a.get(l2++);
		}
		while(l1 <= mid)
			temp[l3++] = a.get(l1++);
		while(l2 <= last)
			temp[l3++] = a.get(l2++);
		
		for(int i=first; i<=last; i++)
		{
			a.set(i, temp[i]);
		}
	}

}
