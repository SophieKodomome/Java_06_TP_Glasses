package front;

import javax.swing.JFrame;
import util.*;

public class Fenetre extends JFrame {

    public Fenetre() {
        new PageSelection();
        try {
            Sound.play("Windows XP Startup");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
