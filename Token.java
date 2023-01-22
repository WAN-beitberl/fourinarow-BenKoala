package ConnectObj;
abstract class Token{
	
	// Declare Properties.
	protected char type;
	
	// Constructor.
	public Token(char type){
		this.type = type;
	}
	
	// Getters.
	public char getType(){
		return this.type;
	}
	
	// Setters.
	public void setType(char type){
		this.type = type;
	}
}
	
	