package battleship.view;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import battleship.model.PlayerData;

import static battleship.model.BattleShipConstants.*;

public class InformationGrid extends JPanel {
	
	JLabel currentShipsLbl;
	JLabel currentShipsSunkLbl;
	JLabel enemyShipsLbl;
	JLabel enemyShipsSunkLbl;
	JLabel currentStateTextLbl;
	JLabel numberShipsAfloatLbl;
	JLabel numberShipsSunkLbl;
	JLabel numberEnemyShipsAfloatLbl;
	JLabel numberEnemyShipsSunkLbl;
	JLabel currentStateLbl;
	
	int shipsAfloat;
	int shipsSunk;
	int enemyShipsAfloat;
	int enemyShipsSunk;
	String currentState;
		
	public InformationGrid() {
		this.setLayout(new GridLayout(5,2));		
		currentShipsLbl = new JLabel(MY_SHIPS_AVAILABLE);
		numberShipsAfloatLbl = new JLabel(""+shipsAfloat);
		currentShipsSunkLbl = new JLabel(MY_SHIPS_SANK);
		numberShipsSunkLbl = new JLabel(""+shipsSunk);
		enemyShipsLbl = new JLabel(ENEMY_SHIPS_AVAILABLE);
		numberEnemyShipsAfloatLbl = new JLabel(""+enemyShipsAfloat);
		enemyShipsSunkLbl = new JLabel(ENEMY_SHIPS_SUNK);
		numberEnemyShipsSunkLbl = new JLabel(""+enemyShipsSunk);
		currentStateTextLbl = new JLabel(CURRENT_STATE);	
		currentStateLbl = new JLabel(currentState);
		
		add(currentShipsLbl);
		add(numberShipsAfloatLbl);
		add(currentShipsSunkLbl);
		add(numberShipsSunkLbl);
		add(enemyShipsLbl);
		add(numberEnemyShipsAfloatLbl);
		add(enemyShipsSunkLbl);
		add(numberEnemyShipsSunkLbl);
		add(currentStateTextLbl);
		add(currentStateLbl);
	}
	
	public void updateGrid(PlayerData currentPlayer, PlayerData otherPlayer, String stateString) {
		shipsAfloat = currentPlayer.getShipsAfloat();
		shipsSunk = currentPlayer.getShipsSunk();
		enemyShipsAfloat = otherPlayer.getShipsAfloat();
		enemyShipsSunk = otherPlayer.getShipsSunk();
		numberShipsAfloatLbl.setText(""+ shipsAfloat);
		numberShipsSunkLbl.setText(""+ shipsSunk);
		numberEnemyShipsAfloatLbl.setText(""+ enemyShipsAfloat);
		numberEnemyShipsSunkLbl.setText(""+ enemyShipsSunk);
		currentStateLbl.setText(stateString);
	}
}
