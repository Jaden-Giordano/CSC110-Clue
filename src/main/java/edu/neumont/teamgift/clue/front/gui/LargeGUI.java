package edu.neumont.teamgift.clue.front.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LargeGUI extends JFrame{
	
	void createAwkwardlyLargeGUI(final int playerID){
    	LargeGUI gui = new LargeGUI();
    	gui.setSize(3000, 2000);
    	gui.setVisible(true);
    	gui.setLayout(new GridLayout(2, 1));
    	JLabel playersTurn = new JLabel("It is now player " + playerID + "s turn");
    	add(playersTurn);
    	JButton turnSwap = new JButton("Continue");
    	turnSwap.addActionListener(new ActionListener(){
    		
    		public void actionPerformed(ActionEvent e){
    			dispose();
    		}
    	});
    	add(turnSwap);
    }
}
