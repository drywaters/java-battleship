package battleship.states;

import battleship.BattleShip;
import battleship.controller.BattleShipController;
import battleship.model.PlayerData;
import battleship.view.PlayerScreen;

public class PlayerOneAttack implements BattleShipState {
	
	private BattleShip battleShip;
	private PlayerScreen screen;
	private PlayerData playerOneData;
	private PlayerData playerTwoData;
	private BattleShipController controller;
	
	public PlayerOneAttack(BattleShip battleShip) {
		this.battleShip = battleShip;
		this.screen = battleShip.getScreen();
		this.playerOneData = battleShip.getPlayerOneData();
		this.playerTwoData = battleShip.getPlayerTwoData();
		this.controller = battleShip.getController();
		playerOneData.setAttacked(false);
		screen.removeListeners();
		screen.attachListeners(controller.playerOneAttackListener());
		screen.setTitle(this.toString());
		updateGrid();
	}
	
	@Override
	public void updateGrid() {
		screen.updateGrid(playerOneData, playerTwoData, this);
	}
	
	@Override
	public BattleShipState nextState() {
		return new PlayerTwoAttack(battleShip);
	}	
	
	@Override
	public String toString() {
		return "Player One Attack";
	}
}
