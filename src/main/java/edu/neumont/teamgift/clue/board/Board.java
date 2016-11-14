package edu.neumont.teamgift.clue.board;

import edu.neumont.teamgift.clue.TileRegistry;
import edu.neumont.teamgift.clue.board.tiles.Tile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Board {

    private Tile[][] tiles;

    public Board(String path) {
        loadFromFile(path);
    }

    private void loadFromFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String currentLine;
            for (int i = -1; (currentLine = br.readLine()) != null; i++) {
                if (i == -1) {
                    String[] size = currentLine.split(",");
                    tiles = new Tile[Integer.parseInt(size[0])][Integer.parseInt(size[1])];
                    continue;
                }

                String[] sRow = currentLine.split(" ");
                for (int j = 0; j < tiles[i].length; j++) {
                    tiles[i][j] = TileRegistry.getTile(Integer.parseInt(sRow[j]));
                }

            }
        } catch (IOException e) {
            System.out.println("Error loading board file.");
        }
    }

}
