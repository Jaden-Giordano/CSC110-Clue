package edu.neumont.teamgift.clue.front.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LargeGUI extends JFrame{
	
	public void createAwkwardlyLargeGUI(){
    	LargeGUI gui = new LargeGUI();
    	gui.setSize(3000, 2000);
    	gui.setVisible(true);
    	gui.setLayout(new GridLayout(2, 1));
    	
    }
	public void setupAwkwardlyLargueGUI(){
		JLabel playersTurn = new JLabel("It is the next player's turn");
    	add(playersTurn);
    	JButton turnSwap = new JButton("Continue");
    	turnSwap.addActionListener(new ActionListener(){
    		
    		public void actionPerformed(ActionEvent e){
    			dispose();
    		}
    	});
    	add(turnSwap);
	}
	public void callMeMaybe(){
		createAwkwardlyLargeGUI();
		setupAwkwardlyLargueGUI();
	}
}
