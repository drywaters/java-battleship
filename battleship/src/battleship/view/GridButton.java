package battleship.view;

import java.awt.Color;
import static battleship.model.BattleShipConstants.*;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class GridButton extends JButton {
	
	int row;
	int col;
	int type;
	
	public GridButton(int row, int col) {
		this.row = row;
		this.col = col;
		this.setPreferredSize(new Dimension(50, 50));
        this.setBackground(Color.white);
        this.setOpaque(true);
    	this.setBorder(BorderFactory.createLineBorder(Color.red, 5));
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		switch(type) {
		case EMPTY:
			this.setBackground(Color.white);
			break;
		case SHIP: 
			this.setBackground(Color.green);
			break;
		case HIT:
			this.setBackground(Color.red);
			break;
		case MISS:
			this.setBackground(Color.yellow);
			break;
		}
	}
}
