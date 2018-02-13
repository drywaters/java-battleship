package battleship.model;

import static battleship.model.BattleShipConstants.*;

public class Ship {
	int numberOfHits;
	int row;
	int col[];
	
	Ship (int row, int col) {
		numberOfHits = 0;
		this.row = row;
		this.col = new int[MAX_SHIP_SIZE];
		for (int i=0; i < MAX_SHIP_SIZE; i++) {
			this.col[i] = col++;
		}
	}
	
	public boolean containsLocation(int row, int col) {
		if (this.row == row) {
			for (int i = 0; i < MAX_SHIP_SIZE; i++) {
				if (this.col[i] == col) {
					numberOfHits++;
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isSunk() {
		return numberOfHits == MAX_SHIP_SIZE;
	}
}
