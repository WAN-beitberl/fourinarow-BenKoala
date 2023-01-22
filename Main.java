package ConnectObj;
import java.util.*;
class Main{
	static Scanner reader = new Scanner(System.in);
	public static void main(String args[]){
		// Declare Variables.
		String p1, p2;
		int RecentInd;
		
		// Get Players' Names.
		System.out.println("Enter Player 1 Name:");
		p1 = reader.next();
		System.out.println("Enter Player 2 Name:");
		p2 = reader.next();
		
		// Init game.
		ConnectFour game = new ConnectFour(p1, p2);
		
		// Game Loop.
		do{
			game.printBoard();
			// Push piece.
			RecentInd = game.insert();
			// Tick clock.
			game.shift();
			// Check game For End.
		}while(!game.CheckForWin(RecentInd));
		game.printBoard();
	}
}