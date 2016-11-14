package edu.neumont.teamgift.clue;

import edu.neumont.teamgift.clue.board.tiles.Empty;
import edu.neumont.teamgift.clue.board.tiles.Pathway;
import edu.neumont.teamgift.clue.board.tiles.Tile;

public class TileRegistry {

    public static Tile getTile(int id) {
        if (id == 1) {
            return new Pathway();
        } else {
            return new Empty();
        }
    }

}
