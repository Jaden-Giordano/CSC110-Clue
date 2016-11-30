package edu.neumont.teamgift.clue.front.gui;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.neumont.teamgift.clue.board.GameMaster;

public class LargeGUI extends JFrame {
	
	private ActionMenu actionMenu;
	private GameMaster gameMaster;

	public void createAwkwardlyLargeGUI() {
		// LargeGUI gui = new LargeGUI();
		
		this.setSize(3000, 2000);
		this.setVisible(true);
		this.setLayout(new GridLayout(2, 1));
		this.setAlwaysOnTop(true);
	}

	public void setupAwkwardlyLargueGUI() {
		Font titleFont = new Font("Serif", Font.BOLD, 200);
		JPanel willYouPlsWork = new JPanel();
		add(willYouPlsWork);
		JLabel playersTurn = new JLabel("It is the next player's turn");
		playersTurn.setFont(titleFont);
		willYouPlsWork.add(playersTurn);
		JButton turnSwap = new JButton("Continue");
		turnSwap.setFont(titleFont);
		turnSwap.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new ActionMenuGUI(gameMaster, actionMenu);
				dispose();
			}
		});
		willYouPlsWork.add(turnSwap);
	}

	public LargeGUI(GameMaster gm, ActionMenu am) {
		this.actionMenu = am;
		this.gameMaster = gm;
		setupAwkwardlyLargueGUI();
		createAwkwardlyLargeGUI();
	}

}
