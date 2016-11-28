package edu.neumont.teamgift.clue.front;

import edu.neumont.teamgift.clue.Vector2i;
import edu.neumont.teamgift.clue.board.GameMaster;
import edu.neumont.teamgift.clue.board.tiles.TileRegistry;

/**
 * The main manager for the game.
 */
public class MainManager extends FrontEndManager {

    /**
     * The game master for the board, players, and dealers.
     */
    private GameMaster gameMaster;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void start() {
        gameMaster = new GameMaster();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void update() {
    }

    /**
     * Renders each tile to the screen.
     */
    private void renderAllTiles() {
        for (int i = 0; i < gameMaster.getBoard().getWidth(); i++) {
            for (int j = 0; j < gameMaster.getBoard().getHeight(); j++) {
                Sprite s = TileRegistry.getSprite(gameMaster.getBoard().getTile(new
                        Vector2i(i, j)).getID());
                if (!s.isColored()) {
                    this.getDisplay().drawSprite(new Vector2i(i * 16, j * 16), s);
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void draw() {
        renderAllTiles();
        //getDisplay().drawSprite(test, TileRegistry.getSprite(1));
    }

}
