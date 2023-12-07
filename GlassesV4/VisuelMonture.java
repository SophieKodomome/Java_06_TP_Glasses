package front;

import java.awt.*;
import javax.swing.*;

import eyeglass.Monture;
import front.ImageMonture;

public class VisuelMonture extends VisuelProduct {
    ImageMonture imageMonture;
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public VisuelMonture() {
    }

    public VisuelMonture(Monture m, PageSelection p) {
        super(m.getName(), m.getID(), m.getImgsrc(), m.getPrix(), m.getStock(), p);
        this.setImageMonture(new ImageMonture(this.getImgSrc(), "1.png"));
        this.getImageMonture().resizeImage(screenSize.width / 4, screenSize.height / 4);
        super.add(this.getImageMonture(), BorderLayout.CENTER);
    }

    public void setImageMonture(ImageMonture i) {
        this.imageMonture = i;
    }

    public ImageMonture getImageMonture() {
        return this.imageMonture;
    }
}
