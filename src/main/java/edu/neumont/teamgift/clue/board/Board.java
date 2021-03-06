package edu.neumont.teamgift.clue.board;

import edu.neumont.teamgift.clue.Player;
import edu.neumont.teamgift.clue.Vector2i;
import edu.neumont.teamgift.clue.board.tiles.Room;
import edu.neumont.teamgift.clue.board.tiles.RoomTile;
import edu.neumont.teamgift.clue.board.tiles.Tile;
import edu.neumont.teamgift.clue.board.tiles.TileRegistry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The main board of the game containing the players, tiles, and rooms.
 */
public class Board {

    /**
     * List of rooms, which are used for movements.
     */
    @SuppressWarnings({"MismatchedQueryAndUpdateOfCollection", "FieldCanBeLocal",
            "unused"})
    private final Map<Integer, Room> rooms;
    /**
     * All the players, currently active on the board.
     */
    private final List<Player> players;
    /**
     * Reference to the game master.
     */
    private final GameMaster gameMaster;
    /**
     * The width and height of the board in tiles.
     */
    private int width, height;
    /**
     * Each tile on the board.
     */
    private Tile[][] tiles;

    /**
     * Creation of the board: population of tiles, rooms, and players.
     *
     * @param gm The game master.
     * @param path The filepath to the board file, containing a 2D map of tile
     *             ids.
     */
    @SuppressWarnings("unused")
    public Board(final GameMaster gm, final String path) {
        this.gameMaster = gm;

        rooms = new HashMap<Integer, Room>();
        populateRooms();

        players = new ArrayList<>();

        loadFromFile(path + "/defaultboard.clueboard");
    }

    /**
     * Create each empty room and store into list.
     */
    private void populateRooms() {
        final int idOffset = 2;
        for (Rooms i : Rooms.values()) {
            Rooms connection = null;
            if (i == Rooms.Lounge) {
                connection = Rooms.Conservatory;
            } else if (i == Rooms.Conservatory) {
                connection = Rooms.Lounge;
            } else if (i == Rooms.Study) {
                connection = Rooms.Kitchen;
            } else if (i == Rooms.Kitchen) {
                connection = Rooms.Study;
            }
            rooms.put(i.ordinal() + idOffset, new Room(i, connection));
        }
    }

    /**
     * Populates the tiles from a file.
     *
     * @param path The filepath to the board file, containing a 2D map of tile
     *             ids.
     */
    private void loadFromFile(final String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String currentLine;
            for (int i = -1; true; i++) {
                currentLine = br.readLine();
                if (currentLine == null) {
                    break;
                }

                if (i == -1) {
                    String[] size = currentLine.split(",");
                    width = Integer.parseInt(size[0]);
                    height = Integer.parseInt(size[1]);
                    tiles = new Tile[height][width];
                    continue;
                }

                String[] sRow = currentLine.split(" ");
                for (int j = 0; j < tiles[i].length; j++) {
                    tiles[i][j] = TileRegistry.getTile(this, Integer.parseInt(sRow[j]));
                    tiles[i][j].setPosition(new Vector2i(j, i));
                    if (rooms.containsKey(tiles[i][j].getID())) {
                        Room r = rooms.get(tiles[i][j].getID());
                        r.addTile(tiles[i][j]);
                        if (tiles[i][j] instanceof RoomTile) {
                            ((RoomTile) tiles[i][j]).setRoom(r);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading board file: " + e.getMessage());
        }
    }

    /**
     * @return Returns all the players active on the board.
     */
    public final Player[] getPlayers() {
        Player[] arr = new Player[players.size()];
        arr = players.toArray(arr);
        return arr;
    }

    /**
     * Adds a player to the board.
     *
     * @param p The player.
     */
    @SuppressWarnings("unused")
    public final void addPlayer(final Player p) {
        this.players.add(p);
    }

    /**
     * Gets a tile at a specific location on the board.
     *
     * @param position The position of the tile on the board.
     * @return Returns the tile corresponding to the position specified.
     */
    public final Tile getTile(final Vector2i position) {
        if ((position.x < 0 || position.x >= height) || (position.y < 0
                || position.y >= height)) {
            throw new IllegalArgumentException(
                    "The tile (" + position.x + "," + position.y + ") you are looking "
                            + "for "
                            + "doesn't exist; it is out of the bounds of the board.");
        }

        return tiles[position.y][position.x];
    }

    public final Tile[] getTiles(final Class<? extends Tile> type) {
        List<Tile> matchingTiles = new ArrayList<>();
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if (tiles[i][j].getClass().isAssignableFrom(type)) {
                    matchingTiles.add(tiles[i][j]);
                }
            }
        }

        Tile[] arr = new Tile[matchingTiles.size()];
        arr = matchingTiles.toArray(arr);
        return arr;
    }

    /**
     * Get the width of the board in tiles.
     *
     * @return The width.
     */
    public final int getWidth() {
        return width;
    }

    /**
     * Get the height of the board in tiles.
     *
     * @return The height.
     */
    public final int getHeight() {
        return height;
    }

    /**
     * Get a room by type.
     *
     * @param room The type of the room.
     * @return The room specific by type.
     */
    public Room getRoom(final Rooms room) {
        return (Room) rooms.values().stream().filter(i -> i.getType() == room).collect(
                Collectors.toList()).toArray()[0];
    }

}
