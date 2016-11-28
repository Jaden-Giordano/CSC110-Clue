package edu.neumont.teamgift.clue.board.tiles;

import edu.neumont.teamgift.clue.board.Board;

/**
 * Kitchen room.
 */
public class Kitchen extends RoomTile {
    /**
     * Creates a new tile, with the connected board and the id of the tile.
     *
     * @param parentBoard The board the tile is apart of.
     */
    Kitchen(final Board parentBoard) {
        super(parentBoard, 6);
    }
}
