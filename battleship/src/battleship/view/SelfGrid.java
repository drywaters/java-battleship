package battleship.view;

import battleship.model.PlayerData;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import static battleship.model.BattleShipConstants.*;

public class SelfGrid extends JPanel {
	
	private GridButton[][] buttons;
	
    public SelfGrid() {
    	this.setLayout(new GridLayout(10,10));
    	this.setBackground(Color.white);
    	buttons = new GridButton[10][10];
        for (int row = 0; row < GRID_SIZE; row++) {
        	for (int col = 0; col < GRID_SIZE; col++) {
        		buttons[row][col] = new GridButton(row, col);
        		buttons[row][col].setEnabled(false);
        		this.add(buttons[row][col]); 
        	}
        }
    }
    
    public void updateGrid(PlayerData playerData) {
    	for (int row = 0; row < GRID_SIZE; row++) {
    		for (int col = 0; col < GRID_SIZE; col++) {
    			buttons[row][col].type = playerData.getSelfLocation(row, col);
    		}
    	}
    }
}