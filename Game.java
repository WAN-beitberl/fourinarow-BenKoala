package ConnectObj;
import ConnectObj.Board;
import ConnectObj.Player;
abstract class Game{
	
	// Declare Properties.
	protected int clock;
	protected Board board;
	protected Player[] players;
	
	// Constructor.
	public Game(int numOfPlayers){
		this.players = new Player[numOfPlayers];
		this.clock = 0;
	}
	
	// Print the games board.
	abstract public void printBoard();
	
	// Check if game is over.
	abstract public boolean CheckForWin(int Input);
	
	// Tick Clock.
	public void shift(){
		this.clock++;
	}
}