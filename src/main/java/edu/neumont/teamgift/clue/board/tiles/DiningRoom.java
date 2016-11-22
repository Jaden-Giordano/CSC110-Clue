package edu.neumont.teamgift.clue.board.tiles;

import edu.neumont.teamgift.clue.board.Board;

/**
 * Dining room.
 */
public class DiningRoom extends Tile {
    /**
     * Creates a new tile, with the connected board and the id of the tile.
     *
     * @param parentBoard The board the tile is apart of.
     */
    DiningRoom(final Board parentBoard) {
        super(parentBoard, 5);
    }
}
