package boardPackage;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class Board extends JButton {
	
	Color darkTile = new Color(0,0,0);
	Color lightTile = new Color(250,250,250);
	Color themeColor = new Color(230,230,230);
	
	public Board() {
		super.setBorderPainted(false);
		super.setFocusPainted(false);
		super.setContentAreaFilled(false);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		int width = getWidth();
		int height = getHeight();
		int limiter = 0;
		int borderThickness = 10;
		if(width<height) {
			limiter = width;
		}
		else {
			limiter = height;
		}
		int fieldSize = (limiter-2*borderThickness)/8;
		
		//System.out.println(fieldSize);
		g.setColor(darkTile);
		g.fillRect(borderThickness, borderThickness, fieldSize*8,
				fieldSize*8);
		
		g.setColor(lightTile);
		for(int y = 0; y < 8; y++ ) {
			for(int x = 0;x < 8; x++) {
				if( (x+y)%2 == 0 ) {
					g.fillRect( fieldSize * x + borderThickness,
							fieldSize * y + borderThickness, fieldSize, fieldSize);
				}
			}
		}
		
		CheckersPositions cPositions = new CheckersPositions();
		for(int y = 0; y < 8; y++ ) {
			int yOffset = y*fieldSize + borderThickness;
			
			for(int x = 0;x < 8; x++) {
				int xOffset = x*fieldSize + borderThickness;
				
				if (cPositions.tile[x][y] == Checker.WCHECKER.value) {
					g.setColor(Color.LIGHT_GRAY);
					g.fillOval(xOffset ,  yOffset, fieldSize, fieldSize);
					g.setColor(Color.DARK_GRAY);
					g.drawOval(xOffset,  yOffset, fieldSize, fieldSize);
					g.setColor(Color.WHITE);
					g.fillOval(xOffset-2 ,  yOffset-3, fieldSize, fieldSize);
					g.setColor(Color.DARK_GRAY);
					g.drawOval(xOffset-2 ,  yOffset-3, fieldSize, fieldSize);
					g.setColor(Color.LIGHT_GRAY);
					g.drawOval(xOffset-2+10 ,  yOffset-3+10, fieldSize-20, fieldSize-20);
				}
				
				if (cPositions.tile[x][y] == Checker.BCHECKER.value) {
					g.setColor(Color.DARK_GRAY);
					g.fillOval(xOffset,  yOffset, fieldSize, fieldSize);
					g.setColor(Color.LIGHT_GRAY);
					g.drawOval(xOffset ,  yOffset, fieldSize, fieldSize);
					g.setColor(Color.BLACK);
					g.fillOval(xOffset-2 ,  yOffset-3, fieldSize, fieldSize);
					g.setColor(Color.LIGHT_GRAY);
					g.drawOval(xOffset-2 ,  yOffset-3, fieldSize, fieldSize);
					g.setColor(Color.DARK_GRAY);
					g.drawOval(xOffset-2+10 ,  yOffset-3+10, fieldSize-20, fieldSize-20);
				}
				
			}
		}
		
	}
}
