package labrinyth;

import javax.swing.*;

/**
 * Display of maze
 */
public class Display {

	//Variables to be initialized in the Constructor, representing elements of the Maze
	Map themap;
	player p;
	String screen;
	Minotaur moo = new Minotaur();
	
	/**
	 * Welcomes players to the game and gives them instructions on how to play
	 */
	public void welcome(){
		JOptionPane.showMessageDialog(null, "Welcome to the Labrinyth! Good luck escaping the maze!");
		JOptionPane.showMessageDialog(null, "Type N/E/S/W to move.\n" +
									"You are marked by the P character. The minotaur that must be avoided" +
									"\n is marked by the M character. The exit is E.");
	}
	
	/**
	 * Initializes the variables and starts the welcome message
	 */
	public Display(){
		//obj = new JOptionPane();
		themap = new Map();
		p = new player(themap);
		welcome();
	}
	
	/**
	 * Updates the maze's map with everyone's current position. Also checks for win/lose conditions
	 */
	public void update(){
		screen = ""; 	//String which map is being stored in
		for(int r = 0; r < themap.boundRow; r++){	//Traverses the rows; maze is an array
			for(int c = 0; c < themap.boundCol; c++){	//Traverses the columns
				if(r == p.getPlayerRow() && c == p.getPlayerCol()){	//Finds the player's position and marks it on the map
					screen += "P ";
					if(p.getPlayerRow()==2 && p.getPlayerCol()==9){	//Checks if the player has reached the end
						JOptionPane.showMessageDialog(null, "Congratulations! You won!");	//Contragulations message
						System.exit(0);	//Exits the program
					}
					else if(p.getPlayerRow()==moo.getMinoRow() && p.getPlayerCol()==moo.getMinoCol()){	//Checks if the player hit the Minotaur
						obj.showMessageDialog(null, "Unfortunately, the minotaru has caught you. You have lost.");	//State user lost
						obj.showMessageDialog(null, "May you have better luck next time.");
						System.exit(0);	//Exit program
					}
				}
				else if(r==moo.getMinoRow() && c==moo.getMinoCol()){	//Checks for the minotaur's position
					screen+="M ";	//Displays where the Minotaur is via M
				}
				else if(themap.atEnd(r, c)){	//Checks where the end is
					screen+="E";	//Marks it on the Map via E
				}
				else if(themap.canMove(r, c)){	//Checks if the player can move into this index
					screen += "   ";	//Marks with empty slot
				}
				else{	//Otherwise, the index is a "wall" that cannot be moved into
					screen += "X ";	//Marks it with an X
				}
			}
			screen += "\n";	//Breaks the map into rows
		}
	}

	/**
	 * Receives user input and moves both the player and minotaur
	 */
	public void userInput(){
		String direct = JOptionPane.showInputDialog(screen);	//Shows user the current map and receives their input for their next move
		p.move(direct);	//Moves the player in the direction they specified
		moo.move();	//Moves the minotaur
		
	}
}
