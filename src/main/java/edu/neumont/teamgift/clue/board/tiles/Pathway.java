package edu.neumont.teamgift.clue.board.tiles;

import edu.neumont.teamgift.clue.Player;
import edu.neumont.teamgift.clue.board.Board;
import edu.neumont.teamgift.clue.board.tiles.interfaces.PlayerContaining;

/**
 * A tile that player's can move through one-by-one.
 */
public class Pathway extends Tile implements PlayerContaining {

    /**
     * A new pathway apart of the board.
     *
     * @param b The board the pathway is connected to.
     */
    public Pathway(final Board b) {
        super(b, 1);
    }

    @Override
    public final Player getContainingPlayer() {
        for (Player p : getBoard().getPlayers()) {
            if (p.getPosition() == this.getPosition())
                return p;
        }
        return null;
    }

}
