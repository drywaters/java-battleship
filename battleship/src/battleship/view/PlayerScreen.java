package battleship.view;
import javax.swing.*;

import battleship.controller.BattleShipController;
import battleship.model.PlayerData;
import battleship.states.BattleShipState;

import java.awt.*;
import java.awt.event.ActionListener;

public class PlayerScreen extends JFrame {
	
	private SelfGrid selfGrid;
	private AttackGrid attackGrid;
	private InformationGrid informationGrid;
	private JButton nextButton;
	
    public PlayerScreen(BattleShipController controller) {
        this.setLayout(new BorderLayout());
        
        selfGrid = new SelfGrid();
        attackGrid = new AttackGrid();
        informationGrid = new InformationGrid();
        
        this.add(selfGrid, BorderLayout.EAST);
        this.add(attackGrid, BorderLayout.WEST);
        this.add(informationGrid, BorderLayout.SOUTH);

        nextButton = new JButton("Next");   
        nextButton.addActionListener(controller.changeState());
        
        this.add(nextButton, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void attachListeners(ActionListener listener) {
    	attackGrid.attachListeners(listener);
    }
    
    public void removeListeners() {
    	attackGrid.removeListeners();
    }
    
    public void updateGrid(PlayerData currentPlayer, PlayerData otherPlayer, BattleShipState currentState) {
    	selfGrid.updateGrid(currentPlayer);
    	attackGrid.updateGrid(currentPlayer, currentState);
    	informationGrid.updateGrid(currentPlayer, otherPlayer, currentState.toString());
    	this.validate();
    	this.repaint();
    }
    
    public void disableNext() {
    	nextButton.setEnabled(false);
    }
    
}