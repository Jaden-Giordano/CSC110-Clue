package edu.neumont.teamgift.clue.cards;

import java.util.ArrayList;

public class Deck {
	private ArrayList<Card> deck = new ArrayList<Card>();

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public void add(Card c) {
		deck.add(c);
	}

	public int size() {
		return deck.size();
	}

	public Card get(int index) {
		return deck.get(index);
	}

	public void set(int index, Card card) {
		deck.set(index, card);
	}

	public void remove(int index) {
		deck.remove(index);

	}

}
