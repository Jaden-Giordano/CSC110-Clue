package edu.neumont.teamgift.clue.front.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class ActionMenuGUI extends JFrame {

    public ActionMenuGUI() {
        buildActionMenu();
    }

    private void buildActionMenu() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1440, 2200);
        this.setVisible(true);
    }

    private void createActionButtons() {
        setLayout(new GridLayout(0, 1));
        JButton rollForTurn = new JButton("Roll Dice");
//        rollForTurn.addActionListener();
        add(rollForTurn);
        JButton moveForTurn = new JButton("Move");
//        moveForTurn.addActionListener();
        add(moveForTurn);
        JButton beSuspicious = new JButton("Suspicion");
//        beSuspicious.addActionListener();
        add(beSuspicious);
        JButton objection = new JButton("Make Accusation");
//        objection.addActionListener();
        add(objection);
        JButton passTurn = new JButton("End Turn");
//        passTurn.addActionListener();
        add(passTurn);
    }
}
