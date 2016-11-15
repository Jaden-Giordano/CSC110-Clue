package edu.neumont.teamgift.clue;

import edu.neumont.teamgift.clue.board.Board;
import edu.neumont.teamgift.clue.cards.Deck;

public class Player {

	private Board board;

	private int id;
	private String name;
	private Deck deck;
	private Vector2i position;

	public Player(Board board, int id, String name) {
        this.board = board;

        this.id = id;
        this.name = name;

        this.deck = new Deck();
	}

	public String getName() {
		return name;
	}

	public int getID() {
		return id;
	}

	public Deck getDeck() {
		return deck;
	}

	/*public void addCard(Card newCard) {
		cards.add(newCard);
	}*/

	public Vector2i getPosition() {
		return position;
	}

	public void setPosition(Vector2i newPosition) {
		position = newPosition;
	}

	public Board getBoard() {
        return this.board;
    }

}
