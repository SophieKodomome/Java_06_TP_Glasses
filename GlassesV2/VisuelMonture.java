package front;

import java.awt.*;
import javax.swing.*;

import eyeglass.Monture;

public class VisuelMonture extends VisuelProduct {
    public VisuelMonture() {
    }

    public VisuelMonture(Monture m, PageSelection p) {
        super(m.getName(), m.getID(), m.getImgsrc(), m.getPrix(), m.getStock(), p);

    }
}
