package battleship.model;

import static battleship.model.BattleShipConstants.*;

public class PlayerData {
	
	private int shipsAfloat;
	private int shipsSunk;
	
	private int[][] selfGrid;
	private int[][] attackGrid;
	private Ship[] ships;
	
	private boolean attacked;

	public PlayerData() {
		selfGrid = new int[GRID_SIZE][GRID_SIZE];
		attackGrid = new int[GRID_SIZE][GRID_SIZE];
		ships = new Ship[MAX_SHIPS];
		shipsAfloat = 0;
		shipsSunk = 0;
	}
	
	public void setShipLocation(int row, int col) {
		if (shipsAfloat < MAX_SHIPS && outBoundary(row, col) && !isShipOverlap(row, col)) {
			for (int i = 0; i < MAX_SHIP_SIZE; i ++) {
				selfGrid[row][col+i] = SHIP;
			}
			ships[shipsAfloat] = new Ship(row, col);
			shipsAfloat++;
		}
	}

	public boolean outBoundary(int row, int col) {
		if(col < 0 || col > 7) {
			return false;
		} else {
			return true;
		}		
	}
	
	public boolean isShipThere(int row, int col) {
		if (selfGrid[row][col] == SHIP || selfGrid[row][col] == HIT) {
			return true;
		}
		return false;
	}
	
	public boolean isShipOverlap(int row, int col) {
		for(int i = 0; i < 3; i++) {
			if (selfGrid[row][col+i] == SHIP)  
				return true;
		}
		return false;
	}
	
	public int getSelfLocation(int row, int col) {
		return selfGrid[row][col];
	}

	public int getAttackLocation(int row, int col) {
		return attackGrid[row][col];
	}
	
	public void setAttackLocation(int row, int col) {
		attackGrid[row][col] = HIT;
	}
	
	public void setMissLocation(int row, int col) {
		attackGrid[row][col] = MISS;
	}

	public int getShipsAfloat() {
		return shipsAfloat;
	}

	public int getShipsSunk() {
		return shipsSunk;
	}

	public void setShipHit(int row, int col) {
		selfGrid[row][col] = HIT;
		for (Ship ship: ships) {
			if (ship.containsLocation(row, col)) {
				if (ship.isSunk()) {
					shipsAfloat--;
					shipsSunk++;
				}
			}
		}
	}
	
	public boolean hasAttacked() {
		return attacked;
	}

	public void setAttacked(boolean attacked) {
		this.attacked = attacked;
	}
}
