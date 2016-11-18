package edu.neumont.teamgift.clue;

/**
 * The notepad for each player.
 */
public class Notepad {

    /**
     * The amount of objects in each category.
     */
    private static final int AMOUNT_OF_SUSPECTS = 6, AMOUNT_OF_WEAPONS = 6, AMOUNT_OF_ROOMS = 9;

    /**
     * The suspects and their values.
     */
    private String[] suspects;
    /**
     * The weapons and their values.
     */
    private String[] weapons;
    /**
     * The rooms and their values.
     */
    private String[] rooms;

    /**
     * Create a new generic notepad.
     */
    public Notepad() {
        suspects = new String[AMOUNT_OF_SUSPECTS];
        weapons = new String[AMOUNT_OF_WEAPONS];
        rooms = new String[AMOUNT_OF_ROOMS];
    }

    /**
     * Set a weapon's value.
     *
     * @param index The specific weapon.
     * @param value The value to set for it.
     */
    public final void setWeapon(final int index, final String value) {
        weapons[index] = value;
    }

    /**
     * Get a weapon.
     *
     * @param index The specific weapon.
     * @return The weapon's value.
     */
    public final String getWeapon(final int index) {
        return weapons[index];
    }

    /**
     * Set a suspect's value.
     *
     * @param index The specific suspect.
     * @param value The value to set for it.
     */
    public final void setSuspect(final int index, final String value) {
        suspects[index] = value;
    }

    /**
     * Get a suspect.
     *
     * @param index The specific suspect.
     * @return The suspect's value.
     */
    public final String getSuspect(final int index) {
        return suspects[index];
    }

    /**
     * Set a room's value.
     *
     * @param index The specific room.
     * @param value The value to set for it.
     */
    public final void setRoom(final int index, final String value) {
        rooms[index] = value;
    }

    /**
     * Get a room.
     *
     * @param index The specific room.
     * @return The room's value.
     */
    public final String getRoom(final int index) {
        return rooms[index];
    }

}
