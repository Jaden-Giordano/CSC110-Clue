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
