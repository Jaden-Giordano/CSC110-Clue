package edu.neumont.teamgift.clue.front.gui;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import edu.neumont.teamgift.clue.board.Die;
import edu.neumont.teamgift.clue.board.GameMaster;

public class ActionMenuGUI extends JFrame {

	private GameMaster gameMaster;
	private ActionMenu actionMenu;

	public ActionMenuGUI(GameMaster gm, ActionMenu am) {
		this.gameMaster = gm;
		this.actionMenu = am;

		buildActionMenu();
		createActionButtons();
	}

	private void buildActionMenu() {
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1400, 200);
		this.setVisible(true);
	}

	private void createActionButtons() {
		Font titleFont = new Font("Serif", Font.BOLD, 40);
		setLayout(new GridLayout(0, 4));
		JButton rollForTurn = new JButton("Roll and Move");
		rollForTurn.setFont(titleFont);
		rollForTurn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Die d = new Die();
				int roll = d.rollDie();
				String number = "" + roll;
				rollForTurn.setText(number);
			}
		});
		add(rollForTurn);
		/*
		 * JButton moveForTurn = new JButton("Move");
		 * moveForTurn.setFont(titleFont); moveForTurn.addActionListener(new
		 * ActionListener() {
		 * 
		 * public void actionPerformed(ActionEvent e) {
		 * 
		 * } }); add(moveForTurn);
		 */
		JButton beSuspicious = new JButton("Suspicion");
		beSuspicious.setFont(titleFont);
		beSuspicious.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				actionMenu.setActionState(ActionState.Suspicion);
				actionMenu.pushActionInProgress();
				AccusationSuggestionMenu suggestion = new AccusationSuggestionMenu(gameMaster, 0, "Suggestion");
				// for(int i = 0; i < suggestion.getAnswers().size(); i++){
				System.out.println(suggestion.getAnswers() + "1");
				// TODO hide suspicion menu until this is called/clicked.
			}
		});
		add(beSuspicious);
		JButton objection = new JButton("Make Accusation");
		objection.setFont(titleFont);
		objection.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});
		add(objection);
		JButton passTurn = new JButton("End Turn");
		passTurn.setFont(titleFont);
		passTurn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});
		add(passTurn);
	}
}
