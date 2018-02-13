package battleship.model;

public class BattleShipConstants {
	
	public static final String MY_SHIPS_AVAILABLE = "Number of my ships afloat: ";
	public static final String MY_SHIPS_SANK = "Number of my ships sunk: ";
	public static final String ENEMY_SHIPS_AVAILABLE = "Number of enemy ships afloat: ";
	public static final String ENEMY_SHIPS_SUNK = "Number of enemy ships sunk: ";
	public static final String CURRENT_STATE = "Current state is: ";
	
	public static final int GRID_SIZE = 10;
	public static final int MAX_SHIPS = 5;
	public static final int MAX_SHIP_SIZE = 3;
	
	public static final int EMPTY = 0;
	public static final int SHIP = 1;
	public static final int HIT = 2;
	public static final int MISS = 3;
	
	private BattleShipConstants() {	}

}
