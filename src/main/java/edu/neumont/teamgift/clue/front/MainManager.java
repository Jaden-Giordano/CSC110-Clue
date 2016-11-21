package edu.neumont.teamgift.clue.front;

import edu.neumont.teamgift.clue.board.GameMaster;

/**
 * The main manager for the game.
 */
public class MainManager extends FrontEndManager {

    /**
     * The game master for the board, players, and dealers.
     */
    private GameMaster gameMaster;

    /**
     * Initialize the game.
     */
    public MainManager() {
        super();
    }

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
     * {@inheritDoc}
     */
    @Override
    protected void draw() {

    }

}
