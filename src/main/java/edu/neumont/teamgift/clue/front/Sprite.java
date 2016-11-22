package edu.neumont.teamgift.clue.front;

import edu.neumont.teamgift.clue.Vector3i;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL12;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import static org.lwjgl.opengl.GL11.GL_LINEAR;
import static org.lwjgl.opengl.GL11.GL_RGBA;
import static org.lwjgl.opengl.GL11.GL_RGBA8;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MAG_FILTER;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MIN_FILTER;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_WRAP_S;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_WRAP_T;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_BYTE;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glGenTextures;
import static org.lwjgl.opengl.GL11.glTexImage2D;
import static org.lwjgl.opengl.GL11.glTexParameteri;

/**
 * An image that can be drawn to the screen.
 */
public class Sprite {

    /**
     * Color.
     */
    private final Vector3i color;
    @SuppressWarnings("CheckStyle") private final int BYTES_PER_PIXEL = 4;
    /**
     * If it is colored or if its an image.
     */
    private boolean colored;
    /**
     * The texture id for drawing.
     */
    private int textureID;

    /**
     * Load a sprite from a file.
     *
     * @param pathToFile The path to the image.
     */
    public Sprite(final String pathToFile) {
        textureID = -1;
        try {
            BufferedImage image = ImageIO.read(new File(pathToFile));
            this.textureID = loadTexture(image);
        } catch (IOException e) {
            System.out.println("Error loading image.");
        }

        colored = this.textureID == -1;

        this.color = Vector3i.zero();
    }

    /**
     * Create a sprite that is a solid color.
     *
     * @param sColor The color of the sprite.
     */
    public Sprite(final Vector3i sColor) {
        colored = true;

        this.color = sColor;
    }

    @SuppressWarnings("CheckStyle") private int loadTexture(BufferedImage image) {
        int[] pixels = new int[image.getWidth() * image.getHeight()];
        image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0,
                image.getWidth());

        ByteBuffer buffer = BufferUtils
                .createByteBuffer(image.getWidth() * image.getHeight()
                        * BYTES_PER_PIXEL); //4 for RGBA, 3 for RGB

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int pixel = pixels[y * image.getWidth() + x];
                buffer.put((byte) ((pixel >> 16) & 0xFF));     // Red component
                buffer.put((byte) ((pixel >> 8) & 0xFF));      // Green component
                buffer.put((byte) (pixel & 0xFF));               // Blue component
                buffer.put((byte) ((pixel >> 24)
                        & 0xFF));    // Alpha component. Only for RGBA
            }
        }

        buffer.flip();

        // You now have a ByteBuffer filled with the color data of each pixel.
        // Now just create a texture ID and bind it. Then you can load it using
        // whatever OpenGL method you want, for example:
        int textureID = glGenTextures(); //Generate texture ID
        glBindTexture(GL_TEXTURE_2D, textureID); //Bind texture ID

        //Setup wrap mode
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL12.GL_CLAMP_TO_EDGE);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL12.GL_CLAMP_TO_EDGE);

        //Setup texture scaling filtering
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);

        //Send texel data to OpenGL
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, image.getWidth(), image.getHeight(), 0,
                GL_RGBA, GL_UNSIGNED_BYTE, buffer);
        //Return the texture ID so we can bind it later again
        return textureID;
    }

    /**
     * Gets whether the sprite is a color or an image.
     *
     * @return If color or image.
     */
    public final boolean isColored() {
        return colored;
    }

    /**
     * Get the color of the sprite.
     *
     * @return The color (red, green, blue).
     */
    public final Vector3i getColor() {
        return color;
    }

    /**
     * Get the texture id.
     *
     * @return The texture id.
     */
    public final int getTextureID() {
        return textureID;
    }

}
