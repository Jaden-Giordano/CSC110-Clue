package edu.neumont.teamgift.clue.front;

import edu.neumont.teamgift.clue.Player;
import edu.neumont.teamgift.clue.Vector2i;
import edu.neumont.teamgift.clue.board.GameMaster;
import edu.neumont.teamgift.clue.board.tiles.TileRegistry;
import edu.neumont.teamgift.clue.front.gui.GetNumPlayersGUI;

/**
 * The main manager for the game.
 */
public class MainManager extends FrontEndManager {

    /**
     * The game master for the board, players, and dealers.
     */
    private GameMaster gameMaster;

    private volatile int amountOfPlayers;

    public MainManager() {
        super();
    }

    @Override
    protected void superSecretInitialization() {
        new GetNumPlayersGUI().launchNumbPlayers(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void start() {
        super.start();
        gameMaster = new GameMaster();
        gameMaster.setNumPlayers(amountOfPlayers);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void update() {
        super.update();
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
     * Renders all players to the screen.
     */
    private void renderAllPlayers() {
        for (int i = 0; i < gameMaster.getNumPlayers(); i++) {
            Player p = gameMaster.getPlayer(i);
            this.getDisplay().drawSprite(new Vector2i(p.getPosition().x * 16,
                    p.getPosition().y * 16), gameMaster.getPlayer(i).getSprite());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void draw() {
        super.draw();
        renderAllPlayers();
        renderAllTiles();
        //getDisplay().drawSprite(test, TileRegistry.getSprite(1));
    }

    public void createGameMaster(final int amountOfPlayers) {
        this.canRun = true;
        this.amountOfPlayers = amountOfPlayers;
    }

}
