package edu.neumont.teamgift.clue.cards;

import edu.neumont.teamgift.clue.Player;
import edu.neumont.teamgift.clue.board.GameMaster;

import java.util.Random;

/**
 * A dealer for cards, separate from Game Master.
 */
@SuppressWarnings({ "WeakerAccess", "unused" })
public class Dealer {

	/**
	 * The amount of times to shuffle the deck.
	 */
	private static final int SHUFFLE_COUNT = 100;

	/**
	 * The main deck of cards.
	 */
	private final Deck cards = new Deck();

	/**
	 * Storage for all the answer to the case.
	 */
	private final Deck killerCaseFile = new Deck();

	/**
	 * Creates all the cards in the deck.
	 */
	public final void createCards() {
		String[] weapons = { "Rope", "Lead Pipe", "Knife", "Wrench", "Candlestick", "Pistol" };
		String[] people = { "Colonel Mustard", "Miss Scarlet", "Professor Plum", "Mr. Green", "Mrs. White",
				"Mrs. Peacock" };
		String[] rooms = { "Ballroom", "Kitchen", "Dining Room", "Lounge", "Hall", "Study", "Library", "Billiard Room",
				"Conservatory" };
		final int total = weapons.length + people.length + rooms.length;

		for (int i = 0; i < total; i++) {
			if (i < weapons.length) {
				Card c = new Card();
				c.setName(weapons[i]);
				c.setType(Type.Weapon);
				cards.add(c);
			} else if (i < weapons.length + people.length) {
				Card c = new Card();
				c.setName(people[i - weapons.length]);
				c.setType(Type.Player);
				cards.add(c);
			} else {
				Card c = new Card();
				c.setName(rooms[i - weapons.length - people.length]);
				c.setType(Type.Room);
				cards.add(c);
			}
		}
	}

	/**
	 * Shuffles the deck.
	 */
	public final void shuffle() {
		Random r = new Random();
		for (int i = 0; i < SHUFFLE_COUNT; i++) {
			int randomIndex = r.nextInt(cards.size());
			int randomIndex2 = r.nextInt(cards.size());
			Card savedOffCard = cards.get(randomIndex);
			cards.set(randomIndex, cards.get(randomIndex2));
			cards.set(randomIndex2, savedOffCard);
		}

	}

	/**
	 * Prints all cards out to the console.
	 */
	public final void printCards() {
		for (int i = 0; i < cards.size(); i++) {
			System.out.println(i + ". " + cards.get(i).getName() + " Type: " + cards.get(i).getType());
		}
	}

	/**
	 * Prints the killer's case file to the console.
	 */
	public final void printKillerCaseFile() {
		for (int i = 0; i < killerCaseFile.size(); i++) {
			System.out
					.println(i + ". " + killerCaseFile.get(i).getName() + " Type: " + killerCaseFile.get(i).getType());
		}
	}

	/**
	 * Sets the killer and stores his case file.
	 */
	public final void setKiller() {
		boolean weaponPicked = false;
		boolean roomPicked = false;
		boolean personPicked = false;
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).getType() == Type.Weapon && !weaponPicked) {
				killerCaseFile.add(cards.get(i));
				cards.remove(i);
				weaponPicked = true;
			}
			if (cards.get(i).getType() == Type.Player && !personPicked) {
				killerCaseFile.add(cards.get(i));
				cards.remove(i);
				personPicked = true;
			}
			if (cards.get(i).getType() == Type.Room && !roomPicked) {
				killerCaseFile.add(cards.get(i));
				cards.remove(i);
				roomPicked = true;
			}

		}
	}

	public final void dealCards(GameMaster game) {
		while (cards.size() != 0) {
			for (int i = 0; i < game.getNumPlayers(); i++) {
				if (cards.size() == 0) {
					break;
				}
				Player p = game.getPlayerList(i % game.getNumPlayers());
				Card c = cards.get(0);
				p.addToDeck(c);
				cards.remove(0);
			}
		}
	}

}
