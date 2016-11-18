package edu.neumont.teamgift.clue;

import edu.neumont.teamgift.clue.board.Board;
import edu.neumont.teamgift.clue.board.tiles.Tile;
import edu.neumont.teamgift.clue.board.tiles.interfaces.PlayerContaining;
import edu.neumont.teamgift.clue.board.tiles.interfaces.Solid;

import java.util.ArrayList;
import java.util.List;

/**
 * Path finding between two points on the board;
 * used to determine if pathway is blocked.
 */
class Path {

    /**
     * A temporary tile created to check for best move.
     */
    private class TileCheck implements Comparable<TileCheck> {

        /**
         * Position on the board.
         */
        private final Vector2i position;

        /**
         * Whether the player can or cannot move through this tile.
         */
        private final boolean blocked;

        /**
         * The distance from the destination point.
         */
        private final int heuristic;
        /**
         * The cost a move would be.
         */
        private final int cost;

        /**
         * The parent tile that this tile was generated from.
         */
        @SuppressWarnings("unused")
        private final TileCheck parent;

        /**
         * Generate a new temporary tile.
         *
         * @param parentTile     The parent tile.
         * @param tilePosition   The position on the board.
         * @param blockedTile    Whether the player can or cannot
         *                       move through this.
         * @param heuristicCount The distance from the end point.
         * @param movementCost   The cost of the movement.
         */
        TileCheck(final TileCheck parentTile, final Vector2i tilePosition,
                  final boolean blockedTile, final int heuristicCount,
                  final int movementCost) {
            this.parent = parentTile;
            this.position = tilePosition;
            this.blocked = blockedTile;
            this.heuristic = heuristicCount;
            this.cost = movementCost;
        }

        /**
         * Get the cost heuristic plus the cost.
         * @return The sum of the heuristic and cost.
         */
        int getCostPlusHeuristic() {
            return heuristic + cost;
        }

        /**
         * Get position of tile on board.
         * @return The position on the board.
         */
        Vector2i getPosition() {
            return position;
        }

        /**
         * Get whether blocked or not.
         *
         * @return Whether blocked or not.
         */
        boolean isBlocked() {
            return blocked;
        }

        @Override
        public int compareTo(final TileCheck o) {
            return position.compareTo(o.position);
        }
    }

    /**
     * The movement cost for a diagonal and horizontal move.
     */
    private static final int HORIZONTAL_COST = 10, DIAGONAL_COST = 20;

    /**
     * The board to find the path on.
     */
    private final Board board;

    /**
     * The start and end point of the path to be generated.
     */
    private final Vector2i startPoint, endPoint;

    /**
     * The best possible moves.
     */
    private final List<TileCheck> closedList;

    /**
     * The possibility of the move on the board.
     */
    private boolean possible;

    /**
     * Create a new path to be checked and created.
     *
     * @param parentBoard The board to check on.
     * @param start       The starting point.
     * @param end         The destination.
     * @param distance    The max distance allowed to travel.
     */
    Path(final Board parentBoard, final Vector2i start,
         final Vector2i end, final int distance) {
        this.board = parentBoard;

        this.startPoint = start;
        this.endPoint = end;

        closedList = new ArrayList<>();

        possible = false;

        if (Vector2i.distance(startPoint, endPoint) <= distance) {
            generatePath(distance);
        }
    }

    /**
     * Generate the path for certain distance.
     *
     * @param distance The maximum distance allowed to travel.
     */
    private void generatePath(final int distance) {
        TileCheck start = new TileCheck(null, startPoint, false,
                Vector2i.distance(startPoint, endPoint), 0);
        closedList.add(start);
        calculateMovementCosts(start);
        for (int i = 0; i < distance && !possible; i++) {
            calculateMovementCosts(closedList.get(i));
        }
    }

    /**
     * Calculates movement cost of all surrounding tiles
     * and chooses the best and moves it to the closed list and then is called
     * again for that square until the end or the max
     * number of moves is reached.
     *
     * @param parent The tile to check all the tiles around.
     */
    private void calculateMovementCosts(final TileCheck parent) {
        TileCheck bestMovement = null;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                try {
                    Tile t = board.getTile(parent.position.sub(
                            new Vector2i(i, j)));
                    int heuristic = Vector2i.distance(t.getPosition(),
                            endPoint);
                    int cost = DIAGONAL_COST;
                    if (i == 0 || j == 0) {
                        cost = HORIZONTAL_COST;
                    }
                    boolean blocked = t instanceof Solid
                            || (t instanceof PlayerContaining
                            && ((PlayerContaining) t)
                            .getContainingPlayer() != null);
                    if (!isClosed(t.getPosition())) {
                        TileCheck open = new TileCheck(parent, t.getPosition(),
                                blocked, heuristic, cost);
                        if (bestMovement == null || open.getCostPlusHeuristic()
                                < bestMovement.getCostPlusHeuristic()
                                && !open.isBlocked()) {
                            bestMovement = open;
                        }
                    }
                } catch (IllegalArgumentException ignored) {
                }
            }
        }
        if (bestMovement != null) {
            closedList.add(bestMovement);
        } else {
            possible = closedList.get(closedList.size() - 1)
                    .getPosition().compareTo(endPoint) != 0;
        }
    }

    /**
     * Get whether a tile is apart of the closed list or not.
     * @param position The position of the tile to be checked.
     * @return Returns whether the tile is apart of the closed list.
     */
    private boolean isClosed(final Vector2i position) {
        return closedList.stream().filter(i -> i.position
                .compareTo(position) == 0).count() > 0;
    }

    /**
     * Returns whether the move is possible or not.
     * @return Whether the move is possible or not.
     */
    boolean isPossible() {
        return possible;
    }

    /**
     * Get the amount of moves it took to get to the end point.
     * @return The amount of tiles moved to get to end point.
     */
    int getMoves() {
        return closedList.size();
    }

}
