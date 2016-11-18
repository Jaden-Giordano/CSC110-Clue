package edu.neumont.teamgift.clue.front;

import edu.neumont.teamgift.clue.Vector2i;

import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSetErrorCallback;
import static org.lwjgl.glfw.GLFW.glfwTerminate;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;

/**
 * Manager for the GUIs and main game loop.
 */
public class FrontEndManager {

    /**
     * Window width and height.
     */
    private static final int WINDOW_WIDTH = 800, WINDOW_HEIGHT = 600;

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
     * Setup and main game loop.
     */
    private void loop() {


        // Run the rendering loop until the user has attempted to close
        // the window or has pressed the ESCAPE key.
        while (!glfwWindowShouldClose(display.getWindow())) {
            display.clear();

            update();
            draw();

            display.swapBuffers();

            // Poll for window events. The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }

    /**
     * The update/tick function called before drawing/rendering.
     */
    @SuppressWarnings("EmptyMethod")
    private void update() {

    }

    /**
     * Draw to the screen.
     */
    @SuppressWarnings("EmptyMethod")
    private void draw() {

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

}
