package labrinyth;

/**
 * Map of the maze
 */
public class Map {

	boolean[][] map;	//Creates the 2D array representing the map
	int boundRow = 10, boundCol = 10, startRow, startCol, //Declares variables storing the start, end, minotaur's position, and the borders.
			endRow, endCol,minoStart,minoEnd;
	
	/**
	 * Constructs the map, setting important locations and the paths throughout the maze.
	 */
	public Map(){
		map = new boolean[10][10];	//Initializes the map and its size
		startRow = 6; startCol = 0;	//Sets the start position
		endRow = 2; endCol = 9;		//Sets the exit position
		for(int r = 0; r < map.length; r++){	//Sets the entire maze to true
			for(int c = 0; c < map[0].length; c++){
				map[r][c] = true;
			}
		}
		
		//Manually sets all the indexes which players cannot move to to false.
		for(int r = 0;r<map.length;r++){
			if(r!=2 && r!=startRow){
				map[r][0] = false;
			}
		}
		
		map[0][1]=false;
		map[1][1]=false;
		map[3][1]=false;
		map[9][1]=false;
		
		for(int r=5;r<=7;r++){
			map[r][2]=false;
		}
		map[9][2]=false;
		
		for(int r= 0; r<map.length; r++){
			if(r!=2 && r!=8 && r!=5){
				map[r][3] = false;
			}
		}
		map[0][4]=false;
		map[6][4]=false;
		
		for(int r=2; r<=4;r++){
			map[r][5]=false;
		}
		map[6][5]=false;
		map[8][5]=false;
		
		for(int c=6;c<=9;c++){
			map[0][c]=false;
		}
		
		for(int c=6;c<map.length;c++){
			map[8][c]=false;
		}
		
		map[7][9]=false;
		
		for(int r = 1; r<7;r++){
			if(r!=3 && r!= 4 && r!=5){
				map[r][6]=false;
			}
		}
		
		for(int r = 4; r<7; r++){
			map[r][7]=false;
			
		}
		
		for(int r =2; r<6; r++){
			map[r][8]=false;
		}
		//Finishes setting up the map
	}
	
	/**
	 * Checks if a unit can move into an index
	 * @param r	row of the index
	 * @param c	column of the index
	 * @return	true if move is valid
	 */
	public boolean canMove(int r, int c){
		if(r > boundRow || r < 0 || c > boundCol || c <0){	//Checks if the move is out of bounds
			return false;
		}
		return map[r][c];	//Checks the array of booleans to see if the move is valid
	}
	
	// public int[] startPosition(){
	// 	int[] x = {startRow, startCol};
	// 	return x;
	// }

	/**
	 * Checks if the player is at the end
	 * @param r player's row
	 * @param c	player's column
	 * @return	true if the player is at the end
	 */
	public boolean atEnd(int r, int c){
		return r == endRow && c == endCol; //Returns if the player is at the maze's exit
	}
	
}
