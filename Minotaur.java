package labrinyth;

import java.util.Random;

/**
 * Minotaur AI
 */
public class Minotaur {

	int minoRow, minoCol;	//Initial position of the minotaur
	Random minoAI = new Random();	//Random to randomize minotaur's move
	Map minoMap = new Map();	//Map for minotaur to interact with
	
	/**
	 * Sets the minotaur's starting position
	 */
	public Minotaur(){
		minoRow = 7;	//Sets minotaur's starting row
		minoCol = 7;	//Sets minotaur's starting column
	}
	
	//Gets the minotaur's position (row/column) respectively
	public int getMinoRow(){return minoRow;}
	public int getMinoCol(){return minoCol;}
	
	/**
	 * Moves the minotaur
	 */
	public void move(){
		int m = minoAI.nextInt(4-1 + 1) + 1; 	//Randomizes a number
		boolean moved = false;

		//Based on the random number, moves the minotaur a specified direction if valid
		//If the direction is invalid, tries another direction until there is a valid direction.
		while(!moved){
			if(m==1){
				if(minoMap.canMove(getMinoRow()-1, getMinoCol())){
					minoRow = getMinoRow()-1;
					moved = true;
				}
				else{
					m=2;
				}
			}
			if(m==2){
				if(minoMap.canMove(getMinoRow(), getMinoCol()+1)){
					minoCol = getMinoCol() +1;
					moved = true;
				}
				else{
					m=3;
				}
				
			}
			if(m==3){
				if(minoMap.canMove(getMinoRow()+1, getMinoCol())){
					minoRow = getMinoRow()+1;
					moved = true;
				}
				else{
					m=4;
				}
				
			}
			if(m==4){
				if(minoMap.canMove(getMinoRow(), getMinoCol()-1)){
					minoCol = getMinoCol()-1;
					moved = true;
				}
				else{
					m=1;
				}
				
			}
		}
	}
	
}
