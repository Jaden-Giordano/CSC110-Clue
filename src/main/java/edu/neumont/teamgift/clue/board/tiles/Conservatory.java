package edu.neumont.teamgift.clue.board.tiles;

import edu.neumont.teamgift.clue.board.Board;

/**
 * Conservatory room.
 */
public class Conservatory extends RoomTile {
    /**
     * Creates a new tile, with the connected board and the id of the tile.
     *
     * @param parentBoard The board the tile is apart of.
     */
    Conservatory(final Board parentBoard) {
        super(parentBoard, 8);
    }
}
