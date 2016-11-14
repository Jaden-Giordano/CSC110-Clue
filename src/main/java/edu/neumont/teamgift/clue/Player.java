package edu.neumont.teamgift.clue;

import edu.neumont.teamgift.clue.cards.Card;
import edu.neumont.teamgift.clue.cards.Deck;

import java.util.ArrayList;
import java.util.List;

class Player {

	private int id;
	private String name;
	private Deck deck;
	private Vector2i position;

	public String getName() {
		return name;
	}

	public void setCharacterName(String Name) {
		name = Name;
	}

	public int getid() {
		return id;
	}

	public void setid(int ID) {
		id = ID;
	}
}
