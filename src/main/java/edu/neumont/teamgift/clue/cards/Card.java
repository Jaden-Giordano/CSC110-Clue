package edu.neumont.teamgift.clue.cards;

/**
 * Basic card containing name and type.
 */
@SuppressWarnings("WeakerAccess")
public class Card {

    /**
     * The name of the card.
     */
    private String name;
    /**
     * The type of the card.
     */
    private Type type;

    /**
     * Get the name of the card.
     *
     * @return The name of the card.
     */
    public final String getName() {
        return name;
    }

    /**
     * Set the name of the card.
     *
     * @param newName The new name of the card.
     */
    public final void setName(final String newName) {
        name = newName;
    }

    /**
     * Gets the type of the card.
     *
     * @return The type of the card.
     */
    public final Type getType() {
        return type;
    }

    /**
     * Set the type of the card.
     *
     * @param newType The new type of the card.
     */
    public final void setType(final Type newType) {
        type = newType;
    }
}
