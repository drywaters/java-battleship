package battleship.states;

import battleship.BattleShip;
import battleship.controller.BattleShipController;
import battleship.model.PlayerData;
import battleship.view.PlayerScreen;

public class PlayerOneSetup implements BattleShipState {

	private BattleShip battleShip;
	private PlayerScreen screen;
	private PlayerData playerOneData;
	private PlayerData playerTwoData;
	private BattleShipController controller;
	
	public PlayerOneSetup(BattleShip battleShip) {
		this.battleShip = battleShip;
		this.screen = battleShip.getScreen();
		this.playerOneData = battleShip.getPlayerOneData();
		this.playerTwoData = battleShip.getPlayerTwoData();
		this.controller = battleShip.getController();
		screen.attachListeners(controller.playerOneSetupListener());
		screen.setTitle(this.toString());
		updateGrid();
	}
	
	@Override
	public void updateGrid() {
		screen.updateGrid(playerOneData, playerTwoData, this);
	}
	
	@Override
	public BattleShipState nextState() {
		return new PlayerTwoSetup(battleShip);
	}	
	
	@Override
	public String toString() {
		return "Player One Setup";
	}
}
