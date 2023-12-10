package front;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ImageMonture extends JPanel {
    private BufferedImage imageMonture;
    private String direction;
    private String address;
    private String directionAddress;

    public ImageMonture() {
    }

    public ImageMonture(String d, String a) {
        this.setLayout(new FlowLayout());
        this.setDirection(d);
        this.setAddress(a);

        try {
            imageMonture = ImageIO.read(new File(this.getDirection() + this.getAddress()));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ImageMonture(String da) {
        this.setLayout(new FlowLayout());
        this.setDirectionAddress(da);

        try {
            imageMonture = ImageIO.read(new File(this.getDirectionAddress()));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void resizeImage(int width, int height) {
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(this.imageMonture, 0, 0, width, height, null);
        g.dispose();
        this.imageMonture = resizedImage;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawImage(imageMonture, 0, 0, null);
    }

    public void setDirection(String d) {
        this.direction = d;
    }

    public void setAddress(String a) {
        this.address = a;
    }

    public void setDirectionAddress(String da) {
        this.directionAddress = da;
    }

    public String getDirectionAddress() {
        return this.directionAddress;
    }

    public BufferedImage getImage() {
        return this.imageMonture;
    }

    public String getDirection() {
        return this.direction;
    }

    public String getAddress() {
        return this.address;
    }
}
