package edu.neumont.teamgift.clue.front.gui;

import edu.neumont.teamgift.clue.Notepad;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Button for each notepad selection.
 */
class NotepadGuiButton implements ActionListener {

    /**
     * Reference to button on gui.
     */
    @SuppressWarnings("CanBeFinal")
    private JButton button;

    /**
     * Reference to notepad object for storage.
     */
    @SuppressWarnings("unused")
    private Notepad notepad;

    /**
     * Index of category.
     */
    @SuppressWarnings("CanBeFinal")
    private int index;

    /**
     * Button listener creation.
     *
     * @param refButton Reference to button on gui.
     * @param catIndex  Index of category for looping.
     */
    NotepadGuiButton(final JButton refButton, final int catIndex) {
        this.index = catIndex;
        this.button = refButton;
        @SuppressWarnings("UnusedAssignment") Notepad nNotepad = new Notepad();

    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        String buttonEnum = findEnum(button.getText());
        String buttonValue;
        if (button.getText().equals("X")) {
            buttonValue = " ";
            button.setText(buttonValue);
            changeValue(buttonEnum, this.index, buttonValue);
        } else if (button.getText().equals(" ")) {
            buttonValue = "X";
            button.setText(buttonValue);
            changeValue(buttonEnum, this.index, buttonValue);
        } else {
            buttonValue = "X";
            button.setText(buttonValue);
            changeValue(buttonEnum, this.index, buttonValue);
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

    /**
     * Change the value of a categories index.
     *
     * @param enumValue   The category to change.
     * @param index       The index of the category.
     * @param buttonValue The value to change it to.
     */
    private static void changeValue(final String enumValue,
                                    final int index, final String buttonValue) {
        Notepad notepad = new Notepad();
        switch (enumValue) {
            case "Suspects":
                notepad.setSuspect(index, buttonValue);
                break;
            case "Weapons":
                notepad.setWeapon(index, buttonValue);
                break;
            case "Rooms":
                notepad.setRoom(index, buttonValue);
                break;
            default:
                break;
        }
    }
}
