package front;

import javax.swing.*;
import java.awt.*;

public class ColorLense extends JPanel {

    String hex;
    int width;
    int height;;

    public ColorLense() {
    }

    public ColorLense(String h) {
        this.setHex(h);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(hexToRgb(hex));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    private Color hexToRgb(String hex) {
        if (hex.startsWith("#")) {
            hex = hex.substring(1);
        }

        int r = Integer.parseInt(hex.substring(0, 2), 16);
        int g = Integer.parseInt(hex.substring(2, 4), 16);
        int b = Integer.parseInt(hex.substring(4, 6), 16);

        return new Color(r, g, b);
    }

    public void setHex(String h) {
        this.hex = h;
    }

    public void setWidth(int w) {
        this.width = w;
    }

    public void setHeight(int h) {
        this.height = h;
    }

    public String getHex() {
        return this.hex;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

}
