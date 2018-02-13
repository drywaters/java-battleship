package battleship.states;

import battleship.BattleShip;
import battleship.controller.BattleShipController;
import battleship.model.PlayerData;
import battleship.view.PlayerScreen;

public class PlayerTwoSetup implements BattleShipState {

	private BattleShip battleShip;
	private PlayerScreen screen;
	private PlayerData playerOneData;
	private PlayerData playerTwoData;
	private BattleShipController controller;
	
	public PlayerTwoSetup(BattleShip battleShip) {
		this.battleShip = battleShip;
		this.screen = battleShip.getScreen();
		this.playerOneData = battleShip.getPlayerOneData();
		this.playerTwoData = battleShip.getPlayerTwoData();
		this.controller = battleShip.getController();
		screen.removeListeners();
		screen.attachListeners(controller.playerTwoSetupListener());
		screen.setTitle(this.toString());
		updateGrid();
	}
	
	@Override
	public void updateGrid() {
		screen.updateGrid(playerTwoData, playerOneData, this);
	}
	
	@Override
	public BattleShipState nextState() {
		return new PlayerOneAttack(battleShip);
	}	
	
	@Override
	public String toString() {
		return "Player Two Setup";
	}
}
