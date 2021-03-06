package edu.neumont.teamgift.clue.front;

import edu.neumont.teamgift.clue.Vector2i;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.GLFW_FALSE;
import static org.lwjgl.glfw.GLFW.GLFW_RESIZABLE;
import static org.lwjgl.glfw.GLFW.GLFW_TRUE;
import static org.lwjgl.glfw.GLFW.GLFW_VISIBLE;
import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwDefaultWindowHints;
import static org.lwjgl.glfw.GLFW.glfwDestroyWindow;
import static org.lwjgl.glfw.GLFW.glfwGetPrimaryMonitor;
import static org.lwjgl.glfw.GLFW.glfwGetVideoMode;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwSetWindowPos;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwSwapInterval;
import static org.lwjgl.glfw.GLFW.glfwWindowHint;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glColor3d;
import static org.lwjgl.opengl.GL11.glColor3i;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTexCoord2i;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2i;
import static org.lwjgl.system.MemoryUtil.NULL;

/**
 * LWJGL window.
 */
class Display {

    /**
     * The width and height of the window.
     */
    private final Vector2i size;
    /**
     * The handle for the window in GLFW.
     */
    private long window;

    /**
     * Create a new window with specific size.
     *
     * @param windowSize The size of the window.
     */
    @SuppressWarnings("unused") Display(final Vector2i windowSize) {
        this.size = windowSize;
        init();
    }

    /**
     * Initialize window, OpenGL, and GLFW.
     */
    private void init() {
        GLFWErrorCallback.createPrint(System.err).set();

        // Initialize GLFW. Most GLFW functions will not work before doing this.
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        glfwDefaultWindowHints();
        // the window will stay hidden after creation
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

        // Create the window
        window = glfwCreateWindow(size.x, size.y, "Clue", NULL, NULL);
        if (window == NULL) {
            throw new RuntimeException("Failed to create the GLFW window");
        }

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

        GL.createCapabilities();

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        // noinspection CheckStyle
        glOrtho(0, 24 * 16, 25 * 16, 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
        glEnable(GL_DEPTH_TEST);

        // Set the clear color
        glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
    }

    /**
     * Clear the frame buffer.
     */
    void clear() {
        // clear the framebuffer
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
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
     *
     * @return The handle for the window.
     */
    long getWindow() {
        return window;
    }

    /**
     * Draws a sprite to the screen at a specific location.
     *
     * @param position The position to draw it on the screen.
     * @param sprite   The sprite to draw to the screen.
     */
    @SuppressWarnings("CheckStyle")
    void drawSprite(final Vector2i position, final Sprite sprite) {
        glEnable(GL_TEXTURE_2D);

        glPushMatrix();
        {
            glTranslatef(position.x, position.y, 0);

            // Binding textures or colors.
            boolean textured = false;
            if (sprite != null) {
                if (sprite.isColored()) {
                    glColor3d((double) sprite.getColor().x / 255.0,
                            (double) sprite.getColor().y / 255.0,
                            (double) sprite.getColor().z / 255.0);
                } else if (sprite.getTextureID() != -1) {
                    textured = true;
                    glBindTexture(GL_TEXTURE_2D, sprite.getTextureID());
                }
            } else {
                glColor3i(0, 0, 0);
            }

            // Drawing quad.
            glBegin(GL_QUADS);
            {
                if (textured) {
                    glTexCoord2i(0, 0);
                }
                glVertex2i(0, 0);

                if (textured) {
                    glTexCoord2i(0, 1);
                }
                glVertex2i(0, 16);

                if (textured) {
                    glTexCoord2i(1, 1);
                }
                glVertex2i(16, 16);

                if (textured) {
                    glTexCoord2i(1, 0);
                }
                glVertex2i(16, 0);
            }
            glEnd();
        }
        glPopMatrix();

        glDisable(GL_TEXTURE_2D);
    }

}
