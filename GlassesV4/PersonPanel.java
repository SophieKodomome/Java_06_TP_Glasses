package front;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.File;
import java.util.*;

import util.*;
import eyeglass.*;

public class PersonPanel extends JPanel {
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private Rectangle coordinate;
    private String path = "img/person/Young_Dafoe.jpg";
    private ImagePerson imagePerson = new ImagePerson();
    private Monture monture;
    private Lense lense;

    public PersonPanel(Monture m, Lense l) {
        this.setCoordinate(path);
        this.setLayout(new BorderLayout());
        this.setMonture(m);
        this.setLense(l);
        this.setImagePerson(new ImagePerson(path, this.coordinate, this.monture, this.lense));

        // int newWidth = screenSize.width / 3;
        // int newHeight = screenSize.height / 3;

        // this.getImagePerson().resizeImage(newWidth, newHeight);
        // this.getImagePerson().resizeCoordinate(screenSize.width, screenSize.height,
        // newWidth, newHeight);
        this.add(imagePerson, BorderLayout.CENTER);
    }

    public void setCoordinate(String path) {
        this.coordinate = Detector.getFaceGeometry(path);
    }

    public void setImagePerson(ImagePerson imagePerson) {
        this.imagePerson = imagePerson;
    }

    public void setMonture(Monture m) {
        this.monture = m;
    }

    public void setLense(Lense l) {
        this.lense = l;
    }

    public Rectangle getCoordinate() {
        return this.coordinate;
    }

    public ImagePerson getImagePerson() {
        return this.imagePerson;
    }

}
