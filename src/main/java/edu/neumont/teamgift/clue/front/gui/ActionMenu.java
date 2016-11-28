package edu.neumont.teamgift.clue.front.gui;

import edu.neumont.teamgift.clue.board.GameMaster;

/**
 * Container for action menu state.
 */
public class ActionMenu {

    /**
     * The game master.
     */
    private final GameMaster gm;

    /**
     * The gui correlating to this action menu.
     */
    private final ActionMenuGUI gui;

    /**
     * The state of the action menu.
     */
    private ActionState state;

    /**
     * Tells if the state if being handled or not.
     */
    private boolean actionInProgress;

    /**
     * Create a new action menu.
     *
     * @param gameMaster The game master.
     */
    public ActionMenu(final GameMaster gameMaster) {
        this.gm = gameMaster;

        this.gui = new ActionMenuGUI();

        state = ActionState.NotSelected;
        actionInProgress = false;
    }


    /**
     * Get the current state of the action menu.
     *
     * @return The state.
     */
    public ActionState getActionState() {
        return state;
    }

    /**
     * Set the state of the action menu. Should be package private because only the
     * action menu gui should call this and change this.
     *
     * @param aState The new state.
     */
    final void setActionState(final ActionState aState) {
        this.state = aState;
    }

    /**
     * State that an action is in progress, so the action cannot be changed until
     * action is finished or cancelled.
     */
    public final void pushActionInProgress() {
        if (state != ActionState.NotSelected) {
            actionInProgress = true;
        }
    }

    /**
     * Complete the action and return the state to not selected.
     */
    public final void completeAction() {
        this.actionInProgress = false;
        this.setActionState(ActionState.NotSelected);
    }

    /**
     * Get if the action is in progress or not.
     *
     * @return If the action is in progress.
     */
    public final boolean getActionInProgress() {
        return actionInProgress;
    }

}
