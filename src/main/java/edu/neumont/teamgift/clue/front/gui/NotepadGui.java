package edu.neumont.teamgift.clue.front.gui;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotepadGui extends JFrame{
	enum Suspects{
		Colonel_Mustard,
		Professor_Plum,
		Mr_Green,
		Mrs_Peacock,
		Miss_Scarlett,
		Mrs_White
	}
	enum Weapons{
		Knife,
		Candlestick,
		Revolver,
		Rope,
		Lead_Pipe,
		Wrench
	}
	enum Rooms{
		Hall,
		Lounge,
		Dining_Room,
		Kitchen,
		Ballroom,
		Conservatory,
		Billiard_Room,
		Library,
		Study
	}
	public NotepadGui(){
		setUpNotepad();
	}
	
	private void setUpNotepad() {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(700, 3000));
	    add(panel);
		final int COLUMN = 2;
		panel.setLayout(new GridLayout(0, COLUMN));
		JScrollPane notpad = new JScrollPane(panel);
		notpad.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(notpad);
		JLabel suspectsLabel = new JLabel("Suspects: ");
		suspectsLabel.setFont(new Font("Serif", Font.PLAIN, 40));
		panel.add(suspectsLabel);
		JLabel organizationalSpace = new JLabel(" ");
		organizationalSpace.setFont(new Font("Serif", Font.PLAIN, 40));
		panel.add(organizationalSpace);
		for (Suspects i : Suspects.values()) {
			JLabel suspectLabel = new JLabel("" + i);
			suspectLabel.setFont(new Font("Serif", Font.PLAIN, 30));
			panel.add(suspectLabel);
			JButton suspectButton = new JButton("" + i);
			suspectButton.setFont(new Font("Serif", Font.PLAIN, 30));
			suspectButton.addActionListener(new NotepadGuiButton(suspectButton));
			panel.add(suspectButton);
		}
		JLabel weaponsLabel = new JLabel("Weapons: ");
		weaponsLabel.setFont(new Font("Serif", Font.PLAIN, 40));
		panel.add(weaponsLabel);
		organizationalSpace = new JLabel(" ");
		organizationalSpace.setFont(new Font("Serif", Font.PLAIN, 40));
		panel.add(organizationalSpace);
		for (Weapons i : Weapons.values()){
			JLabel weaponLabel = new JLabel("" + i);
			weaponLabel.setFont(new Font("Serif", Font.PLAIN, 30));
			panel.add(weaponLabel);
			JButton weaponButton = new JButton("" + i);
			weaponButton.setFont(new Font("Serif", Font.PLAIN, 30));
			weaponButton.addActionListener(new NotepadGuiButton(weaponButton));
			panel.add(weaponButton);
		}
		JLabel roomsLabel = new JLabel("Rooms: ");
		roomsLabel.setFont(new Font("Serif", Font.PLAIN, 40));
		panel.add(roomsLabel);
		organizationalSpace = new JLabel(" ");
		organizationalSpace.setFont(new Font("Serif", Font.PLAIN, 40));
		panel.add(organizationalSpace);
		for(Rooms i : Rooms.values()){
			JLabel roomLabel = new JLabel("" + i);
			roomLabel.setFont(new Font("Serif", Font.PLAIN, 30));
			panel.add(roomLabel);
			JButton roomsButton = new JButton("" + i);
			roomsButton.setFont(new Font("Serif", Font.PLAIN, 30));
			roomsButton.addActionListener(new NotepadGuiButton(roomsButton));
			panel.add(roomsButton);
		}
		
	}
	public static void main(String[] args) {
	        NotepadGui gui = new NotepadGui();
	        
	        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        gui.setSize(700, 2000);
	        gui.setVisible(true);
	        gui.setTitle("Notepad Gui");
	        
	}
}
