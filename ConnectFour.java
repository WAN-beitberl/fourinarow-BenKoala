package ConnectObj;
import java.util.*;
class ConnectFour extends Game{
	static Scanner reader = new Scanner(System.in);
	
	// Declare Properties.
	private int[] tops;
	
	// Constructor.
	public ConnectFour(String p1, String p2){
		super(2);
		this.players[0] = new Player(p1);
		this.players[1] = new Player(p2);
		this.board = new ConnectFourBoard();
		this.tops = new int[this.board.getBoard()[0].length];
		for(int i = 0; i < this.board.getBoard()[0].length; i++){
			this.tops[i] = 0;
		}
	}
	
	// Print Players, Board, Clock.
	public void printBoard(){
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println(this.players[0].getName() + " VS. " + this.players[1].getName() + "\t\t Turn No. "+this.clock);
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("-----------------------------------");
		for(int i = this.board.length - 1; i >= 0 ; i--){
			for(int j = 0; j < this.board.getBoard()[0].length; j++){
				System.out.print("|["+this.board.getBoard()[i][j].getType()+"]|");
			}
			System.out.println("\n-----------------------------------");
		}
	}
	
	// Insert Piece into column.
	public int insert(){
		int index = 0;
		do{
			System.out.print(this.players[this.clock % 2].getName() + ", Enter a Column.\n====>");
			index = reader.nextInt();
			if (index < 0 || index > 6 || this.tops[index] == 6){
				System.out.println("Invalid Input...");
			}
		}while(index < 0 || index > 6 || this.tops[index] == 6);
		this.board.getBoard()[this.tops[index]][index].setType((char)('A' + (this.clock % 2)));
		this.tops[index]++;
		return index;
	}
	
	// Check if game ended.
	public boolean CheckForWin(int RecentInd){
		// Declare Variables.
		boolean Down = false, Left = false, Right = false, Diags = false;
		int occupied = 0;
		for(int i = 0; i < this.board.getBoard()[0].length; i++){
			occupied += this.tops[i];
		}
		if (occupied == 7*6){
			System.out.println("It's A Tie!");
			return true;
		}
		
		// Check 7 directions (Up irrelevant).
		Down = CheckDown(RecentInd);
		Left = CheckLeft(RecentInd);
		Right = CheckRight(RecentInd);
		Diags = CheckDiags(RecentInd);
		if(Down||Left||Right||Diags){
			System.out.println(this.players[(this.clock - 1) % 2].getName() + " Won!");
		}
		return (Down||Left||Right||Diags);
	}
	
	public boolean CheckDown(int RecentInd){
		if(this.tops[RecentInd] < 4){
			return false;
		}
		for(int i = 1; i < 4; i++){
			if(this.board.getBoard()[this.tops[RecentInd] - 1][RecentInd].getType() != 
			this.board.getBoard()[this.tops[RecentInd]- i - 1][RecentInd].getType()){
				return false;
			}
		}
		return true;
	}
	
	public boolean CheckLeft(int RecentInd){
		if(RecentInd < 3){
			return false;
		}
		for(int i = 1; i < 4; i++){
			if(this.board.getBoard()[this.tops[RecentInd] - 1][RecentInd].getType() != 
			this.board.getBoard()[this.tops[RecentInd] - 1][RecentInd-i].getType()){
				return false;
			}
		}
		return true;
	}
	
	public boolean CheckRight(int RecentInd){
		if(RecentInd > 4){
			return false;
		}
		for(int i = 1; i < 4; i++){
			if(this.board.getBoard()[this.tops[RecentInd] - 1][RecentInd].getType() != 
			this.board.getBoard()[this.tops[RecentInd] - 1][RecentInd+i].getType()){
				return false;
			}
		}
		return true;
	}
	
	public boolean CheckDiags(int RecentInd){
		boolean flag1 = true, flag2 = true, flag3 = true, flag4 = true;
		for(int i = 1; i < 4; i++){
			if(flag1 && RecentInd > 2 && this.tops[RecentInd] > 3)
				flag1 = (this.board.getBoard()[this.tops[RecentInd] - 1][RecentInd].getType() == 
			this.board.getBoard()[this.tops[RecentInd] - 1 - i][RecentInd - i].getType());
			if(flag2 && RecentInd > 3 && this.tops[RecentInd] < 3)
				flag2 = (this.board.getBoard()[this.tops[RecentInd] - 1][RecentInd].getType() == 
			this.board.getBoard()[this.tops[RecentInd] - 1 + i][RecentInd - i].getType());
			if(flag3 && RecentInd < 4  && this.tops[RecentInd] > 3)
				flag3 = (this.board.getBoard()[this.tops[RecentInd] - 1][RecentInd].getType() == 
			this.board.getBoard()[this.tops[RecentInd] - 1 - i][RecentInd + i].getType());
			if(flag4 && RecentInd < 4 && this.tops[RecentInd] < 3)
				flag4 = (this.board.getBoard()[this.tops[RecentInd] - 1][RecentInd].getType() == 
			this.board.getBoard()[this.tops[RecentInd] - 1 + i][RecentInd + i].getType());
		}
		return ((flag1 && RecentInd > 2 && this.tops[RecentInd] > 3)||
		(flag2 && RecentInd > 3 && this.tops[RecentInd] < 3)||
		(flag3 && RecentInd < 4 && this.tops[RecentInd] > 3)||
		(flag4 && RecentInd < 4 && this.tops[RecentInd] < 3));
	}
}
