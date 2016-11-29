package edu.neumont.teamgift.clue.front.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import edu.neumont.teamgift.clue.board.Die;

public class ActionMenuGUI extends JFrame {

	public ActionMenuGUI() {
		buildActionMenu();
		createActionButtons();
	}

	private void buildActionMenu() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1440, 2200);
		this.setVisible(true);
	}

	private void createActionButtons() {
		setLayout(new GridLayout(0, 1));
		JButton rollForTurn = new JButton("Roll Dice");
		rollForTurn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Die d = new Die();
				int roll = d.rollDie();
			}
		});
		add(rollForTurn);
		JButton moveForTurn = new JButton("Move");
		moveForTurn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
			}
		});
		add(moveForTurn);
		JButton beSuspicious = new JButton("Suspicion");
		beSuspicious.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
			}
		});
		add(beSuspicious);
		JButton objection = new JButton("Make Accusation");
		objection.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
			}
		});
		add(objection);
		JButton passTurn = new JButton("End Turn");
		passTurn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
			}
		});
		add(passTurn);
	}
}
