package edu.neumont.teamgift.clue.front;

import edu.neumont.teamgift.clue.Vector2i;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;

public class FrontEndManager {

    private static FrontEndManager myInstance;

    private Display display;

    public FrontEndManager() {
        myInstance = this;

        try {
            display = new Display(new Vector2i(800, 600));

            loop();

            // Free the window callbacks and destroy the window
            glfwFreeCallbacks(display.getWindow());
            glfwDestroyWindow(display.getWindow());
        } finally {
            // Terminate GLFW and free the error callback
            glfwTerminate();
            glfwSetErrorCallback(null).free();
        }
    }

    private void loop() {


        // Run the rendering loop until the user has attempted to close
        // the window or has pressed the ESCAPE key.
        while ( !glfwWindowShouldClose(display.getWindow()) ) {
            display.clear();

            update();
            draw();

            display.swapBuffers();

            // Poll for window events. The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }

    private void update(){

    }

    private void draw() {

    }

    public static FrontEndManager getInstance() {
        return myInstance;
    }

}