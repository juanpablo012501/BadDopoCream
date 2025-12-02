package domain;

/**
 * The interface that defines the main actions that all placeables instances do in order to move in the game
 * @author PAD
 * @author JPV
 */
public interface Movable{
	
	/**
	 * Determines the next move inside of the level
	 */
	void determineMove();

	/**
	 * Make the move determined in the determineMove method
	 * @param direction
	 */
	default void move(char direction){
		
	}
}
