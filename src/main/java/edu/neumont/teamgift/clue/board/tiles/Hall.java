package edu.neumont.teamgift.clue.board.tiles;

import edu.neumont.teamgift.clue.board.Board;

/**
 * Hall room.
 */
public class Hall extends RoomTile {

    /**
     * Creates a new tile, with the connected board and the id of the tile.
     *
     * @param parentBoard The board the tile is apart of.
     */
    Hall(final Board parentBoard) {
        super(parentBoard, 3);
    }
}
