package edu.neumont.teamgift.clue.board.tiles;

import edu.neumont.teamgift.clue.board.Board;
import edu.neumont.teamgift.clue.front.Sprite;

import java.util.HashMap;
import java.util.Map;

/**
 * Registry containing functions for getting tiles based on ids.
 */
public final class TileRegistry {

    /**
     * The path of the sprite folder in the project directory.
     */
    private static String spritePath;

    /**
     * The storage for all the tiles sprites, to be referenced when needed, so loading
     * only has to occur once.
     */
    private static Map<Integer, Sprite> spriteRegistry;

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
        if (id == 1) {
            if (!spriteRegistry.containsKey(id)) {
                // TODO actually load sprites
                spriteRegistry.put(id, new Sprite(spritePath + "/PathwayTile.png"));
                //return new Sprite(spritePath + "/PathwayTile.png");
            }
        } else {
            if (!spriteRegistry.containsKey(id)) {
                spriteRegistry.put(id, new Sprite(spritePath + "/WallTile"
                        + ".png"));
            }
        }

        return spriteRegistry.get(id);
    }

    /**
     * Set the path of the sprites in the project directory.
     *
     * @param path The path to the sprites.
     */
    public static void setSpritePath(final String path) {
        spritePath = path;
    }

}
