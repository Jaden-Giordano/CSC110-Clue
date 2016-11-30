package edu.neumont.teamgift.clue.front;

import edu.neumont.teamgift.clue.board.GameMaster;
import edu.neumont.teamgift.clue.front.gui.ActionMenu;
import edu.neumont.teamgift.clue.front.gui.ActionState;

public class MovementHandler implements Runnable {

    GameMaster gameMaster;
    ActionMenu actionMenu;

    public MovementHandler(final GameMaster gm, final ActionMenu am) {
        this.gameMaster = gm;
        this.actionMenu = am;
    }

    @Override public void run() {
        if (actionMenu.getActionState() == ActionState.Move && actionMenu
                .getActionInProgress()) {
            //gameMaster.handleMovement(actionMenu, MainManager.getInstance()
//                    .getMousePosition());
        }
    }
}
