package edu.neumont.teamgift.clue.front.gui;

import edu.neumont.teamgift.clue.Notepad;
import edu.neumont.teamgift.clue.board.Rooms;
import edu.neumont.teamgift.clue.board.Suspects;
import edu.neumont.teamgift.clue.board.Weapons;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Button for each notepad selection.
 */
class NotepadGuiButton implements ActionListener {

    /**
     * The player id correlating to.
     */
    private final int playerID;
    /**
     * Index of category.
     */
    @SuppressWarnings("CanBeFinal")
    private final int index;
    /**
     * Reference to button on gui.
     */
    @SuppressWarnings("CanBeFinal")
    private JButton button;

    /**
     * Button listener creation.
     *
     * @param refButton Reference to button on gui.
     * @param catIndex  Index of category for looping.
     */
    NotepadGuiButton(final JButton refButton, final int player, final int catIndex) {
        this.index = catIndex;
        this.button = refButton;
        this.playerID = player;

    }

    /**
     * Change the value of a categories index.
     *
     * @param playerID   The player to change.
     * @param index       The index of the category.
     * @param buttonValue The value to change it to.
     */
    private static void changeValue(final int playerID,
                                    final int index, final String buttonValue) {
        Notepad.setPlayerStorage(playerID, index, buttonValue);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        String buttonEnum = findEnum(button.getText());
        String buttonValue;
        if (button.getText().equals("X")) {
            buttonValue = " ";
            button.setText(buttonValue);
            changeValue(playerID, this.index, buttonValue);
        } else if (button.getText().equals(" ")) {
            buttonValue = "X";
            button.setText(buttonValue);
            changeValue(playerID, this.index, buttonValue);
        } else {
            buttonValue = "X";
            button.setText(buttonValue);
            changeValue(playerID, this.index, buttonValue);
        }

    }

    /**
     * Find an enum that correlates to a value.
     *
     * @param buttonContents The value to search for.
     * @return The enum correlating to the value; returns null if not found.
     */
    private String findEnum(final String buttonContents) {
        for (Weapons i : Weapons.values()) {
            if (buttonContents.equals(i.name())) {
                return "Weapons";
            }
        }
        for (Suspects i : Suspects.values()) {
            if (buttonContents.equals(i.name())) {
                return "Suspects";
            }
        }
        for (Rooms i : Rooms.values()) {
            if (buttonContents.equals(i.name())) {
                return "Rooms";
            }
        }
        return null;
    }
}
