package edu.neumont.teamgift.clue.board.tiles.interfaces;

import edu.neumont.teamgift.clue.Player;

/**
 * Tile that can contain a player.
 */
public interface PlayerContaining {
    /**
     * Get a player that may be on the tile.
     *
     * @return The player, if a player is on top of the tile.
     */
    Player getContainingPlayer();
}
