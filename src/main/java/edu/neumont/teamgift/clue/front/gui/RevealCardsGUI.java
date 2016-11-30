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
		for (int i = 0; i < cards.size(); i++) {
			int y = i;
			JButton revealableCard = new JButton(cards.get(i));
			Font titleFont = new Font("Serif", Font.BOLD, 40);
			revealableCard.setFont(titleFont);
			revealableCard.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					revealedCard = cards.get(y).toString();

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
