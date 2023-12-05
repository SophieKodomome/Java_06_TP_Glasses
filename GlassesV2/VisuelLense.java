package front;

import java.awt.*;
import javax.swing.*;

import eyeglass.Lense;

public class VisuelLense extends VisuelProduct {
    public VisuelLense() {
    }

    public VisuelLense(Lense l, PageSelection p) {
        super(l.getName(), l.getID(), l.getImgsrc(), l.getPrix(), l.getStock(), p);
    }
}