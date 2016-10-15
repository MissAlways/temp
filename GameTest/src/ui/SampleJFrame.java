package ui;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author MissAlways
 */
public class SampleJFrame extends JFrame {

    private JPanel basePanel = new JPanel();

    private Color bgColor = Color.BLACK;

    public SampleJFrame() {
        placeComponents();
        basePanel.setBackground(bgColor);

        this.setTitle("Sample Base");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new SampleJFrame();
    }

    private void placeComponents() {
        GroupLayout groupLayout = new GroupLayout(basePanel);
        basePanel.setLayout(groupLayout);

        this.add(basePanel);
    }

}
