package edu.neumont.teamgift.clue.front.gui;

import edu.neumont.teamgift.clue.Notepad;
import edu.neumont.teamgift.clue.Player;
import edu.neumont.teamgift.clue.Vector2i;
import edu.neumont.teamgift.clue.board.GameMaster;
import edu.neumont.teamgift.clue.cards.Deck;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

/**
 * Display for each players notepad.
 */
public final class NotepadGui extends JFrame {

    /**
     * Notepad window dimensions.
     */
    private static final Vector2i NOTEPAD_DIMENSIONS = new Vector2i(700, 2000);

    /**
     * Height of panel inside notepad.
     */
    private static final int PANEL_HEIGHT = 3000;

    /**
     * Font sizes for text.
     */
    private static final int LARGE_FONT = 40, SMALL_FONT = 30;

    /**
     * Creation of notepad.
     */
    private NotepadGui(GameMaster game, int playerID) {
        setUpNotepad(game, playerID);
    }

    /**
     * Start point for GUIs.
     * TODO Switch over to Clue start point.
     *
     * @param args Command line args.
     */
    public void setEverythingTheFuckUp(GameMaster game, int playerID) {
        NotepadGui gui = new NotepadGui(game, playerID);

        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gui.setSize(NOTEPAD_DIMENSIONS.x, NOTEPAD_DIMENSIONS.y);
        gui.setVisible(true);
        gui.setTitle("Notepad Gui");

    }

    /**
     * Fill notepad with generated content.
     */
    private void setUpNotepad(GameMaster game, int playerNumber) {
        Notepad notepad = new Notepad();
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(NOTEPAD_DIMENSIONS.x,
                PANEL_HEIGHT));
        add(panel);
        final int column = 2;
        panel.setLayout(new GridLayout(0, column));
        JScrollPane jNotepad = new JScrollPane(panel);
        jNotepad.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(jNotepad);
        JLabel cardLabel = new JLabel("Your cards are: ");
        cardLabel.setFont(new Font("Serif", Font.PLAIN, LARGE_FONT));
        panel.add(cardLabel);
        JLabel cardDisplay = new JLabel(game.getPlayerList(playerNumber).getDeck().toString());
        cardDisplay.setFont(new Font("Serif", Font.PLAIN, SMALL_FONT));
        panel.add(cardDisplay);
        JLabel suspectsLabel = new JLabel("Suspects: ");
        suspectsLabel.setFont(new Font("Serif", Font.PLAIN, LARGE_FONT));
        panel.add(suspectsLabel);
        JLabel organizationalSpace = new JLabel(" ");
        organizationalSpace.setFont(new Font("Serif", Font.PLAIN, LARGE_FONT));
        panel.add(organizationalSpace);
        //JButton difWindow = new JButton("open new");
        //difWindow.addActionListener(new NewWindowButton(difWindow));
        int suspectIndex = 0;
        for (Suspects i : Suspects.values()) {
            JLabel suspectLabel = new JLabel("" + i);
            suspectLabel.setFont(new Font("Serif", Font.PLAIN, SMALL_FONT));
            panel.add(suspectLabel);
            notepad.setSuspect(suspectIndex, i.name());
            JButton suspectButton =
                    new JButton(notepad.getSuspect(suspectIndex));
            suspectButton.setFont(new Font("Serif", Font.PLAIN, SMALL_FONT));
            suspectButton.addActionListener(
                    new NotepadGuiButton(suspectButton, suspectIndex));
            panel.add(suspectButton);
            suspectIndex++;
        }
        JLabel weaponsLabel = new JLabel("Weapons: ");
        weaponsLabel.setFont(new Font("Serif", Font.PLAIN, LARGE_FONT));
        panel.add(weaponsLabel);
        organizationalSpace = new JLabel(" ");
        organizationalSpace.setFont(new Font("Serif", Font.PLAIN, LARGE_FONT));
        panel.add(organizationalSpace);
        int weaponIndex = 0;
        for (Weapons i : Weapons.values()) {
            JLabel weaponLabel = new JLabel("" + i);
            weaponLabel.setFont(new Font("Serif", Font.PLAIN, SMALL_FONT));
            panel.add(weaponLabel);
            notepad.setWeapon(weaponIndex, i.name());
            JButton weaponButton = new JButton(notepad.getWeapon(weaponIndex));
            weaponButton.setFont(new Font("Serif", Font.PLAIN, SMALL_FONT));
            weaponButton.addActionListener(
                    new NotepadGuiButton(weaponButton, weaponIndex));
            panel.add(weaponButton);
            weaponIndex++;
        }
        JLabel roomsLabel = new JLabel("Rooms: ");
        roomsLabel.setFont(new Font("Serif", Font.PLAIN, LARGE_FONT));
        panel.add(roomsLabel);
        organizationalSpace = new JLabel(" ");
        organizationalSpace.setFont(new Font("Serif", Font.PLAIN, LARGE_FONT));
        panel.add(organizationalSpace);
        int roomsIndex = 0;
        for (Rooms i : Rooms.values()) {
            JLabel roomLabel = new JLabel("" + i);
            roomLabel.setFont(new Font("Serif", Font.PLAIN, SMALL_FONT));
            panel.add(roomLabel);
            notepad.setRoom(roomsIndex, i.name());
            JButton roomsButton = new JButton((roomsIndex + 1) + ". "
                    + notepad.getRoom(roomsIndex));
            roomsButton.setFont(new Font("Serif", Font.PLAIN, SMALL_FONT));
            roomsButton.addActionListener(
                    new NotepadGuiButton(roomsButton, roomsIndex));
            panel.add(roomsButton);
            roomsIndex++;
        }


    }
}

