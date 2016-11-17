package edu.neumont.teamgift.clue.front.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class NotepadGuiButton implements ActionListener{
	private JButton button;
	
	public NotepadGuiButton (JButton button){
		this.button = button;
	}
    @Override
    public void actionPerformed(ActionEvent e) {
    	if(button.getText().equals("X")){
    		button.setText(" ");
        }
    	else if(button.getText().equals(" ")){
    		button.setText("X");
    	}
    	else{
    		button.setText("X");
    	}
    }
}
