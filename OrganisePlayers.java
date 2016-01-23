import java.io.*;
import java.util.*;

public class OrganisePlayers {

	public static void main(String[] args) {
		Players players = new Players();
		try
		{
			//open text file to read player information
			FileReader reader = new FileReader("players.txt");
			Scanner scanner = new Scanner(reader);
			while(scanner.hasNext())
			{
				String line = scanner.nextLine();
				Player player = new Player(line);
				players.add(player);
			}
			
			String output = "";
			output += String.format("The list of players is:%n%s", players);
			output += String.format("%nThe high score is: %d%n", players.getHighScore());
			players.sortBySurname();
			output += String.format("%nThe (name)-sorted list is:%n%s", players);
			players.sortByHighScore();
			output += String.format("%nThe (high-score)-sorted list is:%n%s", players);
			System.out.print(output);
			
			FileWriter writer = new FileWriter("output.txt");
			writer.write(output);
			
			//close files
			reader.close();
			scanner.close();
			writer.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("The specified file could not be found");
		}
		catch(IOException e)
		{
			System.out.println("The specified file could not be opened");
		}
	}

}
