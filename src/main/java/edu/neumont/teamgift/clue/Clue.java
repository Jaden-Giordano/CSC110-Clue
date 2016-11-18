package edu.neumont.teamgift.clue;

import edu.neumont.teamgift.clue.board.Die;

/**
 * Starting level for clue game.
 */
final class Clue {

    /**
     * Start clue game.
     */
    private Clue() {
        /*
		 * Dealer d = new Dealer(); d.createCards(); d.printCards();
		 * System.out.println("\n"); d.shuffle();
		 * d.printCards(); d.setKiller();
		 * System.out.println("\n"); d.printKillerCaseFile();
		 * System.out.println("\n"); d.printCards();
		 */
        Die d = new Die();
        System.out.println(d.rollDie());

//		new FrontEndManager();
    }

    /**
     * Starting point in program.
     *
     * @param args Arguments from console.
     */
	public static void main(String[] args) {
        new Clue();
    }

}
