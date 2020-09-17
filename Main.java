package labrinyth;

/**
 * Main class to activate the game
 */
public class Main {
	public static void main(String[] args) {
		Display game = new Display();  //Creates new game
		boolean gameStart = true;	   //boolean to continue game until objectives are met
		while(gameStart){              //Infinite loop to continue game
			game.update();			   //Updates the game map with current positions
			game.userInput();		   //Takes user input for their next move
		}

	}

}
