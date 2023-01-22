package ConnectObj;
class ConnectFourBoard extends Board{
	// Constructor.
	public ConnectFourBoard(){
		super(6, 7);
		for(int i = 0; i < this.board.length; i++){
			for(int j = 0; j < this.board[0].length; j++){
				this.board[i][j] = new ConnectPiece(' ');
			}
		}
	}	
	
	// Get the chess board.
	public Token[][] getBoard(){
		return this.board;
	}
}
	