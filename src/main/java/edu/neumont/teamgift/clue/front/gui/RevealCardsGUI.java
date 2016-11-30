package edu.neumont.teamgift.clue.front.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import edu.neumont.teamgift.clue.board.GameMaster;
import edu.neumont.teamgift.clue.cards.Card;

public class RevealCardsGUI extends JFrame {
	// call this
	private GameMaster gameMaster;
	public RevealCardsGUI(GameMaster gm, ArrayList<String> cards) {
		this.gameMaster = gm;
		createRevealCards();
		setupRevealCards(cards);
	}

	public void setupRevealCards(ArrayList<String> cards) {
		for (int i = 0; i < cards.size(); i++) {
			int y = i;
			JButton revealableCard = new JButton(cards.get(i));
			Font titleFont = new Font("Serif", Font.BOLD, 40);
			revealableCard.setFont(titleFont);
			revealableCard.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Card c = new Card();
					c.setName(cards.get(y).toString());
					gameMaster.getCurrentPlayer().addToDeck(c);
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
