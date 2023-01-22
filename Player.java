package ConnectObj;
class Player{
	
	// Declare Properties.
	private static int count = 0;
	private int id;
	private int wins;
	private String name;
	
	// Constructor.
	public Player(String name){
		this.id = count++;
		this.name = name;
		this.wins = 0;
	}
	
	// Get player name.
	public String getName(){
		return this.name;
	}
}