package edu.neumont.teamgift.clue.board.tiles;

import edu.neumont.teamgift.clue.Vector2i;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A room consisting of a set of tiles. Movement in this
 * each room is one to move in and one to move out (acts as single tile).
 */
public class Room {

    /**
     * List of all the tiles that make up a room.
     */
    private final List<Tile> tiles;

    /**
     * Create the container for the room.
     */
    @SuppressWarnings("unused")
    public Room() {
        tiles = new ArrayList<>();
    }

    /**
     * Add a tile that makes up a room.
     *
     * @param t The tile to be added.
     */
    @SuppressWarnings("unused")
    public final void addTile(final Tile t) {
        tiles.add(t);
    }

    /**
     * Get a tile at a specific position.
     *
     * @param position The position of the tile.
     * @return The tile correlating with the given coordinates.
     */
    @SuppressWarnings("unused")
    public final Tile getTile(final Vector2i position) {
        for (Tile i : tiles) {
            if (i.getPosition() == position) {
                return i;
            }
        }
        return null;
    }

    /**
     * Get all tiles of specific type.
     *
     * @param tile The type of tile to look for.
     * @param <T>  A tile class, or sub-class.
     * @return All the tiles that match the type.
     */
    @SuppressWarnings("unused")
    public final <T> T[] getTiles(final Class<? extends Tile> tile) {
        //noinspection unchecked
        return (T[]) tiles.stream().filter(i -> i.getClass() == tile)
                .collect(Collectors.toList()).toArray();
    }

}
