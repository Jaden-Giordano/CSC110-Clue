package edu.neumont.teamgift.clue;

import edu.neumont.teamgift.clue.board.GameMaster;
import edu.neumont.teamgift.clue.cards.Dealer;

public class RunGame {
	public void runGame() {
		GameMaster game = new GameMaster();
		Dealer dealer = new Dealer();
		// TODO Number of players
		// TODO Name selection if we want
		// Create cards
		dealer.createCards();
		// Shuffle cards
		dealer.shuffle();
		// Set killer case file
		dealer.setKiller();
		// Create players
		game.createPlayers();
		/*
		 * for (int i = 0; i < game.getPlayerList().length; i++) {
		 * System.out.println(game.getPlayerList()[i].getName() +
		 * " This is round " + i); }
		 */
		// Create board
		game.createBoard();
		// dealer.printCards();
		// Deal rest of cards
		dealer.dealCards(game);
		// TODO Win condition
		// TODO Take turns through players
		while (true) {
			for (int i = 0; i < game.getPlayerList().length; i++) {
				game.takeTurn(game.getPlayerList()[i]);
			}
		}

	}
}
