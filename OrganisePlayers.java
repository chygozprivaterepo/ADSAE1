import java.io.*;
import java.util.*;

public class OrganisePlayers {

	public static void main(String[] args) {
		Players players = new Players();	
		String output = "";
		output += String.format("The list of players is:%n%s", players);  //get the list of players
		output += String.format("%nThe high score is: %d%n", players.getHighScore()); //get the high score
		
		//Manipulating entries
		output += String.format("%n%s%n%n","Manipulating entries");
		
		//add a player to the list
		output += String.format("%s%n","Adding a male player named \"Ekwonu\" with a high-score of 80 to the list");
		players.add("Ekwonu (M) 80");
		output += String.format("The new high score is: %d%n%n", players.getHighScore()); //get the high score
		
		//change a player's high score
		output += String.format("%s%n","Changing Ekwonu's high score to 78");
		players.setPlayerHighScore("Ekwonu", 78);
		output += String.format("The new high score is: %d%n%n", players.getHighScore()); //get the high score
		
		//remove a player from the list
		output += String.format("%s%n","Removing a player named \"Berry\" from the list");
		players.remove("Berry");
		output += String.format("The new high score is: %d%n%n", players.getHighScore()); //get the high score
		
		//re-order list in increasing order of surname
		players.sortBySurname(); 
		output += String.format("%nThe (name)-sorted list is:%n%s", players);
		
		//re-order list in descending order of high score
		players.sortByHighScore(); 
		output += String.format("%nThe (high-score)-sorted list is:%n%s", players);
		
		//save the result of the above operations to an output file
		players.save(output);
	}
}
