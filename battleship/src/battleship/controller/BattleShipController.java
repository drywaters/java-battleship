package battleship.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import battleship.BattleShip;
import battleship.model.PlayerData;
import battleship.states.GameOver;

import battleship.view.GridButton;
import static battleship.model.BattleShipConstants.*;

public class BattleShipController {

	private BattleShip battleShip;
	private PlayerData playerOneData;
	private PlayerData playerTwoData;
	
	public BattleShipController(BattleShip battleShip) {
		this.battleShip = battleShip;
		playerOneData = battleShip.getPlayerOneData();
		playerTwoData = battleShip.getPlayerTwoData();
	}
	
	public ActionListener changeState() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				battleShip.setCurrentState(battleShip.getCurrentState().nextState());
			}
		};
	}

	public ActionListener playerOneSetupListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GridButton button = (GridButton) e.getSource();
				playerOneData.setShipLocation(button.getRow(), button.getCol());
				battleShip.getScreen().updateGrid(playerOneData, playerTwoData, battleShip.getCurrentState());
			}
		};
	}
	
	public ActionListener playerTwoSetupListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GridButton button = (GridButton) e.getSource();
				playerTwoData.setShipLocation(button.getRow(), button.getCol());
				battleShip.getScreen().updateGrid(playerTwoData, playerOneData, battleShip.getCurrentState());
			}
		};
	}
	
	public ActionListener playerOneAttackListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GridButton button = (GridButton) e.getSource();
				int row = button.getRow();
				int col = button.getCol();
				if (!playerOneData.hasAttacked() && playerOneData.getAttackLocation(row, col) == EMPTY) {
					playerOneData.setAttacked(true);
					boolean isHit = playerTwoData.isShipThere(row, col);
					if (isHit) {
						playerTwoData.setShipHit(row, col);
						playerOneData.setAttackLocation(row, col);

						if (playerTwoData.getShipsSunk()==MAX_SHIPS) {
							battleShip.getScreen().updateGrid(playerOneData, playerTwoData, battleShip.getCurrentState());
							battleShip.setCurrentState(new GameOver(battleShip));
						}

					} else {
						playerOneData.setMissLocation(row, col);
					}
					battleShip.getScreen().updateGrid(playerOneData, playerTwoData, battleShip.getCurrentState());	
				}
			}
		};
	}
	
	public ActionListener playerTwoAttackListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GridButton button = (GridButton) e.getSource();
				int row = button.getRow();
				int col = button.getCol();
				if (!playerTwoData.hasAttacked()  && playerTwoData.getAttackLocation(row, col) == EMPTY) {
					playerTwoData.setAttacked(true);
					boolean isHit = playerOneData.isShipThere(row, col);
					if (isHit) {
						playerOneData.setShipHit(row, col);
						playerTwoData.setAttackLocation(row, col);
						if(playerOneData.getShipsSunk() == MAX_SHIPS) {
							battleShip.getScreen().updateGrid(playerTwoData, playerOneData, battleShip.getCurrentState());
							battleShip.setCurrentState(new GameOver(battleShip));
						}
					} else {
						playerTwoData.setMissLocation(row, col);
					}
					battleShip.getScreen().updateGrid(playerTwoData, playerOneData, battleShip.getCurrentState());	
				}
			}
		};
	}	
}
