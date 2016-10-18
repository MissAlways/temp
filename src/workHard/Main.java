package workHard;

import ui.SampleJFrame;

/**
 *
 * @author dee
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        SampleJFrame frame = new SampleJFrame();

        while (true) {
            frame.moveBall();
            frame.repaint();
            Thread.sleep(10);
        }
    }
}