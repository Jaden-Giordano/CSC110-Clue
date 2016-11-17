package edu.neumont.teamgift.clue.board.tiles;

import edu.neumont.teamgift.clue.Vector2i;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Room {

    private List<Tile> tiles;

    public Room() {
        tiles = new ArrayList<>();
    }

    public void addTile(Tile t) {
        tiles.add(t);
    }

    public Tile getTile(Vector2i position) {
        for (Tile i : tiles) {
            if (i.getPosition() == position) {
                return i;
            }
        }
        return null;
    }

    public <T> T[] getTiles(Class<? extends Tile> tile) {
        //noinspection unchecked
        return (T[]) tiles.stream().filter(i -> i.getClass() == tile).collect(Collectors.toList()).toArray();
    }

}
