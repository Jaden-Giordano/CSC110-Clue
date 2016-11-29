package edu.neumont.teamgift.clue.front.gui;

import edu.neumont.teamgift.clue.board.Die;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionMenuGUI extends JFrame {

    private ActionMenu actionMenu;



    public ActionMenuGUI(ActionMenu am) {
        this.actionMenu = am;

        buildActionMenu();
        createActionButtons();
    }

    private void buildActionMenu() {
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 800);
        this.setVisible(true);
    }

    private void createActionButtons() {
        Font titleFont = new Font("Serif", Font.BOLD, 40);
        setLayout(new GridLayout(0, 1));
        JButton rollForTurn = new JButton("Roll Dice");
        rollForTurn.setFont(titleFont);
        rollForTurn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Die d = new Die();
                int roll = d.rollDie();
                String number = "" + roll;
                rollForTurn.setText(number);
            }
        });
        add(rollForTurn);
        JButton moveForTurn = new JButton("Move");
        moveForTurn.setFont(titleFont);
        moveForTurn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

            }
        });
        add(moveForTurn);
        
        
        JButton beSuspicious = new JButton("Suspicion");
        beSuspicious.setFont(titleFont);
        beSuspicious.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

            }
        });
        add(beSuspicious);
        
        
        JButton objection = new JButton("Make Accusation");
        objection.setFont(titleFont);
        objection.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            	
            }
        });
        add(objection);
        
        
        JButton passTurn = new JButton("End Turn");
        passTurn.setFont(titleFont);
        passTurn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            	//nextTurn();
            	createAwkwardlyLargeGUI(gameMaster.getCurrentPlayer().getId());
            }
        });
        add(passTurn);
        
        
    }
    private void createAwkwardlyLargeGUI(final int playerID){
    	this.setSize(3000, 2000);
    	this.setVisible(true);
    	this.setLayout(new GridLayout(2, 1));
    	JLabel playersTurn = new JLabel("It is now player " + playerID + "s turn");
    	add(playersTurn);
    	JButton turnSwap = new JButton("Continue");
    	turnSwap.addActionListener(new ActionListener(){
    		
    		public void actionPerformed(ActionEvent e){
    			dispose();
    		}
    	});
    	add(turnSwap);
    }
}
