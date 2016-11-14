package edu.neumont.teamgift.clue.board.tiles;

import edu.neumont.teamgift.clue.Vector2i;

public abstract class Tile {

    private int tileID;
    private Vector2i position;

    protected Tile(int tileID) {
        this.tileID = tileID;
        this.position = new Vector2i();
    }

    public int getTileID() {
        return tileID;
    }

    public Vector2i getPosition() {
        return position;
    }

    public void setPosition(Vector2i position) {
        this.position = position;
    }
}
