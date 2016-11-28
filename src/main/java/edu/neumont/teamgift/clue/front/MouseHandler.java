package edu.neumont.teamgift.clue.front;

import org.lwjgl.glfw.GLFWMouseButtonCallback;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Handler for all mouse input and callbacks.
 */
public class MouseHandler extends GLFWMouseButtonCallback {

    /**
     * Singleton instance.
     */
    private static MouseHandler myInstance;
    /**
     * List of callbacks for input.
     */
    private List<CallbackContainer> callbacks;

    /**
     * Create singleton and mouse handler instance.
     */
    public MouseHandler() {
        myInstance = this;

        callbacks = new ArrayList<>();
    }

    /**
     * Get the singleton instance.
     *
     * @return The instance.
     */
    public static MouseHandler getInstance() {
        return myInstance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void invoke(final long window, final int button, final int action, final int
            mods) {
        callbacks.stream().filter(i -> i.action == action && i.button == button).collect(
                Collectors.toList())
                .forEach((callbackContainer) -> callbackContainer.callback.run());
    }

    /**
     * Register a callback to be called when a mouse action is completed.
     *
     * @param button   The button.
     * @param action   The action.
     * @param callback The callback.
     */
    public void registerCallback(final int button, final int action, final Runnable
            callback) {
        callbacks.add(new CallbackContainer(button, action, callback));
    }

    @SuppressWarnings("CheckStyle")
    private class CallbackContainer {

        /**
         * The button used.
         */
        final int button;

        /**
         * The action of the event.
         */
        final int action;

        /**
         * The callback.
         */
        final Runnable callback;

        /**
         * Create a callback container.
         *
         * @param b  The button.
         * @param a  The action.
         * @param cb The callback.
         */
        CallbackContainer(final int b, final int a, final Runnable cb) {
            this.button = b;
            this.action = a;
            this.callback = cb;
        }

    }

}
