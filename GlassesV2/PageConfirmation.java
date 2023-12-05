package front;

import javax.swing.*;

import connexion.DBCon;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

import eyeglass.*;
import front.PageSelection;

public class PageConfirmation extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JButton confirmButton = new JButton("Confirm");
    JButton retourPageButton = new JButton("Retour");
    JTable contentTable = new JTable();
    JPanel footerPanel = new JPanel(new FlowLayout());
    JPanel contentPanel = new JPanel(new FlowLayout());

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

        contentPanel.add(contentTable);
        footerPanel.add(retourPageButton);
        footerPanel.add(confirmButton);

        this.add(contentPanel, BorderLayout.CENTER);
        this.add(footerPanel, BorderLayout.SOUTH);

        confirmButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent action) {
                DBCon.updateStock(m, l);
            }
        });

        retourPageButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent Action) {
                setVisible(false);
                PageSelection pageAchat = new PageSelection();
            }
        });
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}