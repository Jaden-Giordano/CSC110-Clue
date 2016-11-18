package edu.neumont.teamgift.clue.cards;

import java.util.ArrayList;

/**
 * A deck containing cards.
 */
public class Deck {
    /**
     * List of cards in deck.
     */
    private ArrayList<Card> deck = new ArrayList<>();

    /**
     * Add a card to the deck.
     *
     * @param c The card to add.
     */
    public final void add(Card c) {
        deck.add(c);
    }

    /**
     * Get the amount of cards in the deck.
     *
     * @return The amount of cards in the deck.
     */
    public final int size() {
        return deck.size();
    }

    /**
     * Get a card from the deck.
     *
     * @param index The index of the card to grab.
     * @return The card.
     */
    public final Card get(final int index) {
        return deck.get(index);
    }

    /**
     * Set a card at a specific index.
     *
     * @param index The index to change the value of the card to.
     * @param card  The card to change the value to.
     */
    public final void set(final int index, final Card card) {
        deck.set(index, card);
    }

    /**
     * Remove a card from the deck.
     *
     * @param index The index to remove from.
     */
    public final void remove(final int index) {
        deck.remove(index);

	}

}
