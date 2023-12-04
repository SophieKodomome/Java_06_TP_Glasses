package front;

import java.awt.*;
import javax.swing.*;

import eyeglass.Monture;

public class VisuelMonture extends JPanel {
    private final JPanel infoPanel = new JPanel(new FlowLayout());
    private final JLabel infoLabel = new JLabel();
    private final JButton putButton = new JButton("Put");

    public VisuelMonture() {
    }

    public VisuelMonture(Monture m) {
        this.setLayout(new BorderLayout());

        this.add(new JButton(m.getImgsrc()), BorderLayout.CENTER);
        infoLabel.setText(m.getName() + " | Prix: " + m.getPrix() + " | Stock: " + m.getStock());

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
