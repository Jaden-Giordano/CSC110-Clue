package edu.neumont.teamgift.clue.front.gui;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import edu.neumont.teamgift.clue.Notepad;
import edu.neumont.teamgift.clue.Vector2i;
import edu.neumont.teamgift.clue.board.GameMaster;
import edu.neumont.teamgift.clue.board.Rooms;
import edu.neumont.teamgift.clue.board.Suspects;
import edu.neumont.teamgift.clue.board.Weapons;

public class AccusationSuggestionMenu extends JFrame {

	public AccusationSuggestionMenu(GameMaster game, int playerID, String whatAmI) {
		setUpMenu(game, playerID);
		setUpSuggestionAccusationMenu(game, playerID, whatAmI);
	}

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

	private ButtonGroup suspects = new ButtonGroup(), weapons = new ButtonGroup(), rooms = new ButtonGroup();

	private ArrayList<String> answers = new ArrayList<String>();

	/**
	 * Creation of notepad.
	 *
	 * @param game
	 *            The game.
	 * @param playerID
	 *            The id of the player for the gui.
	 */
	// public AccusationSuggestionMenu(GameMaster game, int playerID, String
	// whatAmI) {
	// setUpMenu(game, playerID);
	// setUpSuggestionAccusationMenu(game, playerID, whatAmI);
	// }

	/**
	 * Start point for GUIs. TODO Switch over to Clue start point.
	 */
	public void setUpSuggestionAccusationMenu(final GameMaster game, final int playerID, String whatAmI) {
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(NOTEPAD_DIMENSIONS.x, NOTEPAD_DIMENSIONS.y);
		this.setVisible(true);
		this.setTitle(whatAmI);
	}

	public void setUpMenu(final GameMaster game, final int playerNumber) {

		Font titleFont = new Font("Serif", Font.BOLD, LARGE_FONT);
		Font regularFont = new Font("Serif", Font.PLAIN, LARGE_FONT);
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(NOTEPAD_DIMENSIONS.x, PANEL_HEIGHT));
		add(panel);
		final int column = 2;
		panel.setLayout(new GridLayout(0, column));
		JScrollPane jNotepad = new JScrollPane(panel);
		jNotepad.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(jNotepad);
		JLabel suspectLabel = new JLabel("Suspects: ");
		suspectLabel.setFont(titleFont);
		panel.add(suspectLabel);
		JLabel organizationalSpace = new JLabel(" ");
		organizationalSpace.setFont(new Font("Serif", Font.PLAIN, LARGE_FONT));
		panel.add(organizationalSpace);
		int index = 0;
		for (Suspects i : Suspects.values()) {
			JRadioButton suspectButton = new JRadioButton(Notepad.getPlayerStorage(playerNumber, index));
			suspectButton.setFont(regularFont);
			suspectButton.setActionCommand(Notepad.getPlayerStorage(playerNumber, index));
			panel.add(suspectButton);
			suspects.add(suspectButton);
			index++;
			organizationalSpace = new JLabel(" ");
			organizationalSpace.setFont(new Font("Serif", Font.PLAIN, LARGE_FONT));
			panel.add(organizationalSpace);
		}
		JLabel weaponsLabel = new JLabel("Weapons: ");
		weaponsLabel.setFont(titleFont);
		panel.add(weaponsLabel);
		organizationalSpace = new JLabel(" ");
		organizationalSpace.setFont(new Font("Serif", Font.PLAIN, LARGE_FONT));
		panel.add(organizationalSpace);
		for (Weapons i : Weapons.values()) {
			JRadioButton weaponButton = new JRadioButton(Notepad.getPlayerStorage(playerNumber, index));
			weaponButton.setFont(regularFont);
			panel.add(weaponButton);
			weapons.add(weaponButton);
			index++;
			organizationalSpace = new JLabel(" ");
			organizationalSpace.setFont(new Font("Serif", Font.PLAIN, LARGE_FONT));
			panel.add(organizationalSpace);
		}
		JLabel roomsLabel = new JLabel("Rooms: ");
		roomsLabel.setFont(titleFont);
		panel.add(roomsLabel);
		organizationalSpace = new JLabel(" ");
		organizationalSpace.setFont(new Font("Serif", Font.PLAIN, LARGE_FONT));
		panel.add(organizationalSpace);
		for (Rooms i : Rooms.values()) {
			JRadioButton roomsButton = new JRadioButton(". " + Notepad.getPlayerStorage(playerNumber, index));
			roomsButton.setFont(regularFont);
			panel.add(roomsButton);
			rooms.add(roomsButton);
			index++;
			organizationalSpace = new JLabel(" ");
			organizationalSpace.setFont(new Font("Serif", Font.PLAIN, LARGE_FONT));
			panel.add(organizationalSpace);
		}
		organizationalSpace = new JLabel(" ");
		organizationalSpace.setFont(new Font("Serif", Font.PLAIN, LARGE_FONT));
		panel.add(organizationalSpace);
		Button save = new Button("Save");
		save.setFont(titleFont);
		panel.add(save);
		save.setVisible(true);
		save.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				answers.add(suspects.getSelection().toString());
				answers.add(weapons.getSelection().toString());
				answers.add(rooms.getSelection().toString());
			}
		});
	}

	public ArrayList<String> getAnswers() {
		return answers;
	}
}
