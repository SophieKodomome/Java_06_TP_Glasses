package front;

import javax.swing.*;
import java.awt.*;

import eyeglass.*;
import front.ImageMonture;

public class VisuelGlasses extends VisuelProduct {
    ImageMonture imageMonture;
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public VisuelGlasses() {
    }

    public VisuelGlasses(Monture m, Lense l) {
        super();
        super.setLayout(new BorderLayout());
        this.setImageMonture(new ImageMonture(m.getImgsrc(), l.getImgsrc()));
        this.getImageMonture().resizeImage(screenSize.width / 4, screenSize.height / 4);
        super.add(this.getImageMonture(), BorderLayout.CENTER);
        // System.out.println(m.getImgsrc() + l.getImgsrc());
    }

    public void setImageMonture(ImageMonture i) {
        this.imageMonture = i;
    }

    public ImageMonture getImageMonture() {
        return this.imageMonture;
    }
}
