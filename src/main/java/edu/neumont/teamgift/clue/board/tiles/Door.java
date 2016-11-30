package edu.neumont.teamgift.clue.board.tiles;

import edu.neumont.teamgift.clue.Player;
import edu.neumont.teamgift.clue.board.Board;
import edu.neumont.teamgift.clue.board.tiles.interfaces.PlayerContaining;

/**
 * A door tile, that connects a pathway to a room.
 */
public class Door extends Tile implements PlayerContaining {

    /**
     * Creates a new door apart of board.
     *
     * @param b The board the door is connected to.
     */
    @SuppressWarnings("unused") Door(final Board b) {
        super(b, 2);
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
