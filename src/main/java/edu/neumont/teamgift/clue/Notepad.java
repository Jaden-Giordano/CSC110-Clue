package edu.neumont.teamgift.clue;

import edu.neumont.teamgift.clue.board.GameMaster;

/**
 * The notepad for each player.
 */
public class Notepad {

    /**
     * The amount of objects in each category.
     */
    private static final int AMOUNT_OF_SUSPECTS = 6,
            AMOUNT_OF_WEAPONS = 6, AMOUNT_OF_ROOMS = 9;
    
    /**
     * The suspects and their values.
     */
    @SuppressWarnings("CanBeFinal")
    private static String[][] playerStorage;

    /**
     * Create a new generic notepad.
     */
    public static void init(GameMaster master) {
        playerStorage = new String[master.getNumPlayers()][21];
    }

    public static void setPlayerStorage(final int playerID, final int index, final
    String value) {
        playerStorage[playerID][index] = value;
    }

    public static String getPlayerStorage(final int playerID, final int index) {
        return playerStorage[playerID][index];
    }

}
