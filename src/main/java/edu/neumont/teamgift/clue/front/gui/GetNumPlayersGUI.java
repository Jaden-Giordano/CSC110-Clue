package edu.neumont.teamgift.clue.front.gui;

import edu.neumont.teamgift.clue.front.MainManager;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetNumPlayersGUI extends JFrame {

	private MainManager mainManager;

	public void launchNumbPlayers(MainManager mm) {
		this.mainManager = mm;
		buildActionMenu();
		createActionButtons();
	}

	private void buildActionMenu() {
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 800);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
	}

	private void createActionButtons() {
		Font titleFont = new Font("Serif", Font.BOLD, 40);
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(500, 700));
		add(panel);
		panel.setLayout(new GridLayout(0, 1));		
		JLabel title = new JLabel("How many people are playing?");
		title.setFont(titleFont);
		panel.add(title);
		JLabel organizationalSpace = new JLabel(" ");
		panel.add(organizationalSpace);
		ButtonGroup numPlayer = new ButtonGroup();
		for (int i = 0; i < 6; i++) {
			JRadioButton numPlayers = new JRadioButton("" + (i + 1));
			numPlayers.setFont(titleFont);
			numPlayer.add(numPlayers);
			panel.add(numPlayers);
			//panel.add(organizationalSpace);
		}

		JButton save = new JButton("Save");
		save.setFont(titleFont);
		//save.setSize(300, 500);
		save.setVisible(true);
		save.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (numPlayer.getSelection() != null) {
					int number = 0;
					if (numPlayer.getSelection().equals("1")) {
						number = 1;
					} else if (numPlayer.getSelection().equals("2")) {
						number = 2;
					} else if (numPlayer.getSelection().equals("3")) {
						number = 3;
					} else if (numPlayer.getSelection().equals("4")) {
						number = 4;
					} else if (numPlayer.getSelection().equals("5")) {
						number = 5;
					} else if (numPlayer.getSelection().equals("6")) {
						number = 6;
					}
					mainManager.createGameMaster(number);
					dispose();
				}
			}
		});
		panel.add(save);
	}

}
