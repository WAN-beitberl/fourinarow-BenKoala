package ConnectObj;
abstract class Board{
	
	// Declare Properties.
	protected int length;
	protected int width;
	protected Token[][] board;
	
	// Constructor.
	public Board(int length, int width){
		this.length = length;
		this.width = width;
		this.board = new Token[this.length][this.width];
	}
	
	// Get the chess board.
	abstract public Token[][] getBoard();
}
	
	