package edu.neumont.teamgift.clue.board.tiles;

import edu.neumont.teamgift.clue.Player;
import edu.neumont.teamgift.clue.board.Board;
import edu.neumont.teamgift.clue.board.tiles.interfaces.PlayerContaining;

public class Door extends Tile implements PlayerContaining {

    public Door(Board b) {
        super(b, 2);
    }

    @Override
    public Player getContainingPlayer() {
        for (Player p : getBoard().getPlayers()) {
            if (p.getPosition() == this.getPosition())
                return p;
        }
        return null;
    }
}
