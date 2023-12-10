package front;

import javax.swing.*;

import connexion.DBCon;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

import eyeglass.*;
import front.PageSelection;
import util.*;

public class PageConfirmation extends JFrame {
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final JButton confirmButton = new JButton("Confirm");
    private final JButton retourPageButton = new JButton("Retour");
    private JTable contentTable = new JTable();
    private JPanel footerPanel = new JPanel(new FlowLayout());
    private JPanel contentPanel = new JPanel(new FlowLayout());

    public PageConfirmation(Monture m, Lense l) {
        this.setTitle("Confirm Purchase");
        this.setSize(screenSize.width, screenSize.height);
        this.setLayout(new BorderLayout());

        Object[][] data = {
                { "Monture", "Lenses", "Monture Price", "Lenses Price", "Total Price" },
                { m.getName(), l.getName(), m.getPrix(), l.getPrix(), m.getPrix() + l.getPrix() }
        };

        String[] columnNames = { "Monture", "Lenses", "Monture Price", "Lenses Price", "Total Price" };

        contentTable = new JTable(data, columnNames);

        // this.setPersonPanel();

        PersonPanel personPanel = new PersonPanel(m, l);
        // personPanel.setMonture(m);
        // personPanel.setLense(l);

        contentPanel.add(contentTable);
        footerPanel.add(retourPageButton);
        footerPanel.add(confirmButton);
        this.add(personPanel, BorderLayout.CENTER);
        this.add(contentPanel, BorderLayout.NORTH);
        this.add(footerPanel, BorderLayout.SOUTH);

        confirmButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent action) {
                try {
                    Sound.play("tada");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Purchase successfull!");
                DBCon.updateStock(m, l);
                setVisible(false);
                PageSelection pageAchat = new PageSelection();
            }
        });

        retourPageButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent Action) {
                try {
                    Sound.play("Windows XP Start");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                setVisible(false);
                PageSelection pageAchat = new PageSelection();

            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void setPersonPanel(PersonPanel c) {
        this.contentPanel = c;
    }

}