package front;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;

import eyeglass.*;
import front.ImageMonture;
import front.PageConfirmation;
import front.VisuelLense;
import front.VisuelMonture;
import connexion.*;

public class PageSelection extends JFrame {
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final JButton title = new JButton("Optic");

    // eyeglass Classes
    private ArrayList<Monture> montureList = DBCon.getListMonture();
    private ArrayList<Lense> lenseList = DBCon.getListLense();
    private Monture montureCurrent = new Monture();
    private Lense lenseCurrent = new Lense();

    // visual Component
    private final GridLayout gridLayout = new GridLayout(0, 3);
    private final JPanel contentPanel = new JPanel(gridLayout);

    private final JScrollPane scrollMonture = new JScrollPane();
    private final ArrayList<VisuelMonture> visuelMontures = new ArrayList<>();
    private final JPanel scrollMonturePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private final JPanel monturePanel = new JPanel(new BorderLayout());

    private final JScrollPane scrollLenses = new JScrollPane();
    private final ArrayList<VisuelLense> visuelLenses = new ArrayList<>();
    private final JPanel scrollLensesPanel = new JPanel(new FlowLayout());
    private final JPanel lensePanel = new JPanel(new BorderLayout());

    private JButton buttonTest = new JButton(montureCurrent.getName() + " & " +
            lenseCurrent.getName());
    private VisuelGlasses visuelGlasses = new VisuelGlasses();
    private final JButton achatButton = new JButton("Buy");
    private final JPanel imagePanel = new JPanel(new GridLayout(2, 0));

    public PageSelection() {
        setTitle("Optic");
        setLayout(new BorderLayout());
        setSize(screenSize.width, screenSize.height);
        gridLayout.setHgap(50);
        add(title, BorderLayout.NORTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (montureCurrent.getName() == null & lenseCurrent.getName() == null) {
            montureCurrent = montureList.get(0);
            lenseCurrent = lenseList.get(0);
            updateVisuelGlasses();
        }

        setScrollMonture();
        setScrollLenses();

        imagePanel.add(visuelGlasses);
        imagePanel.add(achatButton);

        contentPanel.add(imagePanel);
        scrollMonture.setViewportView(scrollMonturePanel);
        scrollLenses.setViewportView(scrollLensesPanel);
        contentPanel.add(scrollMonture);
        contentPanel.add(scrollLenses);
        add(this.contentPanel);

        setVisible(true);

        achatButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent action) {
                setVisible(false);
                PageConfirmation pageConfirmation = new PageConfirmation(PageSelection.this.montureCurrent,
                        PageSelection.this.lenseCurrent);
            }
        });

    }

    private void setScrollMonture() {
        scrollMonturePanel.setLayout(new BoxLayout(scrollMonturePanel, BoxLayout.Y_AXIS));
        int i = 0;

        for (Monture instanceMonture : montureList) {
            VisuelMonture visuelMonture = new VisuelMonture(instanceMonture, this);

            visuelMontures.add(visuelMonture);
            scrollMonturePanel.add(visuelMontures.get(i));

            visuelMontures.get(i).setPreferredSize(new Dimension(screenSize.width / 4, screenSize.height / 4));
            i++;
        }

    }

    private void setScrollLenses() {
        scrollLensesPanel.setLayout(new BoxLayout(scrollLensesPanel, BoxLayout.Y_AXIS));
        int i = 0;

        for (Lense instanceLense : lenseList) {
            VisuelLense visuelLense = new VisuelLense(instanceLense, this);

            visuelLenses.add(visuelLense);
            scrollLensesPanel.add(visuelLenses.get(i));

            visuelLenses.get(i).setPreferredSize(new Dimension(screenSize.width / 4, screenSize.height / 4));
            i++;
        }
    }

    public void setMontureCurrent(Monture m) {
        this.montureCurrent = m;
    }

    public void setMontureLense(Lense l) {
        this.lenseCurrent = l;
    }

    public void updateCurrentMonture(Monture m) {
        setMontureCurrent(m);
        // updateButtonTestText();
        updateVisuelGlasses();
    }

    public void updateCurrentLense(Lense l) {
        setMontureLense(l);
        // updateButtonTestText();
        updateVisuelGlasses();
    }

    // not used
    public void updateButtonTestText() {
        buttonTest.setText(montureCurrent.getName() + " & " + lenseCurrent.getName());
    }

    public void updateVisuelGlasses() {

        VisuelGlasses currentVisuelGlasses = new VisuelGlasses(montureCurrent, lenseCurrent);

        imagePanel.remove(visuelGlasses);

        imagePanel.add(currentVisuelGlasses);
        imagePanel.remove(achatButton);
        imagePanel.add(achatButton);
        revalidate();
        repaint();

        visuelGlasses = currentVisuelGlasses;
    }

}