package front;

import java.awt.*;
import javax.swing.*;

import eyeglass.Lense;

public class VisuelLense extends JPanel {
    private final JPanel infoPanel = new JPanel(new FlowLayout());
    private final JLabel infoLabel = new JLabel();
    private final JButton putButton = new JButton("Put");

    public VisuelLense() {
    }

    public VisuelLense(Lense l) {
        this.setLayout(new BorderLayout());

        this.add(new JButton(l.getImgsrc()), BorderLayout.CENTER);
        infoLabel.setText(l.getName() + " | " + l.getPrix() + " | " + l.getStock());

        infoPanel.add(infoLabel);
        infoPanel.add(putButton);
        this.add(this.infoPanel, BorderLayout.SOUTH);

        // putButton.addActionListener(new ActionListener() {
        // @Override

        // public void actionPerformed(ActionEvent action) {
        // }
        // });
    }

}