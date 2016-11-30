package edu.neumont.teamgift.clue.board.tiles;

import edu.neumont.teamgift.clue.Player;
import edu.neumont.teamgift.clue.board.Board;
import edu.neumont.teamgift.clue.board.tiles.interfaces.PlayerContaining;

/**
 * Start tiles.
 */
public class Start extends Tile implements PlayerContaining {

    /**
     * Creates a new tile, with the connected board and the id of the tile.
     *
     * @param parentBoard The board the tile is apart of.
     */
    Start(final Board parentBoard) {
        super(parentBoard, 12);
    }

    @Override
    public final Player getContainingPlayer() {
        for (Player p : getBoard().getPlayers()) {
            if (p.getPosition().compareTo(this.getPosition()) == 0) {
                return p;
            }
        }
        return null;
    }

}
