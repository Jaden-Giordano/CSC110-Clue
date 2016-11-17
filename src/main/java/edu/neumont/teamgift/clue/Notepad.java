package edu.neumont.teamgift.clue;

public class Notepad {
	
	private String[] suspects;
	private String[] weapons;
	private String[] rooms;
	
	public Notepad() {
		suspects = new String[6];
		weapons = new String[6];
		rooms = new String[9];
	}
	
	public void setWeapon(int index, String value) {
		weapons[index] = value;
	}
	
	public String getWeapon(int index) {
		return weapons[index];
	}
	
	public void setSuspect(int index, String value){
		suspects[index] = value;
	}
	
	public String getSuspect(int index){
		return suspects[index];
	}
	
	public void setRoom(int index, String value){
		rooms[index] = value;
	}
	public String getRoom(int index){
		return rooms[index];
	}

}
