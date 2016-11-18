package edu.neumont.teamgift.clue.front;

import edu.neumont.teamgift.clue.Vector2i;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

/**
 * LWJGL window.
 */
class Display {

    /**
     * The handle for the window in GLFW.
     */
    private long window;

    /**
     * The width and height of the window.
     */
    private Vector2i size;

    /**
     * Create a new window with specific size.
     *
     * @param windowSize The size of the window.
     */
    Display(final Vector2i windowSize) {
        this.size = windowSize;
        init();
    }

    /**
     * Initialize window, OpenGL, and GLFW.
     */
    private void init() {
        // Setup an error callback. The default implementation
        // will print the error message in System.err.
        GLFWErrorCallback.createPrint(System.err).set();

        // Initialize GLFW. Most GLFW functions will not work before doing this.
        if (!glfwInit())
            throw new IllegalStateException("Unable to initialize GLFW");

        // Configure our window
        glfwDefaultWindowHints(); // optional, the current window hints are already the default
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable

        // Create the window
        window = glfwCreateWindow(size.x, size.y, "Hello World!", NULL, NULL);
        if (window == NULL)
            throw new RuntimeException("Failed to create the GLFW window");

        // Setup a key callback. It will be called every time a key is pressed, repeated or released.
        glfwSetKeyCallback(window, (dWindow, key, scancode, action, mods) -> {
            if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE)
                glfwSetWindowShouldClose(dWindow, true); // We will detect this in our rendering loop
        });

        // Get the resolution of the primary monitor
        GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        // Center our window
        glfwSetWindowPos(
                window,
                (vidmode.width() - size.x) / 2,
                (vidmode.height() - size.y) / 2
        );

        // Make the OpenGL context current
        glfwMakeContextCurrent(window);
        // Enable v-sync
        glfwSwapInterval(1);

        // Make the window visible
        glfwShowWindow(window);

        // This line is critical for LWJGL's inter-operation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current thread,
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use.
        GL.createCapabilities();

        // Set the clear color
        glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
    }

    /**
     * Clear the frame buffer.
     */
    void clear() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
    }

    /**
     * Swap the frame buffers, to display what needs to be drawn.
     */
    void swapBuffers() {
        glfwSwapBuffers(window); // swap the color buffers
    }

    /**
     * Destroy the window and callbacks.
     */
    void destroy() {
        glfwFreeCallbacks(getWindow());
        glfwDestroyWindow(getWindow());
    }

    /**
     * Get the window handle.
     * @return The handle for the window.
     */
    long getWindow() {
        return window;
    }

}
