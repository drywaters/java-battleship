package battleship;

import battleship.controller.BattleShipController;
import battleship.model.PlayerData;
import battleship.states.BattleShipState;
import battleship.states.PlayerOneSetup;
import battleship.view.PlayerScreen;

public class BattleShip {
	
	private BattleShipState currentState;
	private PlayerScreen mainScreen;
    private PlayerData playerOneData;
    private PlayerData playerTwoData;
    private BattleShipController controller;

	protected BattleShip() {
    	playerOneData = new PlayerData();
    	playerTwoData = new PlayerData();
    	controller = new BattleShipController(this);
    	mainScreen = new PlayerScreen(controller);
    	currentState = new PlayerOneSetup(this);
    }
    
    public BattleShipState getCurrentState() {
    	return currentState;
    }
    
    public void setCurrentState(BattleShipState newState) {
    	currentState = newState;
    }
    
    public PlayerScreen getScreen() {
    	return mainScreen;
    }
    
    public BattleShipController getController() {
    	return controller;
    }
    
    public PlayerData getPlayerOneData() {
		return playerOneData;
	}

	public PlayerData getPlayerTwoData() {
		return playerTwoData;
	}
}