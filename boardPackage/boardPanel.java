package boardPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class boardPanel extends JPanel {

	public boardPanel() {
		this.setLayout(new BorderLayout());
		
		Board board = new Board();
		this.add(board, BorderLayout.CENTER);
	}
}
