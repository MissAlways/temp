/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameTest;

import ui.SampleJFrame;

/**
 *
 * @author dee
 */
public class main {
    public static void main(String[] args) throws InterruptedException {
        SampleJFrame frame = new SampleJFrame();

        while (true) {
            frame.moveBall();
            frame.repaint();
            Thread.sleep(10);
        }
    }
}
