package edu.neumont.teamgift.clue;

import edu.neumont.teamgift.clue.cards.Dealer;
import edu.neumont.teamgift.clue.cards.Die;
import edu.neumont.teamgift.clue.front.FrontEndManager;

public class Clue {

	public static void main(String[] args) {
		/*
		 * Dealer d = new Dealer(); d.createCards(); d.printCards();
		 * System.out.println("\n"); d.shuffle(); d.printCards(); d.setKiller();
		 * System.out.println("\n"); d.printKillerCaseFile();
		 * System.out.println("\n"); d.printCards();
		 */
		Die d = new Die();
		System.out.println(d.rollDie());

//		new FrontEndManager();
	}

}
