package edu.neumont.teamgift.clue.board.tiles;

import edu.neumont.teamgift.clue.SpriteLoader;
import edu.neumont.teamgift.clue.board.Board;
import edu.neumont.teamgift.clue.front.Sprite;

import java.util.HashMap;
import java.util.Map;

/**
 * Registry containing functions for getting tiles based on ids.
 */
public final class TileRegistry {

    /**
     * The storage for all the tiles sprites, to be referenced when needed, so loading
     * only has to occur once.
     */
    private static Map<Integer, Sprite> spriteRegistry;

    /**
     * Blocking constructor for utility class.
     */
    private TileRegistry() {

    }

    /**
     * Tile registry.
     */
    public static void init() {
        spriteRegistry = new HashMap<Integer, Sprite>();
    }

    /**
     * Get tile based on id.
     *
     * @param b  The board the tile will be on.
     * @param id The id of the tile to add.
     * @return A new tile based on specific id.
     */
    public static Tile getTile(final Board b, final int id) {
        if (id == 1) {
            return new Pathway(b);
        } else if (id == 2) {
            return new Door(b);
        } else if (id == 3) {
            return new Hall(b);
        } else if (id == 4) {
            return new Lounge(b);
        } else if (id == 5) {
            return new DiningRoom(b);
        } else if (id == 6) {
            return new Kitchen(b);
        } else if (id == 7) {
            return new Ballroom(b);
        } else if (id == 8) {
            return new Conservatory(b);
        } else if (id == 9) {
            return new BilliardRoom(b);
        } else if (id == 10) {
            return new Library(b);
        } else if (id == 11) {
            return new Study(b);
        } else if (id == 12) {
            return new Start(b);
        } else {
            return new Empty(b);
        }
    }

    /**
     * Get a sprite that corresponds to a tile.
     *
     * @param id The tileID.
     * @return The sprite for the tile.
     */
    public static Sprite getSprite(final int id) {
        if (!spriteRegistry.containsKey(id)) {
            if (id == 1) {
                spriteRegistry.put(id, SpriteLoader
                        .getSprite(SpriteLoader.pathToSprites + "/PathwayTile.png"));
            } else if (id == 2) {
                spriteRegistry.put(id,
                        SpriteLoader.getSprite(SpriteLoader.pathToSprites + "/Door.png"));
            } else if (id >= 3 && id <= 11) {
                spriteRegistry.put(id,
                        SpriteLoader.getSprite(SpriteLoader.pathToSprites + "/Room.png"));
            } else if (id == 12) {
                spriteRegistry.put(id, SpriteLoader.getSprite(SpriteLoader.pathToSprites +
                        "/StartTile"
                        + ".png"));
            } else {
                if (!spriteRegistry.containsKey(id)) {
                    spriteRegistry.put(id, SpriteLoader
                            .getSprite(SpriteLoader.pathToSprites + "/WallTile"
                            + ".png"));
                }
            }
        }

        return spriteRegistry.get(id);
    }

}
