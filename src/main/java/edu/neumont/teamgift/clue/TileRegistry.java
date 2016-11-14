package edu.neumont.teamgift.clue;

import edu.neumont.teamgift.clue.board.Board;
import edu.neumont.teamgift.clue.board.tiles.Door;
import edu.neumont.teamgift.clue.board.tiles.Empty;
import edu.neumont.teamgift.clue.board.tiles.Pathway;
import edu.neumont.teamgift.clue.board.tiles.Tile;

public class TileRegistry {

    public static Tile getTile(Board b, int id) {
        if (id == 1) {
            return new Pathway(b);
        } else if (id == 2) {
            return new Door(b);
        } else {
            return new Empty(b);
        }
    }

}
