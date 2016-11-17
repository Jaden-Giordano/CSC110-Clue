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

public class Board {

    private int width, height;

    private Tile[][] tiles;
    private List<Room> rooms;

    private List<Player> players;

    public Board(String path) {
        rooms = new ArrayList<>();
        players = new ArrayList<>();

        loadFromFile(path);
    }

    private void loadFromFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String currentLine;
            for (int i = -1; (currentLine = br.readLine()) != null; i++) {
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

    public Player[] getPlayers() {
        return (Player[]) players.toArray();
    }

    public void addPlayer(String name) {
        this.players.add(new Player(this, players.size(), name));
    }

    public Tile getTile(Vector2i position) {
        if ((position.x < 0 || position.x >= height) || (position.y < 0 || position.y >= width))
            throw new IllegalArgumentException("The tile you are looking for doesn't exist; it is out of the bounds of the board.");

        return tiles[position.y][position.x];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
