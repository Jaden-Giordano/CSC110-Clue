package edu.neumont.teamgift.clue;

import java.util.Random;

public class Die {
	public int rollDie(){
		Random r = new Random();
		return (r.nextInt(6) + 1) + (r.nextInt(6) + 1);
	}
}
