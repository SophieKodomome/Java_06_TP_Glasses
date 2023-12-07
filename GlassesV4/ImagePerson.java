package front;

import javax.swing.*;

import front.ImageMonture;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import eyeglass.*;

public class ImagePerson extends ImageMonture {
    Rectangle coordinate;
    Monture monture;
    Lense lense;
    BufferedImage overlayGlasses;

    public ImagePerson() {

    }

    public ImagePerson(String da, Rectangle c, Monture m, Lense l) {
        super(da);
        this.setCoordinate(c);
        this.setMonture(m);
        this.setLense(l);

    }

    @Override
    public void paint(Graphics g) {
        try {
            this.setOverlayImage(ImageIO.read(new File(monture.getImgsrc(), lense.getImgsrc())));
        } catch (Exception e) {
            e.printStackTrace();
        }

        super.paint(g);
        Graphics2D graphics2d = (Graphics2D) g;

        graphics2d.drawImage(super.getImage(), 0, 0, null);

        graphics2d.setColor(new Color(6, 214, 160, 128));
        /*
         * graphics2d.fillRect(
         * (int) coordinate.getX(),
         * (int) coordinate.getY(),
         * (int) coordinate.getWidth(),
         * (int) coordinate.getHeight());
         */
        // super.paint(graphics2d);

        if (overlayGlasses != null) {
            BufferedImage resizedOverlay = resizeImage(overlayGlasses, (int) coordinate.getWidth(),
                    (int) coordinate.getHeight());
            graphics2d.drawImage(resizedOverlay, (int) coordinate.getX(), (int) coordinate.getY(), null);
        }
    }

    public void setCoordinate(Rectangle c) {
        this.coordinate = c;
    }

    public void setMonture(Monture m) {
        this.monture = m;
    }

    public void setLense(Lense l) {
        this.lense = l;
    }

    public void setOverlayImage(BufferedImage overlayGlasses) {
        this.overlayGlasses = overlayGlasses;
    }

    public Rectangle getCoordinate() {
        return this.coordinate;
    }

    public void resizeCoordinate(int originalWidth, int originalHeight, int newWidth, int newHeight) {
        double widthRatio = (double) newWidth / originalWidth;
        double heightRatio = (double) newHeight / originalHeight;

        this.coordinate.setBounds(
                (int) Math.floor(this.coordinate.getX() * widthRatio),
                (int) Math.floor(this.coordinate.getY() * heightRatio),
                (int) Math.floor(this.coordinate.getWidth() * widthRatio),
                (int) Math.floor(this.coordinate.getHeight() * heightRatio));

    }

    private BufferedImage resizeImage(BufferedImage ImageGlasses, int x, int y) {
        BufferedImage resizedImage = new BufferedImage(x, y, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(ImageGlasses, 0, 0, x, y, null);
        g.dispose();
        return resizedImage;
    }
}
