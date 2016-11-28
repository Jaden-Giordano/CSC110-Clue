package edu.neumont.teamgift.clue.board.tiles;

import edu.neumont.teamgift.clue.Vector2i;
import edu.neumont.teamgift.clue.board.Rooms;

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
     * The type of the room.
     */
    private Rooms type;
    /**
     * The type of the room it is connected to via secret passage.
     */
    private Rooms connection;

    /**
     * Create the container for the room.
     *
     * @param roomType The type of the room.
     * @param connectedRoom The room this room is connected to via secret passage.
     */
    @SuppressWarnings("unused")
    public Room(final Rooms roomType, final Rooms connectedRoom) {
        tiles = new ArrayList<>();

        this.type = roomType;
        this.connection = connectedRoom;
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

    /**
     * Gets the rooms type.
     *
     * @return The rooms type.
     */
    public Rooms getType() {
        return type;
    }

    /**
     * Get whether the room has a secret passage to another room or not.
     *
     * @return Whether the room has a secret passage way.
     */
    public boolean hasSecretPassage() {
        return connection != null;
    }

    /**
     * Get the room that it connected to via secret passage way.
     *
     * @return The connected room; returns null if no connection.
     */
    public Rooms getConnectedRoom() {
        return connection;
    }

}
