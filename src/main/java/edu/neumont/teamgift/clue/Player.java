package edu.neumont.teamgift.clue;

import edu.neumont.teamgift.clue.cards.Card;
import java.util.ArrayList;
import java.util.List;

class Player {

	private int id;
	private String name;
	private List<Card> cards = new ArrayList<>();

	public String getName() {
		return name;
	}

	public int getid() {
		return id;
	}

	public Deck getDeck() {
		return Deck;
	}

	public void addCard(Card newCard) {
		cards.add(newCard);
	}

	public Vector2i getPosition() {
		return position;
	}

	public void setPosition(Vector2i newPosition) {
		position = newPosition;
	}
}
