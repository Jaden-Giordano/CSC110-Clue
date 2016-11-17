package edu.neumont.teamgift.clue.front.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import edu.neumont.teamgift.clue.Notepad;

public class NotepadGuiButton implements ActionListener{
	private JButton button;
	private Notepad notepad;
	private int index;
	
	public NotepadGuiButton (JButton button, int index){
	this.index = index;
	this.button = button;
	Notepad notepad = new Notepad();
		
	}
    @Override
    public void actionPerformed(ActionEvent e) {
    	String buttonEnum = findEnum(button.getText());
    	String buttonValue;
    	if(button.getText().equals("X")){
    		buttonValue = " ";
    		button.setText(buttonValue);
    		changeValue(buttonEnum, this.index, buttonValue);
        }
    	else if(button.getText().equals(" ")){
    		buttonValue = "X";
    		button.setText(buttonValue);
    		changeValue(buttonEnum, this.index, buttonValue);
    	}
    	else{
    		buttonValue = "X";
    		button.setText(buttonValue);
    		changeValue(buttonEnum, this.index, buttonValue);
    	}
    	
    }
    
    private String findEnum(String buttonContents){
    	if(!buttonContents.equals(Weapons.values()) && !buttonContents.equals(Rooms.values())){
    		return "Suspects";
    	}
    	else if(!buttonContents.equals(Suspects.values()) && !buttonContents.equals(Rooms.values())){
    		return "Weapons";
    	}
    	else if(!buttonContents.equals(Weapons.values()) && !buttonContents.equals(Suspects.values())){
    		return "Rooms";
    	}
    	return null;
    }
    private static void changeValue(String enumValue, int index, String buttonValue){
    	Notepad notepad = new Notepad();
    	if(enumValue.equals("Suspects")){
    		notepad.setSuspect(index, buttonValue);
    	}
    	else if(enumValue.equals("Weapons")){
    		notepad.setWeapon(index, buttonValue);
    	}
    	else if(enumValue.equals("Rooms")){
    		notepad.setRoom(index, buttonValue);
    	}
    }
}
