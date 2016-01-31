import java.io.*;
import java.util.*;

public class Players {
	
	//instance variables
	private List<Player> players;
	private int currentSize;
	
	//constructor to initialize a Players object
	public Players()
	{
		players = new ArrayList<Player>(); //create a new list
		currentSize = 0;
		try{
			//open text file to read player information
			FileReader reader = new FileReader("players.txt");
			Scanner scanner = new Scanner(reader);
			while(scanner.hasNextLine()) //while there is still a line of text to be read
			{
				String line = scanner.nextLine();
				add(line); //add the player to the list
			}
			reader.close(); 
			scanner.close();
		}
		catch (FileNotFoundException e){
			System.out.println("The specified file could not be found");
		}
		catch (IOException e){
			System.out.println("An I/O Exception has occured");
		}
	}
	
	/**
	 * @param p the player to be added
	 */
	public void add(String line)
	{
		Player p = new Player(line); //create a new player object from a line read from text file
		players.add(p);
		currentSize++;
	}
	
	/**
	 * @param p the player to be removed
	 */
	public void remove(String pName)
	{
		Player p = getPlayer(pName);
		if(p != null){
			players.remove(p);
			currentSize--;
		}
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
	 * method to change a player's high score
	 * @param pName is the name of the player
	 * @param score is the new score of the player
	 */
	public void setPlayerHighScore(String pName, int score){
		Player p = getPlayer(pName); //get the player with the name
		//if the player exists, set the score
		if(p != null)
			p.setHighScore(score);
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

	/**
	 * method to search the List and return a player object with the name provided
	 * @param pName is the name of the player to be searched for
	 * @return the player corresponding to that name
	 */
	public Player getPlayer(String pName){
		//search through list of players
		for(Player p: players){
			if(p.getSurname().equals(pName)) //if player is found, return player
				return p;
		}
		System.out.println("No player with that name exists");
		return null; //else return null indicating that the player was not found
	}
	
	/**
	 * method to return the players list
	 * @return
	 */
	public List<Player> getPlayers(){
		return players;
	}
	
	/**
	 * method to save to output file
	 * @param output is the string to be saved
	 */
	public void save(String output){
		try{
			//create an output text file and save the result of the above operations to it
			FileWriter writer = new FileWriter("output.txt");
			writer.write(output); 
			
			//close file
			writer.close();
		}
		catch(IOException e)
		{
			System.out.println("An I/O Exception occured while trying to operate on the file");
		}
	}
	
}
