package edu.neumont.teamgift.clue;

//import java.nio.file.Path;

import edu.neumont.teamgift.clue.board.Board;
import edu.neumont.teamgift.clue.cards.Deck;

public class Player {

    private Board board;

    private int id;
    private String name;
    private Deck deck;
    private Vector2i position;
    private boolean inGame = true;

    public boolean getInGame() {
        return inGame;
    }

    public void setInGame() {
        inGame = false;
    }

    public Player(Board board, int id, String name) {
        this.board = board;

        this.id = id;
        this.name = name;

        this.deck = new Deck();
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }

    public Deck getDeck() {
        return deck;
    }

	/*
     * public void addCard(Card newCard) { cards.add(newCard); }
	 */

    public Vector2i getPosition() {
        return position;
    }

    public void setPosition(Vector2i newPosition) {
        position = newPosition;
    }

    public Board getBoard() {
        return this.board;
    }

    /**
     * Attempts to make a move on the board.
     * @param newPosition The new position to move to.
     * @param maxDistance The max number of tiles they can travel.
     * @return Returns the amount of tiles it took for that make the move;
     * Returns -1 if move was not able to be made.
     */
    public int makeMove(Vector2i newPosition, int maxDistance) {
        Path p = new Path(getBoard(), getPosition(), newPosition, maxDistance);
        if (p.isPossible()) {
            return p.getMoves();
        }
        return -1;
    }

}
