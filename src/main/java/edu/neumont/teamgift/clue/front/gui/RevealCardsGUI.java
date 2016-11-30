package edu.neumont.teamgift.clue.front.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class RevealCardsGUI extends JFrame{
	//call this
	public void runRevealCards(){
		createRevealCards();
		setupRevealCards();
	}
	private String revealedCard;
	
	public void setupRevealCards(){
		for(int i = 0; i</*insert array here*/;i++){
			JButton revealableCard = new JButton(/*insert array here*/ at index i);
			Font titleFont = new Font("Serif", Font.BOLD, 40);
			revealableCard.setFont(titleFont);
			revealableCard.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					revealedCard = /*insert array here*/ at index i;
					if(revealedCard = null){
						revealedCard = "no one has that card";
					}
				}
			});
			add(revealableCard);
		}
	}
	
	
	public void createRevealCards(){
		this.setSize(500, 800);
		this.setVisible(true);
	}
}
