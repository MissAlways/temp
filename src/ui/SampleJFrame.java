package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author MissAlways
 */
public class SampleJFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel basePanel = new JPanel();

    private Color bgColor = Color.BLACK;

    int x = 0;
    int y = 0;

    public SampleJFrame() {
        placeComponents();
        //basePanel.setBackground(bgColor);

        this.setTitle("Sample Base");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(x, y, 30, 30);
    }

    public void moveBall() {
        x = x + 1;
        y = y + 1;
    }

    private void placeComponents() {
        GroupLayout groupLayout = new GroupLayout(basePanel);
        basePanel.setLayout(groupLayout);

        this.add(basePanel);
    }

}
