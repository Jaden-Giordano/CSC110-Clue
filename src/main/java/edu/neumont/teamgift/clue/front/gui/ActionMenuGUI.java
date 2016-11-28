package edu.neumont.teamgift.clue.front.gui;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class ActionMenuGUI extends JFrame {
	
	public ActionMenuGUI() {
		buildActionMenu();
	}
	
	private void buildActionMenu() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1440, 2200);
		this.setVisible(true);
	}
}
