import java.io.*;
import java.util.*;

public class OrganisePlayers {

	public static void main(String[] args) {
		
		try
		{
			//open text file to read player information
			FileReader reader = new FileReader("players.txt");
			Scanner scanner = new Scanner(reader);
			while(scanner.hasNext())
			{
				String line = scanner.nextLine();
				Player player = new Player(line);
				System.out.println(player);
			}
			
			//close file
			reader.close();
			scanner.close();
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
