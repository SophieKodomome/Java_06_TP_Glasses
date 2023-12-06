package front;

import java.awt.*;
import javax.swing.*;

import eyeglass.Lense;
import front.ColorLense;

public class VisuelLense extends VisuelProduct {
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    ColorLense colorLense = new ColorLense();

    public VisuelLense() {
    }

    public VisuelLense(Lense l, PageSelection p) {
        super(l.getName(), l.getID(), l.getImgsrc(), l.getPrix(), l.getStock(), p);

        if (l.getHex() == null) {
            super.add(new JButton("Transparent"), BorderLayout.CENTER);
        } else {
            this.setColorLense(new ColorLense(l.getHex()));
            this.colorLense.setWidth(screenSize.width / 4);
            this.colorLense.setHeight(screenSize.height / 2);
            super.add(this.colorLense, BorderLayout.CENTER);
        }
    }

    public void setColorLense(ColorLense c) {
        this.colorLense = c;
    }

    public ColorLense getColorLense() {
        return this.colorLense;
    }
}