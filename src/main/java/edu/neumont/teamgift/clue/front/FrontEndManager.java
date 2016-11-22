package edu.neumont.teamgift.clue.front;

import edu.neumont.teamgift.clue.Vector2i;

import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSetErrorCallback;
import static org.lwjgl.glfw.GLFW.glfwTerminate;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;

/**
 * Manager for the GUIs and main game loop.
 */
public abstract class FrontEndManager {

    /**
     * Window width and height.
     */
    private static final int WINDOW_WIDTH = 2 * (24 * 16), WINDOW_HEIGHT = 2 * (24 * 16);

    /**
     * Singleton instance.
     */
    private static FrontEndManager myInstance;

    /**
     * LWJGL window.
     */
    private Display display;

    /**
     * Create singleton and display.
     */
    @SuppressWarnings("unused")
    public FrontEndManager() {
        myInstance = this;

        try {
            display = new Display(new Vector2i(WINDOW_WIDTH, WINDOW_HEIGHT));

            loop();

            // Free the window callbacks and destroy the window
            display.destroy();
        } finally {
            // Terminate GLFW and free the error callback
            glfwTerminate();
            glfwSetErrorCallback(null).free();
        }
    }

    /**
     * Get singleton instance.
     *
     * @return The instance of the class.
     */
    @SuppressWarnings("unused")
    public static FrontEndManager getInstance() {
        return myInstance;
    }

    /**
     * Setup and main game loop.
     */
    private void loop() {

        start();

        // Run the rendering loop until the user has attempted to close
        // the window or has pressed the ESCAPE key.
        while (!glfwWindowShouldClose(display.getWindow())) {
            update();

            display.clear();

            draw();

            display.swapBuffers();

            // Poll for window events. The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }

    /**
     * The start of the program; used for initializations.
     */
    @SuppressWarnings("EmptyMethod")
    protected void start() {

    }

    /**
     * The update/tick function called before drawing/rendering.
     */
    @SuppressWarnings("EmptyMethod")
    protected void update() {

    }

    /**
     * Draw to the screen.
     */
    @SuppressWarnings("EmptyMethod")
    protected void draw() {

    }

    /**
     * Get the display.
     *
     * @return The display.
     */
    protected final Display getDisplay() {
        return display;
    }

}
