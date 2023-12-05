package front;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import eyeglass.*;
import front.PageSelection;
import front.VisuelLense;
import front.VisuelMonture;

public abstract class VisuelProduct extends JPanel {
    private final JPanel infoPanel = new JPanel(new FlowLayout());
    private final JLabel infoLabel = new JLabel();
    private final JButton putButton = new JButton("Put");
    private String name;
    private int iD;
    private String imgsrc;
    private int prix;
    private int stock;
    private PageSelection pageSelection;

    public VisuelProduct() {
    }

    public VisuelProduct(String n, int iD, String iS, int p, int s, PageSelection pS) {
        this.setName(n);
        this.setID(iD);
        this.setImgsrc(iS);
        this.setPrix(p);
        this.setStock(s);
        this.setPageSelection(pS);

        this.setLayout(new BorderLayout());

        this.add(new JButton(iS), BorderLayout.CENTER);
        infoLabel.setText(n + " | Prix: " + p + " | Stock: " + s);
        infoLabel.setFont();
        infoPanel.add(infoLabel);
        infoPanel.add(putButton);
        this.add(this.infoPanel, BorderLayout.SOUTH);

        putButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent action) {
                if (VisuelProduct.this instanceof VisuelMonture) {
                    Monture monture = new Monture(
                            VisuelProduct.this.iD,
                            VisuelProduct.this.name,
                            VisuelProduct.this.imgsrc,
                            VisuelProduct.this.prix,
                            VisuelProduct.this.stock);
                    VisuelProduct.this.pageSelection.updateCurrentMonture(monture);
                }
                if (VisuelProduct.this instanceof VisuelLense) {
                    Lense lense = new Lense(
                            VisuelProduct.this.iD,
                            VisuelProduct.this.name,
                            VisuelProduct.this.imgsrc,
                            VisuelProduct.this.prix,
                            VisuelProduct.this.stock);
                    VisuelProduct.this.pageSelection.updateCurrentLense(lense);
                }
            }
        });
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setID(int i) {
        this.iD = i;
    }

    public void setImgsrc(String img) {
        this.imgsrc = img;
    }

    public void setPrix(int p) {
        this.prix = p;
    }

    public void setStock(int s) {
        this.stock = s;
    }

    public void setPageSelection(PageSelection pS) {
        this.pageSelection = pS;
    }

}
