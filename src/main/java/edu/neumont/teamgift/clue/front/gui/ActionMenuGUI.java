package edu.neumont.teamgift.clue.front.gui;

import java.awt.Button;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import edu.neumont.teamgift.clue.board.Die;
import edu.neumont.teamgift.clue.board.GameMaster;
import edu.neumont.teamgift.clue.board.Weapons;

public class ActionMenuGUI extends JFrame {

	private ActionMenu actionMenu;
	private GameMaster gameMaster;
	private LargeGUI large;
	private boolean firstRun;

	public ActionMenuGUI(GameMaster gm, ActionMenu am) {
		this.actionMenu = am;
		this.gameMaster = gm;
		firstRun = true;
		buildActionMenu();
		createActionButtons();
	}

	private void buildActionMenu() {
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 800);
		this.setVisible(true);
	}

	private void createActionButtons() {
		Font titleFont = new Font("Serif", Font.BOLD, 40);
		setLayout(new GridLayout(0, 1));
		if (firstRun) {
			JLabel title = new JLabel();
			title.setFont(titleFont);
			add(title);
			ButtonGroup numPlayer = new ButtonGroup();
			for (int i = 0; i < 6; i++) {
				JRadioButton numPlayers = new JRadioButton("" + (i + 1));
				numPlayers.setFont(titleFont);
				numPlayer.add(numPlayers);
				add(numPlayers);
			}
			
			Button save = new Button("Save");
			save.setFont(titleFont);
			save.setSize(300, 500);
			save.setVisible(true);
			save.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					if (numPlayer.getSelection() != null) {
						int number = 0;
						if(numPlayer.getSelection().equals("1")){
							number = 1;
						}else if(numPlayer.getSelection().equals("2")){
							number = 2;
						}else if(numPlayer.getSelection().equals("3")){
							number = 3;
						}else if(numPlayer.getSelection().equals("4")){
							number = 4;
						}else if(numPlayer.getSelection().equals("5")){
							number = 5;
						}else if(numPlayer.getSelection().equals("6")){
							number = 6;
						}
						gameMaster.setNumPlayers(number);
						dispose();
					}
				}
			});
			add(save);
			firstRun = false;
		} else {
			JButton rollForTurn = new JButton("Roll and Move");
			rollForTurn.setFont(titleFont);
			rollForTurn.addActionListener(new ActionListener() {

				int someNumber = 0;

				public void actionPerformed(ActionEvent e) {
					someNumber++;
					if (someNumber <= 1) {
						Die d = new Die();
						int roll = d.rollDie();
						String display = "Spaces left: " + roll;
						rollForTurn.setText(display);
						gameMaster.takeTurn(gameMaster.getCurrentPlayer(), roll);
					}

				}
			});
			add(rollForTurn);
			JButton beSuspicious = new JButton("Suspicion");
			beSuspicious.setFont(titleFont);
			beSuspicious.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					actionMenu.setActionState(ActionState.Suspicion);
					actionMenu.pushActionInProgress();
					AccusationSuggestionMenu suggestion = new AccusationSuggestionMenu(gameMaster,
							gameMaster.getCurrentPlayer().getID(), "Suspicion");
					suggestion.getAnswers();
				}
			});
			add(beSuspicious);

			JButton objection = new JButton("Make Accusation");
			objection.setFont(titleFont);
			objection.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					AccusationSuggestionMenu accusation = new AccusationSuggestionMenu(gameMaster,
							gameMaster.getCurrentPlayer().getID(), "Suspicion");
					ArrayList<String> answers = accusation.getAnswers();
					gameMaster.makeAccusation(gameMaster.getCurrentPlayer(), answers.get(0), answers.get(1),
							answers.get(2));
				}
			});
			add(objection);

			JButton passTurn = new JButton("End Turn");
			passTurn.setFont(titleFont);
			passTurn.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					large = new LargeGUI();
					gameMaster.nextTurn();
					large.callMeMaybe();
				}
			});
			add(passTurn);
		}
	}
}
