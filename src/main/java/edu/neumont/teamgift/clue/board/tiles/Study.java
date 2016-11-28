package edu.neumont.teamgift.clue.board.tiles;

import edu.neumont.teamgift.clue.board.Board;

/**
 * Study room.
 */
public class Study extends RoomTile {
    /**
     * Creates a new tile, with the connected board and the id of the tile.
     *
     * @param parentBoard The board the tile is apart of.
     */
    Study(final Board parentBoard) {
        super(parentBoard, 11);
    }
}
