package edu.neumont.teamgift.clue.board.tiles;

import edu.neumont.teamgift.clue.Vector2i;
import edu.neumont.teamgift.clue.board.Board;

public abstract class Tile implements Comparable<Tile> {

    private Board board;

    private int ID;
    private Vector2i position;

    Tile(Board board, int ID) {
        this.board = board;

        this.ID = ID;
        this.position = Vector2i.zero();
    }

    @SuppressWarnings("WeakerAccess")
    public Board getBoard() {
        return this.board;
    }

    @SuppressWarnings("WeakerAccess")
    public int getID() {
        return ID;
    }

    @SuppressWarnings("WeakerAccess")
    public Vector2i getPosition() {
        return position;
    }

    @SuppressWarnings("WeakerAccess")
    public void setPosition(Vector2i position) {
        this.position = position;
    }

    @Override
    public int compareTo(Tile o) {
        return position.compareTo(o.position);
    }

}
