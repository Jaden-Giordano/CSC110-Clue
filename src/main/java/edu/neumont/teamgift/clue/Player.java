package edu.neumont.teamgift.clue;

import edu.neumont.teamgift.clue.cards.Deck;

class Player {

	private int id;
	private String name;
	private Deck deck;
	private Vector2i position;

	public String getName() {
		return name;
	}

	public int getid() {
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
}
