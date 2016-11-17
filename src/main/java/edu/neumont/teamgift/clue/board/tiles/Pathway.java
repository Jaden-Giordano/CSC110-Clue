package edu.neumont.teamgift.clue.board.tiles;

import edu.neumont.teamgift.clue.Player;
import edu.neumont.teamgift.clue.board.Board;
import edu.neumont.teamgift.clue.board.tiles.interfaces.PlayerContaining;

public class Pathway extends Tile implements PlayerContaining {

    public Pathway(Board b) {
        super(b, 1);
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
