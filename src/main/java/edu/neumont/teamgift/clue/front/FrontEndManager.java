package edu.neumont.teamgift.clue.front;

import edu.neumont.teamgift.clue.Vector2i;
import edu.neumont.teamgift.clue.interfaces.Updatable;
import org.lwjgl.BufferUtils;

import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_ESCAPE;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;
import static org.lwjgl.glfw.GLFW.glfwGetCursorPos;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSetErrorCallback;
import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;
import static org.lwjgl.glfw.GLFW.glfwSetWindowShouldClose;
import static org.lwjgl.glfw.GLFW.glfwTerminate;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;

/**
 * Manager for the GUIs and main game loop.
 */
public abstract class FrontEndManager {

    /**
     * Window width and height.
     */
    private static final int WINDOW_WIDTH = 3 * (24 * 16), WINDOW_HEIGHT = 3 * (25 * 16);

    /**
     * Singleton instance.
     */
    private static FrontEndManager myInstance;

    /**
     * LWJGL window.
     */
    private Display display;

    /**
     * List of updatable components.
     */
    private List<Updatable> updatables;

    /**
     * Create singleton and display.
     */
    @SuppressWarnings("unused")
    public FrontEndManager() {
        myInstance = this;

        updatables = new ArrayList<>();

        try {
            display = new Display(new Vector2i(WINDOW_WIDTH, WINDOW_HEIGHT));
            
            // Setup a key callback. It will be called every time
            // a key is pressed, repeated or released.
            glfwSetKeyCallback(display.getWindow(),
                    (dWindow, key, scancode, action, mods) -> {
                        if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE) {
                            // We will detect this in our rendering loop
                            glfwSetWindowShouldClose(dWindow, true);
                        }
                    });

            new MouseHandler();

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
        for (Updatable i : updatables) {
            i.start();
        }
    }

    /**
     * The update/tick function called before drawing/rendering.
     */
    @SuppressWarnings("EmptyMethod")
    protected void update() {
        for (Updatable i : updatables) {
            i.update();
        }
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

    /**
     * Register a new updatable object to call updates on.
     *
     * @param updatable The class, must be updatable.
     */
    public void registerUpdatable(final Updatable updatable) {
        updatables.add(updatable);
    }

    /**
     * Get the position of the mouse on the screen.
     *
     * @return The position of the mouse.
     */
    public Vector2i getMousePosition() {
        DoubleBuffer x = BufferUtils.createDoubleBuffer(1), y = BufferUtils
                .createDoubleBuffer(1);
        glfwGetCursorPos(display.getWindow(), x, y);
        return new Vector2i((int) x.get(), (int) y.get());
    }

}
