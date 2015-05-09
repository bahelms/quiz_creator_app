// Name: Barrett Helms
// 05/07/15
// Chapters: All
// Final Project

import javax.swing.JFrame;

public class Testing {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Testing");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new Menu(frame));
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}

