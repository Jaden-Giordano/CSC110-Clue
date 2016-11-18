package edu.neumont.teamgift.clue.board.tiles;

import edu.neumont.teamgift.clue.board.Board;

/**
 * An empty tile that players cannot move through and are not displayed.
 */
public class Empty extends Tile {

    /**
     * Create a new empty apart of board.
     *
     * @param b The board the empty tile is connected to.
     */
    public Empty(final Board b) {
        super(b, 0);
    }

}
