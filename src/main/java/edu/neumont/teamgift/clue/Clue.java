package edu.neumont.teamgift.clue;

import edu.neumont.teamgift.clue.board.Die;

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
