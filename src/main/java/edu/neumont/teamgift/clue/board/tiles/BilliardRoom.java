package edu.neumont.teamgift.clue.board.tiles;

import edu.neumont.teamgift.clue.board.Board;

/**
 * Billiard room.
 */
public class BilliardRoom extends Tile {
    /**
     * Creates a new tile, with the connected board and the id of the tile.
     *
     * @param parentBoard The board the tile is apart of.
     */
    BilliardRoom(final Board parentBoard) {
        super(parentBoard, 9);
    }
}
