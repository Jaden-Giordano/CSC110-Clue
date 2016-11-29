package edu.neumont.teamgift.clue;

import edu.neumont.teamgift.clue.front.Sprite;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL12;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

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

public class SpriteLoader {

    private static final int BYTES_PER_PIXEL = 4;

    public static String pathToSprites = "";

    private static Map<String, Sprite> sprites;

    private SpriteLoader() {

    }

    public static void init() {
        sprites = new HashMap<>();
    }

    public static Sprite getSprite(final String path) {
        if (!sprites.containsKey(path)) {
            int tID = -1;
            try {
                BufferedImage image = ImageIO.read(new File(path));
                tID = loadTexture(image);
            } catch (IOException e) {
                System.out.println("Error loading image: " + e.getMessage());
            }
            sprites.put(path, new Sprite(tID));
        }

        return sprites.get(path);
    }

    /**
     * Load texture into graphical memory, and get handle for image.
     *
     * @param image The image to load.
     * @return The handle.
     */
    private static int loadTexture(BufferedImage image) {
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

}
