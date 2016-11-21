package edu.neumont.teamgift.clue.board;

import edu.neumont.teamgift.clue.Player;
import edu.neumont.teamgift.clue.TileRegistry;
import edu.neumont.teamgift.clue.Vector2i;
import edu.neumont.teamgift.clue.board.tiles.Room;
import edu.neumont.teamgift.clue.board.tiles.Tile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The main board of the game containing the players, tiles, and rooms.
 */
public class Board {

    /**
     * List of rooms, which are used for movements.
     */
    @SuppressWarnings({"MismatchedQueryAndUpdateOfCollection", "FieldCanBeLocal",
            "unused"})
    private final List<Room> rooms;
    /**
     * All the players, currently active on the board.
     */
    private final List<Player> players;
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
     * @param path The filepath to the board file, containing a 2D map of tile
     *             ids.
     */
    @SuppressWarnings("unused")
    public Board(final String path) {
        rooms = new ArrayList<>();
        players = new ArrayList<>();

        loadFromFile(path);
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
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading board file.");
        }
    }

    /**
     * @return Returns all the players active on the board.
     */
    public final Player[] getPlayers() {
        return (Player[]) players.toArray();
    }

    /**
     * Adds a player to the board, generating an id, and setting the name.
     *
     * @param name The name of the new player.
     */
    @SuppressWarnings("unused")
    public final void addPlayer(final String name) {
        // TODO make sure this code will work
        this.players.add(new Player(this, players.size(), name));
    }

    /**
     * Gets a tile at a specific location on the board.
     *
     * @param position The position of the tile on the board.
     * @return Returns the tile corresponding to the position specified.
     */
    public final Tile getTile(final Vector2i position) {
        if ((position.x < 0 || position.x >= height) || (position.y < 0
                || position.y >= width)) {
            throw new IllegalArgumentException(
                    "The tile you are looking for "
                            + "doesn't exist; it is out of the bounds of the board.");
        }

        return tiles[position.y][position.x];
    }

}
