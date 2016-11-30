package edu.neumont.teamgift.clue.front.gui;

import edu.neumont.teamgift.clue.Notepad;
import edu.neumont.teamgift.clue.Vector2i;
import edu.neumont.teamgift.clue.board.GameMaster;
import edu.neumont.teamgift.clue.board.Rooms;
import edu.neumont.teamgift.clue.board.Suspects;
import edu.neumont.teamgift.clue.board.Weapons;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
     *
     * @param game The game.
     * @param playerID The id of the player for the gui.
     */
    public NotepadGui(final GameMaster game, final int playerID) {
        setUpNotepad(game, playerID);
        createNotepadGui(game, playerID);
    }

    /**
     * Start point for GUIs.
     * TODO Switch over to Clue start point.
     */
    public void createNotepadGui(final GameMaster game, final int playerID) {
//        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(NOTEPAD_DIMENSIONS.x, NOTEPAD_DIMENSIONS.y);
        this.setVisible(false);
        this.setTitle("Notepad Gui id: " + playerID);
        this.setLocation(0, 0);
    }


    /**
     * Start point for GUIs. TODO Switch over to Clue start point.
     *
     * @param args
     *            Command line args.
     */


    /**
     * Fill notepad with generated content.
     */
    public void setUpNotepad(final GameMaster game, final int playerNumber) {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(NOTEPAD_DIMENSIONS.x, PANEL_HEIGHT));
        add(panel);
        final int column = 2;
        panel.setLayout(new GridLayout(0, column));
        JScrollPane jNotepad = new JScrollPane(panel);
        jNotepad.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(jNotepad);
        JLabel cardLabel = new JLabel("Your cards are: ");
        cardLabel.setFont(new Font("Serif", Font.PLAIN, LARGE_FONT));
        panel.add(cardLabel);
        String cards = "";
        for (int i = 0; i < game.getPlayer(playerNumber).getDeck().size(); i++) {
            cards += game.getPlayer(playerNumber).getDeck().get(i).getName() + ", \n";
        }
        JLabel cardDisplay = new JLabel(cards);
        cardDisplay.setFont(new Font("Serif", Font.PLAIN, SMALL_FONT));
        panel.add(cardDisplay);
        JLabel suspectsLabel = new JLabel("Suspects: ");
        suspectsLabel.setFont(new Font("Serif", Font.PLAIN, LARGE_FONT));
        panel.add(suspectsLabel);
        JLabel organizationalSpace = new JLabel(" ");
        organizationalSpace.setFont(new Font("Serif", Font.PLAIN, LARGE_FONT));
        panel.add(organizationalSpace);
        // JButton difWindow = new JButton("open new");
        // difWindow.addActionListener(new NewWindowButton(difWindow));
        int index = 0;
        for (Suspects i : Suspects.values()) {
            JLabel suspectLabel = new JLabel("" + i);
            suspectLabel.setFont(new Font("Serif", Font.PLAIN, SMALL_FONT));
            panel.add(suspectLabel);
            Notepad.setPlayerStorage(playerNumber, index, i.name());
            JButton suspectButton = new JButton(Notepad.getPlayerStorage(playerNumber,
                    index));
            suspectButton.setFont(new Font("Serif", Font.PLAIN, SMALL_FONT));
            suspectButton
                    .addActionListener(new NotepadGuiButton(suspectButton,
                            playerNumber, index));
            panel.add(suspectButton);
            index++;
        }
        JLabel weaponsLabel = new JLabel("Weapons: ");
        weaponsLabel.setFont(new Font("Serif", Font.PLAIN, LARGE_FONT));
        panel.add(weaponsLabel);
        organizationalSpace = new JLabel(" ");
        organizationalSpace.setFont(new Font("Serif", Font.PLAIN, LARGE_FONT));
        panel.add(organizationalSpace);
        for (Weapons i : Weapons.values()) {
            JLabel weaponLabel = new JLabel("" + i);
            weaponLabel.setFont(new Font("Serif", Font.PLAIN, SMALL_FONT));
            panel.add(weaponLabel);
            Notepad.setPlayerStorage(playerNumber, index, i.name());
            JButton weaponButton = new JButton(
                    Notepad.getPlayerStorage(playerNumber, index));
            weaponButton.setFont(new Font("Serif", Font.PLAIN, SMALL_FONT));
            weaponButton
                    .addActionListener(new NotepadGuiButton(weaponButton, playerNumber,
                            index));
            panel.add(weaponButton);
            index++;
        }
        JLabel roomsLabel = new JLabel("Rooms: ");
        roomsLabel.setFont(new Font("Serif", Font.PLAIN, LARGE_FONT));
        panel.add(roomsLabel);
        organizationalSpace = new JLabel(" ");
        organizationalSpace.setFont(new Font("Serif", Font.PLAIN, LARGE_FONT));
        panel.add(organizationalSpace);
        for (Rooms i : Rooms.values()) {
            JLabel roomLabel = new JLabel("" + i);
            roomLabel.setFont(new Font("Serif", Font.PLAIN, SMALL_FONT));
            panel.add(roomLabel);
            Notepad.setPlayerStorage(playerNumber, index, i.name());
            JButton roomsButton = new JButton(
                    "" + Notepad.getPlayerStorage(playerNumber, index));
            roomsButton.setFont(new Font("Serif", Font.PLAIN, SMALL_FONT));
            roomsButton.addActionListener(new NotepadGuiButton(roomsButton,
                    playerNumber, index));
            panel.add(roomsButton);
            index++;
        }

    }

    /**
     * Open the notepad gui. 
     */
    public void open() {
        this.setVisible(true);
    }

    /**
     * Close the notepad gui.
     */
    public void close() {
        this.setVisible(false);
    }

}
