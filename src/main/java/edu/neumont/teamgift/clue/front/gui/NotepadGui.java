package edu.neumont.teamgift.clue.front.gui;

import edu.neumont.teamgift.clue.Notepad;

import javax.swing.*;
import java.awt.*;

public class NotepadGui extends JFrame{
    enum Suspects {
        Colonel_Mustard,
        Professor_Plum,
        Mr_Green,
        Mrs_Peacock,
        Miss_Scarlett,
        Mrs_White
    }

    enum Weapons {
        Knife,
        Candlestick,
        Revolver,
        Rope,
        Lead_Pipe,
        Wrench
    }

    enum Rooms {
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

    private NotepadGui() {
        setUpNotepad();
    }

    private void setUpNotepad() {
        Notepad notepad = new Notepad();
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(700, 3000));
        add(panel);
        final int column = 2;
        panel.setLayout(new GridLayout(0, column));
        JScrollPane jNotepad = new JScrollPane(panel);
        jNotepad.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(jNotepad);
        JLabel suspectsLabel = new JLabel("Suspects: ");
        suspectsLabel.setFont(new Font("Serif", Font.PLAIN, 40));
        panel.add(suspectsLabel);
        JLabel organizationalSpace = new JLabel(" ");
        organizationalSpace.setFont(new Font("Serif", Font.PLAIN, 40));
        panel.add(organizationalSpace);
        //JButton difWindow = new JButton("open new");
        //difWindow.addActionListener(new NewWindowButton(difWindow));
        int suspectIndex = 0;
        for (Suspects i : Suspects.values()) {
            JLabel suspectLabel = new JLabel("" + i);
            suspectLabel.setFont(new Font("Serif", Font.PLAIN, 30));
            panel.add(suspectLabel);
            notepad.setSuspect(suspectIndex, i.name());
            JButton suspectButton = new JButton(notepad.getSuspect(suspectIndex));
            suspectButton.setFont(new Font("Serif", Font.PLAIN, 30));
            suspectButton.addActionListener(new NotepadGuiButton(suspectButton, suspectIndex));
            panel.add(suspectButton);
            suspectIndex++;
        }
        JLabel weaponsLabel = new JLabel("Weapons: ");
        weaponsLabel.setFont(new Font("Serif", Font.PLAIN, 40));
        panel.add(weaponsLabel);
        organizationalSpace = new JLabel(" ");
        organizationalSpace.setFont(new Font("Serif", Font.PLAIN, 40));
        panel.add(organizationalSpace);
        int weaponIndex = 0;
        for (Weapons i : Weapons.values()) {
            JLabel weaponLabel = new JLabel("" + i);
            weaponLabel.setFont(new Font("Serif", Font.PLAIN, 30));
            panel.add(weaponLabel);
            notepad.setWeapon(weaponIndex, i.name());
            JButton weaponButton = new JButton(notepad.getWeapon(weaponIndex));
            weaponButton.setFont(new Font("Serif", Font.PLAIN, 30));
            weaponButton.addActionListener(new NotepadGuiButton(weaponButton, weaponIndex));
            panel.add(weaponButton);
            weaponIndex++;
        }
        JLabel roomsLabel = new JLabel("Rooms: ");
        roomsLabel.setFont(new Font("Serif", Font.PLAIN, 40));
        panel.add(roomsLabel);
        organizationalSpace = new JLabel(" ");
        organizationalSpace.setFont(new Font("Serif", Font.PLAIN, 40));
        panel.add(organizationalSpace);
        int roomsIndex = 0;
        for (Rooms i : Rooms.values()) {
            JLabel roomLabel = new JLabel("" + i);
            roomLabel.setFont(new Font("Serif", Font.PLAIN, 30));
            panel.add(roomLabel);
            notepad.setRoom(roomsIndex, i.name());
            JButton roomsButton = new JButton((roomsIndex + 1) + ". " + notepad.getRoom(roomsIndex));
            roomsButton.setFont(new Font("Serif", Font.PLAIN, 30));
            roomsButton.addActionListener(new NotepadGuiButton(roomsButton, roomsIndex));
            panel.add(roomsButton);
            roomsIndex++;
        }


    }

    public static void main(String[] args) {
        NotepadGui gui = new NotepadGui();

        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gui.setSize(700, 2000);
        gui.setVisible(true);
        gui.setTitle("Notepad Gui");

    }
}

