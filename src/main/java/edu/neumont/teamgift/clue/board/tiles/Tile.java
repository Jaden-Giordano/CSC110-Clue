package edu.neumont.teamgift.clue.board.tiles;

import edu.neumont.teamgift.clue.Vector2i;
import edu.neumont.teamgift.clue.board.Board;

/**
 * A tile of the board, used as movement for players, as well as storage for different objects.
 */
public abstract class Tile implements Comparable<Tile> {

    /**
     * The board the tile is apart of.
     */
    private final Board board;

    /**
     * The id of the tile, used for identifying what type it is.
     */
    private final int id;
    /**
     * The position of the tile on the board.
     */
    private Vector2i position;

    /**
     * Creates a new tile, with the connected board and the id of the tile.
     * @param parentBoard The board the tile is apart of.
     * @param tileID The id used for identification of tile type.
     */
    Tile(final Board parentBoard, final int tileID) {
        this.board = parentBoard;

        this.id = tileID;
        this.position = Vector2i.zero();
    }

    @SuppressWarnings("WeakerAccess")
    public Board getBoard() {
        return this.board;
    }

    @SuppressWarnings({"WeakerAccess", "unused"})
    public int getID() {
        return id;
    }

    @SuppressWarnings("WeakerAccess")
    public Vector2i getPosition() {
        return position;
    }

    @SuppressWarnings({"WeakerAccess", "unused"})
    public void setPosition(final Vector2i newPosition) {
        this.position = newPosition;
    }

    @Override
    public final int compareTo(final Tile o) {
        return position.compareTo(o.position);
    }

}
