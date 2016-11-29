package edu.neumont.teamgift.clue.board.tiles;

import edu.neumont.teamgift.clue.Player;
import edu.neumont.teamgift.clue.board.Board;
import edu.neumont.teamgift.clue.board.tiles.interfaces.PlayerContaining;

/**
 * A room tile.
 */
public class RoomTile extends Tile implements PlayerContaining {

    /**
     * The room the tile is connected to; 'null' if it is a pathway.
     */
    private Room room;

    /**
     * Creates a new tile, with the connected board and the id of the tile.
     *
     * @param parentBoard The board the tile is apart of.
     * @param tileID      The id used for identification of tile type.
     */
    RoomTile(final Board parentBoard, final int tileID) {
        super(parentBoard, tileID);
    }

    /**
     * Get the room the tile is apart of.
     *
     * @return The room.
     */
    public Room getRoom() {
        return this.room;
    }

    /**
     * Set the room the tile is apart of.
     *
     * @param r The room.
     */
    public void setRoom(final Room r) {
        this.room = r;
    }

    @Override
    public final Player getContainingPlayer() {
        for (Player p : getBoard().getPlayers()) {
            if (p.getPosition() == this.getPosition()) {
                return p;
            }
        }
        return null;
    }
}
