package edu.neumont.teamgift.clue;

import edu.neumont.teamgift.clue.board.Board;
import edu.neumont.teamgift.clue.board.tiles.Tile;
import edu.neumont.teamgift.clue.board.tiles.interfaces.PlayerContaining;
import edu.neumont.teamgift.clue.board.tiles.interfaces.Solid;

import java.util.ArrayList;
import java.util.List;

class Path {

    private class TileCheck implements Comparable<TileCheck> {

        private Vector2i position;

        boolean blocked;

        int heuristic;
        int cost;

        TileCheck parent;

        TileCheck(TileCheck parent, Vector2i position, boolean blocked, int heuristic, int cost) {
            this.parent = parent;
            this.position = position;
            this.blocked = blocked;
            this.heuristic = heuristic;
            this.cost = cost;
        }

        int getCostPlusHeuristic() {
            return heuristic+cost;
        }

        Vector2i getPosition() {
            return position;
        }

        @Override
        public int compareTo(TileCheck o) {
            return position.compareTo(o.position);
        }
    }

    private Board board;

    private Vector2i startPoint, endPoint;

    private List<TileCheck> closedList;

    private boolean possible;

    Path(Board board, Vector2i startPoint, Vector2i endPoint, int distance) {
        this.board = board;

        this.startPoint = startPoint;
        this.endPoint = endPoint;

        closedList = new ArrayList<>();

        possible = false;

        if (Vector2i.distance(startPoint, endPoint) <= distance)
            generatePath(distance);
    }

    private void generatePath(int distance) {
        TileCheck start = new TileCheck(null, startPoint, false, Vector2i.distance(startPoint, endPoint), 0);
        closedList.add(start);
        calculateMovementCosts(start);
        for (int i = 0; i < distance && !possible; i++) {
            calculateMovementCosts(closedList.get(i));
        }
    }

    private void calculateMovementCosts(TileCheck parent) {
        TileCheck bestMovement = null;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                try {
                    Tile t = board.getTile(parent.position.sub(new Vector2i(i, j)));
                    int heuristic = Vector2i.distance(t.getPosition(), endPoint);
                    int cost = (i == 0 || j == 0)?10:20;
                    boolean blocked = t instanceof Solid || (t instanceof PlayerContaining && ((PlayerContaining) t).getContainingPlayer() != null);
                    if (!isClosed(t.getPosition())) {
                        TileCheck open = new TileCheck(parent, t.getPosition(), blocked, heuristic, cost);
                        if (bestMovement == null || open.getCostPlusHeuristic() < bestMovement.getCostPlusHeuristic())
                            bestMovement = open;
                    }
                } catch (IllegalArgumentException ignored) {}
            }
        }
        if (bestMovement != null)
            closedList.add(bestMovement);
        else
            possible = closedList.get(closedList.size()-1).getPosition().compareTo(endPoint) != 0;
    }

    private boolean isClosed(Vector2i position) {
        return closedList.stream().filter(i -> i.position.compareTo(position) == 0).count() > 0;
    }

    boolean isPossible() {
        return possible;
    }

    int getMoves() {
        return closedList.size();
    }

}
