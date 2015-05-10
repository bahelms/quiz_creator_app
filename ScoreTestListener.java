import java.awt.event.*;
import javax.swing.*;

public class ScoreTestListener implements ActionListener {
  public void actionPerformed(ActionEvent event) {
    JFrame frame = new JFrame("Test Score");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new ScoreTest());
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}

