package battleship.states;

import javax.swing.JOptionPane;

import battleship.BattleShip;

import static battleship.model.BattleShipConstants.*;

public class GameOver implements BattleShipState {

	private String winner = null;
	
	public GameOver(BattleShip battleShip) {

		battleShip.getScreen().disableNext();
		
		if(battleShip.getPlayerOneData().getShipsSunk() == MAX_SHIPS)
			winner = "Player Two wins!";
		else
			winner = "Player One wins!";
		
		JOptionPane.showMessageDialog(battleShip.getScreen(), winner, "Congratulations!", JOptionPane.PLAIN_MESSAGE);

	}
	
	@Override
	public BattleShipState nextState() {
		// No state after game is over
		return null;
	}

	@Override
	public void updateGrid() {
		// No need to keep updating, game is over
		
	}
	
	@Override
	public String toString() {
		return "Game Over: " + winner;
	}


}
