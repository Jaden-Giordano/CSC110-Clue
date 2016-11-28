package edu.neumont.teamgift.clue.board.tiles;

import edu.neumont.teamgift.clue.board.Board;

/**
 * Library room.
 */
public class Library extends RoomTile {
    /**
     * Creates a new tile, with the connected board and the id of the tile.
     *
     * @param parentBoard The board the tile is apart of.
     */
    Library(final Board parentBoard) {
        super(parentBoard, 10);
    }
}
