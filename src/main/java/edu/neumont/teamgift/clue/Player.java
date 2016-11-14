package edu.neumont.teamgift.clue;

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
		return Deck;
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
