package labrinyth;

/**
 * Class depicting player actions
 */
public class player {
	
	int playerRow, playerCol; //Position of the player unit
	Map obj2;	//Map to interact with
	
	/**
	 * Sets the player's starting position 
	 * @param obj Map obj to interact with
	 */
	public player(Map obj){
		playerRow = obj.startRow;
		playerCol = obj.startCol;
		obj2 = obj;
	}
	
	//Gets the player's position
	public int getPlayerRow(){ return playerRow; }
	public int getPlayerCol(){ return playerCol; }
	
	/**
	 * Moves the player in the direction specified
	 * @param s N/E/S/W representing direction the user wants to move
	 */
	public void move(String s){
		//Checks what the user inputted and moves them as commanded if the move is valid.
		if(s.equalsIgnoreCase("N")){
			if(obj2.canMove(getPlayerRow()-1, getPlayerCol())==true){
				layerRow = getPlayerRow() -1;
			}
		}
		if(s.equalsIgnoreCase("E")){
			if(obj2.canMove(getPlayerRow(), getPlayerCol()+1)==true)
				playerCol = getPlayerCol()+1;
			}
		if(s.equalsIgnoreCase("S")){
			if(obj2.canMove(getPlayerRow()+1,getPlayerCol())==true){ 
				playerRow = getPlayerRow() +1;
			}
		}
		if(s.equalsIgnoreCase("W")){
			if(obj2.canMove(getPlayerRow(), getPlayerCol()-1)==true){
				playerCol = getPlayerCol()-1;
			}
		}
	}
}


