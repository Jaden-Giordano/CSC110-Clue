package edu.neumont.teamgift.clue.front.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class RevealCardsGUI extends JFrame {
	// call this
	public RevealCardsGUI(ArrayList<String> cards) {
		createRevealCards();
		setupRevealCards(cards);
	}

	private String revealedCard;

	public void setupRevealCards(ArrayList<String> cards) {
		if(cards.size() == 0){
			JButton revealableCard = new JButton("No one has those cards: click me");
			Font titleFont = new Font("Serif", Font.BOLD, 40);
			revealableCard.setFont(titleFont);
			revealableCard.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			add(revealableCard);
		}
		for (int i = 0; i < cards.size(); i++) {
			JButton revealableCard = new JButton(cards.get(i));
			Font titleFont = new Font("Serif", Font.BOLD, 40);
			revealableCard.setFont(titleFont);
			revealableCard.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			add(revealableCard);
		}
	}

	public void createRevealCards() {
		this.setSize(500, 800);
		this.setVisible(true);
	}
}
