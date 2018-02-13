package battleship.view;

import battleship.model.PlayerData;
import battleship.states.BattleShipState;
import battleship.states.PlayerOneSetup;
import battleship.states.PlayerTwoSetup;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import static battleship.model.BattleShipConstants.*;

public class AttackGrid extends JPanel {
	
	private GridButton[][] buttons;
	
    public AttackGrid() {
    	this.setLayout(new GridLayout(10,10));
    	this.setBackground(Color.white);
    	buttons = new GridButton[10][10];
        for (int row = 0; row < GRID_SIZE; row++) {
        	for (int col = 0; col < GRID_SIZE; col++) {
        		buttons[row][col] = new GridButton(row, col);
        		this.add(buttons[row][col]);
        	}
        }
    }
    
    public void updateGrid(PlayerData playerData, BattleShipState currentState) {
    	for (int row = 0; row < GRID_SIZE; row++) {
    		for (int col = 0; col < GRID_SIZE; col++) {
    			if (currentState instanceof PlayerOneSetup || currentState instanceof PlayerTwoSetup) {
    				buttons[row][col].type = playerData.getSelfLocation(row, col);
    			} else {
    				buttons[row][col].type = playerData.getAttackLocation(row, col);	
    			}		
    		}
    	}
    }
    
    public void attachListeners(ActionListener listener) {
    	for (int row = 0; row < GRID_SIZE; row++) {
    		for (int col = 0; col < GRID_SIZE; col++) {
    			buttons[row][col].addActionListener(listener);
    		}
    	}
    }
    
    public void removeListeners() {
    	for (int row = 0; row < GRID_SIZE; row++) {
    		for (int col = 0; col < GRID_SIZE; col++) {
    			GridButton currentButton = buttons[row][col];
    			for (ActionListener actionListener : currentButton.getActionListeners()) {
    				currentButton.removeActionListener(actionListener);
    			}
    		}
    	}
    }
}