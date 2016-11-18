package edu.neumont.teamgift.clue;

import edu.neumont.teamgift.clue.board.Board;
import edu.neumont.teamgift.clue.board.tiles.Door;
import edu.neumont.teamgift.clue.board.tiles.Empty;
import edu.neumont.teamgift.clue.board.tiles.Pathway;
import edu.neumont.teamgift.clue.board.tiles.Tile;

/**
 * Registry containing functions for getting tiles based on ids.
 */
public final class TileRegistry {

    /**
     * Tile registry.
     */
    private TileRegistry() {
    }

    /**
     * Get tile based on id.
     *
     * @param b  The board the tile will be on.
     * @param id The id of the tile to add.
     * @return A new tile based on specific id.
     */
    public static Tile getTile(final Board b, final int id) {
        if (id == 1) {
            return new Pathway(b);
        } else if (id == 2) {
            return new Door(b);
        } else {
            return new Empty(b);
        }
    }

}
