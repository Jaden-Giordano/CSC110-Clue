package edu.neumont.teamgift.clue;

import edu.neumont.teamgift.clue.board.Board;
import edu.neumont.teamgift.clue.board.GameMaster;
import edu.neumont.teamgift.clue.board.tiles.Room;
import edu.neumont.teamgift.clue.board.tiles.RoomTile;
import edu.neumont.teamgift.clue.board.tiles.Tile;
import edu.neumont.teamgift.clue.cards.Card;
import edu.neumont.teamgift.clue.cards.Deck;
import edu.neumont.teamgift.clue.front.Sprite;
import edu.neumont.teamgift.clue.front.gui.NotepadGui;

/**
 * A playable character in the game containing information necessary for the
 * player to play.
 */
public class Player {

    /**
     * The id of the player, used for primary identification of player, next to
     * name.
     */
    private final int id;
    /**
     * The name of the in game player.
     */
    private final String name;
    /**
     * The board the player is on.
     */
    @SuppressWarnings("CanBeFinal")
    private Board board;
    /**
     * The cards the player holds.
     */
    private Deck deck;
    /**
     * The position of the player on the board.
     */
    private Vector2i position;
    /**
     * Whether or not the player is able to make moves or play.
     */
    private boolean inGame;
    private boolean winner;
    private NotepadGui notepad;

    /**
     * Sprite for the character.
     */
    private Sprite sprite;

    /**
     * Creates a player initializing its board, the id, and its name.
     *
     * @param parentBoard The board the player is on.
     * @param playerID    The id of the player.
     * @param playerName  The name of the player.
     */
    public Player(final Board parentBoard, final int playerID, final String playerName,
                  GameMaster game) {
        this.board = parentBoard;

        this.id = playerID;
        this.name = playerName;

        this.position = Vector2i.zero();

        inGame = true;
        winner = false;

        deck = new Deck();

        sprite = new Sprite(new Vector3i(255, 255, 255));
    }

    /**
     * Get the players name.
     *
     * @return The name of the player.
     */
    @SuppressWarnings("unused")
    public final String getName() {
        return name;
    }

    /**
     * Get the id of the player.
     *
     * @return The players id.
     */
    @SuppressWarnings("unused")
    public final int getID() {
        return id;
    }

    /**
     * Get the players hand.
     *
     * @return The deck the player holds.
     */
    @SuppressWarnings("unused")
    public final Deck getDeck() {

        return deck;
    }

    public void addToDeck(Card c) {
        deck.add(c);
    }

    /*
     * public void addCard(Card newCard) { cards.add(newCard); }
     */

    /**
     * Get the position of the player.
     *
     * @return The players position.
     */
    public final Vector2i getPosition() {
        return position;
    }

    /**
     * Set the players position.
     *
     * @param newPosition
     *            The new position of the player.
     */
    @SuppressWarnings("unused")
    public final void setPosition(final Vector2i newPosition) {
        position = newPosition;
    }

    /**
     * Get the board the player is on.
     *
     * @return The board the player is on
     */
    @SuppressWarnings("WeakerAccess")
    public final Board getBoard() {
        return this.board;
    }

    /**
     * Attempts to make a move on the board.
     *
     * @param endPosition
     *            The new position to move to.
     * @param maxDistance
     *            The max number of tiles they can travel.
     * @return Returns the amount of tiles it took for that make the move;
     *         Returns -1 if move was not able to be made.
     */
    public final int makeMove(
            @SuppressWarnings("SameParameterValue") final Vector2i endPosition,
            final int maxDistance) {
        Path p = new Path(getBoard(), getPosition(), endPosition, maxDistance);
        if (p.isPossible()) {
            return p.getMoves();
        }
        return -1;
    }

    public NotepadGui getNotepad() {
        return notepad;
    }

    /**
     * Get if the player is in game.
     *
     * @return If the player is in game.
     */
    @SuppressWarnings("unused")
    public final boolean isInGame() {
        return inGame;
    }

    /**
     * Set if the player is in game or not.
     *
     * @param newState
     *            The new state of being in game or not.
     */
    @SuppressWarnings("unused")
    public final void setInGame(final boolean newState) {
        this.inGame = newState;
    }

    public final boolean getWinner() {
        return winner;
    }

    public void setWinner() {
        winner = true;
    }

    /**
     * Set the notepad gui that correlates to the player.
     *
     * @param notepadGUI The notepad gui.
     */
    public void setNotepadGUI(final NotepadGui notepadGUI) {
        this.notepad = notepadGUI;
    }

    /**
     * Get the tile the player is on.
     *
     * @return The tile.
     */
    public Tile getContainingTile() {
        return getBoard().getTile(getPosition());
    }

    /**
     * Get the room the player is in.
     *
     * @return The room the player is in; 'null' if in pathway.
     */
    public Room getRoom() {
        Tile t = getContainingTile();
        if (t instanceof RoomTile) {
            return ((RoomTile) t).getRoom();
        }
        return null;
    }

    /**
     * Teleport the player to a room.
     *
     * @param room The room to teleport to.
     */
    public boolean teleport(final Room room) {
        Tile t = room.getFirstOpenTile();
        if (t == null) {
            return false;
        }

        setPosition(room.getFirstOpenTile().getPosition());

        return true;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(final Sprite s) {
        this.sprite = s;
    }

}
