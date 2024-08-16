import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Background extends JPanel {
    private BufferedImage image;

    Background(String path) {
        try {
            URL resource = getClass().getResource(path);
            if (resource != null) {
                image = ImageIO.read(resource);
            }
        } catch (Exception e) {
            System.out.println("Error was found. Please try again, or contact me.");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }
}